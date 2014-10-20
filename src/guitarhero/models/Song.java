/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 *
 * @author Buddy-1cent
 */
public class Song {
    final private String name;
    final private int tempo;
    final private int length;
    public List<Dot> dots;
    public static final int NOTE_ON = 0x90;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    
   
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    
    public Song(){
        this.name = "TestSong";
        this.tempo = 100;
        this.length = 1000;
        dots = new ArrayList<>();
        //this.dots.add(new Dot(Colours.RED,10000));
 //       for(int i=0;i<10;i++)
 //           this.dots.add(new Dot(randomEnum(Colours.class),new Random().nextInt(10000)));   
        this.midiConvert();
    }
    public Song(String n,int t,int l,String d){
        this.name = n;
        this.tempo = t;
        this.length = l;
        this.midiConvert(d);
    }
    
    final public void midiConvert(){
        int d = 0;
            Sequence sequence;
        try {
            sequence = MidiSystem.getSequence(new File("test1.mid"));
        
        for (Track track :  sequence.getTracks()) {
            if(track.size() < 10){
                sequence.deleteTrack(track);
                continue;
            }
                        
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    
                    if (sm.getCommand() == NOTE_ON) {
                        //System.out.print("@" + event.getTick() + " ");
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                       
                        if(key < 45)        this.dots.add(new Dot(Colours.RED,event.getTick(),0)); 
                        else if(key < 50)   this.dots.add(new Dot(Colours.YELLOW,event.getTick(),0));
                        else if(key < 55)   this.dots.add(new Dot(Colours.BLUE,event.getTick(),0));
                        else if(key < 60)   this.dots.add(new Dot(Colours.ORANGE,event.getTick(),0));
                        else if(key < 65)   this.dots.add(new Dot(Colours.GREEN,event.getTick(),0));
                        else                this.dots.add(new Dot(Colours.PURPLE,event.getTick(),0));
                              
                        String noteName = NOTE_NAMES[note];
                        System.out.println( dots.get(d).getTime()+" "+ dots.get(d).getPosition() );
                        d++;  
                        System.out.println( event.getTick()+ " " + noteName + octave );
                    } 
                } 
                
            }

        }
        } catch (InvalidMidiDataException | IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Midi File Error");
        } 
    }

    final public void midiConvert(String midiFile){
        int d=0;
        Sequence sequence;
        try {
            sequence = MidiSystem.getSequence(new File(midiFile));
        
        for (Track track :  sequence.getTracks()) {
            if(track.size() < 10){
                sequence.deleteTrack(track);
                continue;
            }
            
            
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    
                    if (sm.getCommand() == NOTE_ON) {
                        //System.out.print("@" + event.getTick() + " ");
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                       
                        if(key < 45)        this.dots.add(new Dot(Colours.RED,event.getTick(),0)); 
                        else if(key < 50)   this.dots.add(new Dot(Colours.YELLOW,event.getTick(),0));
                        else if(key < 55)   this.dots.add(new Dot(Colours.BLUE,event.getTick(),0));
                        else if(key < 60)   this.dots.add(new Dot(Colours.ORANGE,event.getTick(),0));
                        else if(key < 65)   this.dots.add(new Dot(Colours.GREEN,event.getTick(),0));
                        else                this.dots.add(new Dot(Colours.PURPLE,event.getTick(),0));
                              
                        String noteName = NOTE_NAMES[note];
                        System.out.println( dots.get(d).getTime()+" "+ dots.get(d).getPosition() );
                        d++;  
                        System.out.println( event.getTick()+ " " + noteName + octave );
                    } 
                } 
                
            }

        }
        } catch (InvalidMidiDataException | IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Midi File Error");
        }
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