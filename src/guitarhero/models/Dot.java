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
    private Colours colour;
    private long time;
    private int position;
    private int pushed;
    
    public Dot(){}
    
    public Dot(Colours c,long t,int p){
        this.colour = c;
        this.time = t;
        this.position = p-34;
        this.pushed = 0;
    }  
    public Colours getColour(){
        return this.colour;
    }
    public int getColourPosition(){
        switch(this.colour){
            case RED:    return 91;
            case YELLOW: return 124;
            case BLUE:   return 157;
            case ORANGE: return 190;
            case GREEN:  return 223;
            case PURPLE: return 256;
            default: return 0;
        }
    }
    public long getTime(){
        return this.time;
    }
    public int getPosition(){
        return this.position;
    }
    public void move(){
        this.position++;
    }
    public int getPushed(){
        return this.pushed;
    }
    public void mistake(){
        this.pushed = 2;
    }
    public void push(){
        this.pushed = 1;
    }
}
