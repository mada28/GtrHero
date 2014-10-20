/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.control;

import guitarhero.view.GuitarHeroView;
import guitarhero.models.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Buddy-1cent
 */
public class Controller {
    private Song song;
    private GuitarHeroView view; 
    private List<Dot> playingDots;
    private List<Dot> allDots;
    private StopWatch stopWatch;
    private long counter = 0;
    static int index=0;
    private Thread threadDots;
    private Thread threadPlayer;
    private boolean running = false;
    private Player p;
    private boolean[] k;
    private int mistake;
    
    public void initializeGame(){
        //nacteni tecek v Song
        song = new Song();
        allDots = song.getDots();
        k = new boolean[6];
        mistake = 0;
        System.out.println("new song");
    }
    
    public Controller(){
        playingDots = new ArrayList<>();
        stopWatch = new StopWatch();
        allDots = new ArrayList<>();    
    }

    public void setView(GuitarHeroView view) {
        this.view = view;
    }
    
    public void start() {
        initializeGame();
        running = true;
        
        try{
            File song = new File("woman.mp3");
            FileInputStream a = new FileInputStream(song);
            BufferedInputStream b = new BufferedInputStream(a);
            try{
                p = new Player(b);
                }catch(JavaLayerException ex){ System.out.println("Player error"); };
            }catch(IOException e){ System.out.println("Audio File Error"); };
        
        //view.updateModel(song.getDots());
        threadDots = new Thread() {
            @Override
            public void run() {
                while (running) {
                    stopWatch.start();
                    //System.out.println("counter "+counter);
                        for(int i = index;i<index+6;i++){
                            //System.out.println("Som zaseknuty kokot");
                            if(counter == allDots.get(i).getTime()){
                                playingDots.add(allDots.get(i));
                                index++;
                                //System.out.println("Pridavam tecku");
                            }
                        }       
                    for(int i=0;i<playingDots.size();i++){
                   // for(Dot d: playingDots){  
                        playingDots.get(i).move();
                        //System.out.println("Mam tecku");
                        if(playingDots.get(i).getPosition() >= 534){
                            playingDots.remove(playingDots.get(i));
                            //System.out.println("Odebiram tecku");
                        }  
                    }
                    counter += 10;
                    view.updateModel(playingDots);
                    //System.out.println("hej");
                    view.repaint();
                    
                    
                    k = view.getKeys();
                    for(int i=0;i<k.length;i++){
                        if(k[i] == true){
                            boolean m = false;
                            for(Dot dot: playingDots){
                                if(dot.getPosition()>=480 && dot.getPosition()<=520 && dot.getPushed()==0 && dot.getColour().ordinal()==i){
                                    dot.push();
                                    m=true; 
                                    System.out.println("Zmacknut spravny knoflik");
                                    break;
                                }
                                else if(dot.getPosition()>=480 && dot.getPosition()<=520 && dot.getPushed()>0 && dot.getColour().ordinal()==i){
                                    m=false;
                                    System.out.println("Zmacknuto podruhe");
                                }
                            }
                            if(!m) System.out.println("Chyba");
                            
                        }    
                        if(k[i] == false){
                            for(Dot dot: playingDots){
                                if(dot.getPosition()>520 && dot.getPushed()==0 && dot.getColour().ordinal()==i){
                                    dot.mistake();
                                    System.out.println("Nestihl jsi to");
                                }
                            }
                        }
                    }
                    
                    try{
                        Thread.sleep(4);
                    } catch (InterruptedException ex){ System.out.println("Thread Sleep Error"); }
                }
            }
        };
        threadDots.start();
         
        threadPlayer = new Thread() {
            @Override
            public void run() {
                while (running) {
                    try{
                        p.play(1);
                        }catch(JavaLayerException ex){ System.out.println("Player error"); };                     
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex){ System.out.println("Thread Sleep Error"); }
                }
            }
        };
        try{
            threadPlayer.sleep(1300);
        }catch(InterruptedException ex){ System.out.println("Thread Sleep Error"); }
        threadPlayer.start();                
}

    public void stop() {
        running = false;
        
        try {
            threadDots.join();
            threadPlayer.join();
        } catch (InterruptedException ex) { System.out.println("Thread Join Error"); }
     //   objects.clear();
        view.repaint();
    }
    
}



