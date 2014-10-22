/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero;

import guitarhero.control.Controller;
import guitarhero.view.GuitarHeroView;
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
    }
}