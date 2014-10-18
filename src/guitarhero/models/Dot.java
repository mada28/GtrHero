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
        int x = 40;
        switch(this.colour){
            case RED:    return 115-x;
            case YELLOW: return 150-x;
            case BLUE:   return 182-x;
            case ORANGE: return 212-x;
            case GREEN:  return 245-x;
            case PURPLE: return 278-x;
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
