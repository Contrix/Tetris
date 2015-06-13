/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jirka
 */
public class Game {
    Random random = new Random();
    private boolean gameOver = false;
    private static ArrayList<Object> objects = new ArrayList<>();
    private int[] time = {0,0};
    private int level = 0;
    private int score = 0;
    private int lines = 0;
    private static Object obj = new Object3();
    
    
    public void newObject(){
    switch(random.nextInt(6)){
            case 0:
                obj = new Object1();
                break;
            case 1:
                obj = new Object2();
                break;
            case 2:
                obj = new Object3();
                break;
            case 3:
                obj = new Object4();
                break;
            case 4:
                obj = new Object5();
                break;
            case 5:
                obj = new Object6();
                break; 
            case 6:
                obj = new Object7();
                break;
        }
        objects.add(obj);
    }
    
    public void next(){
        obj.moveDown();
        isDown();
        isUnder();
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
    
    private void isUnder(){
        if (obj.getPoint().getY() >= 20){
            objects.remove(obj);
            newObject();
        }
    }
    
    private void isDown(){
        
    }
    
    public void moveDown(){
        obj.moveDown();
    }
    
    public void moveLeft(){
        if (obj.getPoint().getX()>0){
            obj.moveLeft();
        }
    }
    
    public void moveRight(){
        if (obj.getPoint().getX()+obj.getArray().length < 10){
            obj.moveRight();
        }
    }
    
    public void reset(){
        time[0] = 0;
        time[1] = 0;
        level = 0;
        score = 0;
        lines = 0;
        objects.clear();
        newObject();
    }
}
