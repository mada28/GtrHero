/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.control;

import guitarhero.view.GuitarHeroView;
import guitarhero.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

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
    
    public void initializeGame(){
        //nacteni tecek v Song
        song = new Song();
        allDots = song.getDots();
        System.out.println("new song");
    }
    
    public Controller(){
        playingDots = new ArrayList<>();
        stopWatch = new StopWatch();
        allDots = new ArrayList<>();    
    }

    private Thread thread;
    private boolean running = false;

    public void setView(GuitarHeroView view) {
        this.view = view;
    }
    
    public void start() {
        initializeGame();
        running = true;
        stopWatch.start();
        
        //view.updateModel(song.getDots());
        thread = new Thread() {
            @Override
            public void run() {
                while (running) {
                    for(Dot dot: song.getDots()){ //zkouska: prochazeni vsech tecek (je tam jedna) a pokud tecka dosahne 400 zastavi stopky
                        
                        if(stopWatch.getElapsedTime() >= dot.getTime()-2000 && stopWatch.getElapsedTime() < dot.getTime() - 1901 ){
                            playingDots.add(dot);
                            System.out.println("hejhej");
                        }
                        if(stopWatch.getElapsedTime() > dot.getTime()+1000){
                            playingDots.remove(dot);
                        }
                    }
                    System.out.println("Cas stopek: "+stopWatch.getElapsedTime()); //Pomocny vypis stopek
                    for(Dot d: playingDots){
                        d.move();
                        System.out.println("Mam tecku");
                    }
                    view.updateModel(playingDots);
                    System.out.println("hej");
                    view.repaint();

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                   }
                }
            }
        };
        thread.start();
    }

    public void stop() {
        running = false;
        
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
     //   objects.clear();
        view.repaint();
    } 
}



