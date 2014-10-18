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
    private int time;
    private int position;
    
    
    public Dot(){}
    
    public Dot(Colours c,int t){
        this.colour = c;
        this.time = t;
        this.position = -1;
    }
    
    public Colours getColour(){
        return this.colour;
    }
    public int getColourPosition(){
        switch(this.colour){
            case RED:    return 100;
            case YELLOW: return 150;
            case BLUE:   return 200;
            case ORANGE: return 250;
            case GREEN:  return 300;
            case PURPLE: return 350;
            default: return 0;
        }
    }
    public int getTime(){
        return this.time;
    }
    public int getPosition(){
        return this.position;
    }
    public void move(){
        this.position++;
    }
}
