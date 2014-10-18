/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.control;

import guitarhero.view.GuitarHeroView;
import guitarhero.models.*;

import java.util.List;

/**
 *
 * @author Buddy-1cent
 */
public class Controller {
    private Song song;
    private GuitarHeroView view; 
    
    public void initializeGame(){
        //nacteni tecek v Song
        song = new Song();
        System.out.println("new song");
    }
    
    public Controller(){
    }

    private Thread thread;
    private boolean running = false;

    public void setView(GuitarHeroView view) {
        this.view = view;
    }
    
    public void start() {
        initializeGame();
        running = true;
        view.updateModel(song.getDots());
        thread = new Thread() {
            @Override
            public void run() {
                while (running) {
                    for(Dot d: song.getDots())
                        d.move();
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



