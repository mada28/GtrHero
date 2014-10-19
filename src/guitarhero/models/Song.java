/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Buddy-1cent
 */
public class Song {
    final private String name;
    final private int tempo;
    final private int length;
    public List<Dot> dots;

    
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    
    public Song(){
        this.name = "TestSong";
        this.tempo = 100;
        this.length = 1000;
        dots = new ArrayList<Dot>();
            this.dots.add(new Dot(Colours.RED,10000));
            this.dots.add(new Dot(Colours.YELLOW,3000));
            this.dots.add(new Dot(Colours.BLUE,3500));
    //    for(int i=0;i<10;i++)
    //        this.dots.add(new Dot(randomEnum(Colours.class),(i+1)*1000));

    }
    public Song(String n,int t,int l,String d){
        this.name = n;
        this.tempo = t;
        this.length = l;
        //nacist tecky ze souboru d
        this.dots = null;
    }
    public String getName(){
        return this.name;
    }
    public int getTempo(){
        return this.tempo;
    }
    public int getLength(){
        return this.length;
    }
    public List<Dot> getDots(){
        return this.dots;
    }
    
}