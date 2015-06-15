/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;

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
    private boolean pause = false;
    private boolean move = true;
    
    
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
        if (isDown()){
            newObject();
        }
        else{
            obj.moveDown();
        }
        if(checkCompletedLine())
        {
            //body ++
        }
    }

    private boolean isDown(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getY()+i >=19){
                        return true;
                    }
                    if(isThereObject(obj.getPoint().getX() + j, obj.getPoint().getY()+i+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean checkCompletedLine(){
        for (int i = 0; i < 10; i++){
            if(!isThereObject(i, 19)){
                return false;
            }
        }
        for (Object o : objects){
            if (o.getPoint().getY() >= 20){
                objects.remove(o);
            }
            else{
                o.moveDown();
            }
        }
        return true;
    }
    
    
    public void moveLeft(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getX()+j <= 0){
                        move = false;
                    }
                    else if(isThereObject(obj.getPoint().getX() + j - 1, obj.getPoint().getY()+i)){
                        move = false;
                    }
                }
            }
        }
        if (move){
            obj.moveLeft();
        }
        move  = true;
    }
    
    public void moveRight(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getX()+j >= 9){
                        move = false;
                    }
                    else if(isThereObject(obj.getPoint().getX() + j + 1, obj.getPoint().getY()+i)){
                        move = false;
                    }
                }
            }
        }
        if (move){
            obj.moveRight();
        }
        move  = true;
    }
    
    public void rotateLeft(){
        obj.rotateLeft();
        checkRotate();
    }
    
    public void rotateRight(){
        obj.rotateRight();
        checkRotate();
    }
    
    private void checkRotate(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    while(obj.getPoint().getX()+j < 0){
                        obj.moveRight();
                    }
                    while(obj.getPoint().getX()+j > 9){
                        obj.moveLeft();
                    }
                }
            }
        }
    }
    
    private boolean isThereObject(int x, int y){
        for (Object o : objects){
            if (obj != o){
                for (int i = 0; i < o.getArray().length; i++){
                    for (int j = 0; j < o.getArray()[0].length; j++){
                        if (o.getArray()[i][j] != Color.TRANSPARENT){
                            //System.out.println(i + " - " + j);
                            if(x == j + o.getPoint().getX() && y == i + o.getPoint().getY()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;        
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
    
    public boolean pause(){
        pause = !pause;
        return pause;
    }
    
    public ArrayList<Object> getObjects(){
        return (objects);
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
