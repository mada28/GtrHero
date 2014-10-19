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
    
    
    public Dot(){}
    
    public Dot(Colours c,long t){
        this.colour = c;
        this.time = t;
        this.position = -1;
    }
    
    public Colours getColour(){
        return this.colour;
    }
    public int getColourPosition(){
        int x = 34;
        switch(this.colour){
            case RED:    return 125-x;
            case YELLOW: return 158-x;
            case BLUE:   return 191-x;
            case ORANGE: return 222-x;
            case GREEN:  return 257-x;
            case PURPLE: return 290-x;
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
}
