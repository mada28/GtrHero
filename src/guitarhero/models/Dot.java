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
public class Dot{
    final private Colours colour;
    final private int time;
    private int position;
    
    public Dot(Colours c,int t){
        this.colour = c;
        this.time = t;
        this.position = -1;
    }
    
    public Colours getColour(){
        return this.colour;
    }
    public int getTime(){
        return this.time;
    }
    public int getPosition(){
        return this.position;
    }
    public void Move(){
        this.position++;
    }
}
