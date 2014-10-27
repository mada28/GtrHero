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
import java.util.Timer;
import java.util.TimerTask;
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
    static int index;
    private Thread threadPlayer;
    private boolean running = false;
    private Player p;
    private boolean[] k;
    public int mistake;
    public int score;
    public int multi;
    public int hits;
    private final int waiting = 4;
    private TimerTask timerTaskCheckDots;
    private TimerTask timerTaskMoveDots;
    private Timer timerCheckDots;
    private Timer timerMoveDots;
    
    public void initializeGame(){
        index = 0;
        mistake = 0;
        score = 0;
        multi = 10;
        hits = 0;
        //System.out.println("new song");
        stopWatch.start();
    }
    
    public Controller(){
        playingDots = new ArrayList<>();
        stopWatch = new StopWatch();
        allDots = new ArrayList<>();
        song = new Song();
        allDots = song.getDots();
        k = new boolean[6];
        
    }

    public void setView(GuitarHeroView view) {
        this.view = view;
    }
    
    private void chooseDots(){
        int s=6;
        //System.out.println("zacatek "+stopWatch.getElapsedTime());
        if(index >= allDots.size())
            while(index+s>allDots.size()) 
                s--;

        for(int i = index;i<index+s;i++){
            if(Math.abs( stopWatch.getElapsedTime() - allDots.get(i).getTime() )  < waiting+1){
                if(!playingDots.contains(allDots.get(i))){
                    playingDots.add(allDots.get(i));
                    view.updateModel(playingDots);
                    index++;
                    //System.out.println("Pridavam tecku "+stopWatch.getElapsedTime());
                }

            }
        }
    }
    private void moveDots(){
        for(int i=0;i<playingDots.size();i++){ 
            playingDots.get(i).move();
            //System.out.println("Mam tecku");)
            if(playingDots.get(i).getPosition() == 500)
                //System.out.println("TED "+stopWatch.getElapsedTime());
            if(playingDots.get(i).getPosition() >= 534){
                playingDots.remove(playingDots.get(i));
                //System.out.println("Odebiram tecku");
                //System.out.println("Odebiram tecku "+stopWatch.getElapsedTime());

            }  
        }
    }
    private void checkKeys(){
        if((k = view.getKeys()) != null)
        for(int i=0;i<k.length;i++){ 
            if(k[i] == true){
                boolean m = false;
                for(Dot dot: playingDots){
                    if(dot.getPosition()>=450 && dot.getPosition()<=500 && dot.getPushed()==0 && dot.getColour().ordinal()==i){
                        dot.push();
                        m=true;
                        score += multi;
                        hits++;
                        if(hits % 10 == 0 && multi < 100){
                            multi *= 2;
                        }
                        System.out.println("Zmacknut spravny knoflik");
                        break;
                    }
                    /*
                    else if(dot.getPosition()>=430 && dot.getPosition()<=490 && dot.getPushed()>0 && dot.getColour().ordinal()==i){
                        m=false;
                        System.out.println("Zmacknuto podruhe");
                    }
                    */
                }
                k[i] = false;
                if(!m){
                    hits = 0;
                    if(multi > 10)
                        multi /= 2;
                    System.out.println("Chyba");
                }
            }    
            else{
                for(Dot dot: playingDots){
                    if(dot.getPosition()>490 && dot.getPushed()==0 && dot.getColour().ordinal()==i){
                        dot.mistake();
                        mistake++;
                        hits = 0;
                        if(multi > 10)
                            multi /= 2;
                        System.out.println("Nestihl jsi to");
                    }
                }
            }
        }    
    }
    
    public void start() {
        initializeGame();
        running = true;
        
        timerTaskMoveDots = new TimerTask(){
            @Override
            public void run(){
                if(running){
                    moveDots();
                    view.repaint();
                }
            }
        };
        
        timerTaskCheckDots = new TimerTask(){
            @Override
            public void run(){

               // System.out.println("cas "+stopWatch.getElapsedTime()+"\n"+multi++);
                if(running) {
                    chooseDots();
                    checkKeys();
                    view.setScore(score);
                }
            }  
        };
        timerCheckDots = new Timer(true);
        timerCheckDots.schedule(timerTaskCheckDots, 0, 1);
        timerMoveDots = new Timer(true);
        timerMoveDots.schedule(timerTaskMoveDots,0,9);
        
        try{
            File song = new File("SNA.mp3");
            FileInputStream a = new FileInputStream(song);
            BufferedInputStream b = new BufferedInputStream(a);
            try{
                p = new Player(b);
                }catch(JavaLayerException ex){ System.out.println("Player error"); }
            }catch(IOException e){ System.out.println("Audio File Error"); }
        
        threadPlayer = new Thread() {
            @Override
            public void run() {
                while (running) {
                    System.out.println("Pred player "+stopWatch.getElapsedTime());
                    try{
                        p.play(1);
                        }catch(JavaLayerException ex){ System.out.println("Player error"); }      
                    System.out.println("stopky2  " + stopWatch.getElapsedTime());
                    System.out.println("Po player "+stopWatch.getElapsedTime());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex){ System.out.println("Thread Sleep Error"); }
                }
            }
        };
        try{
            threadPlayer.sleep(2000);
        }catch(InterruptedException ex){ System.out.println("Thread Sleep Error"); }
        threadPlayer.start();              
}

    public void stop() {
        running = false;
        playingDots.clear();
        stopWatch.stop();
        try{
            threadPlayer.join();
            timerMoveDots.cancel();
            timerCheckDots.cancel();
        }catch(InterruptedException ex){ System.out.println("Thread Join/Timer Cancel Error"); }

        view.repaint();
    }
    
}



