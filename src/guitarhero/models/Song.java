/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.models;

/**
 *
 * @author Buddy-1cent
 */
public class Song {
    final private String name;
    final private int tempo;
    final private int length;
    final public Dot[] dots;
    
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
    
}
