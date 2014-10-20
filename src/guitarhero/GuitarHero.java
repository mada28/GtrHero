/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero;

import guitarhero.control.Controller;
import guitarhero.view.GuitarHeroView;

/*import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;*/

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

/**
 *
 * @author Buddy-1cent
 */
public class GuitarHero {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Zacatek");
        Controller controller = new Controller();
        System.out.println("Po new Controller");
        GuitarHeroView  view = new GuitarHeroView(controller);
        System.out.println("Po new GuitarHeroView");
        view.setVisible(true);
        System.out.println("Po setVisible");
        controller.start();
    /*  
        JFXPanel fxPanel = new JFXPanel();
        Media hit = new Media(new File("asdf.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        System.out.println("Uz to hraje kemo!");
    */
    //S pouzitim dalsi knihovny jl 1.0.1.jar
    }
}