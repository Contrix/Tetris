/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jirka
 */
public class Game {
    private boolean gameOver = false;
    private static ArrayList<Object> objects = new ArrayList<>();
    private int[] time = {0,0};
    private int level = 0;
    private int score = 0;
    private int lines = 0;
    private static Object obj = new Object();
    
    
    public void newObject(){
    objects.add(obj);
    }
    
    public void next(){
        obj.moveDown();
    }
    
    public ArrayList<Object> getObjects(){
        return (objects);
    }
    
    public Object getObject(){
        return(obj);
    }
    
    public void setTime(){
        
    }
    
    public int[] getTime(){
        return (time);
    }
    
    public int getLevel(){
        return (level);
    }
    
    public int getScore(){
        return (score);
    }
    
    public int getLines(){
        return(lines);
    }
    
    public boolean getGameOver(){
        return (gameOver);
    }
    
    public void setGameOver(){
        gameOver = true;
    }
}
