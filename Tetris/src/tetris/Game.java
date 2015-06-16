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
    private static int[] time = {0,0};
    private static int level;
    private static int score;
    private static int lines;
    private static Object obj;
    private static Object nextObj;
    private boolean pause = false;
    private boolean move = true;
    
    public void newGame(){
        objects.clear();
        obj = newObject();
        objects.add(obj);
        obj.getPoint().setPoint(3, 0);
        nextObj = newObject();
        time[0] = 0;
        time[1] = 0;
        level = 0;
        score = 0;
        lines = 0;
        gameOver = false;
    }
    
    public void nextObject(){
        obj = nextObj;
        nextObj = newObject();
        obj.getPoint().setPoint(3, 0);
        objects.add(obj);
    }
    
    private Object newObject(){
        switch(random.nextInt(7)){
            case 0:
                return new Object1();
            case 1:
                return new Object2();
            case 2:
                return new Object3();
            case 3:
                return new Object4();
            case 4:
                return new Object5();
            case 5:
                return new Object6();
            case 6:
                return new Object7();
            default:
                return new Object1();
        }
    }
    
    public void next(){
        if (isDown()){
            checkGameOver();
            if(!gameOver){
                nextObject();
            }
            
        }
        else{
            obj.moveDown();
        }
        if(checkLine(19)){//checkCompletedLine()
            for (Object o : objects){
                if (o.getPoint().getY() >= 20){
                    o.deactivate();
                }
                else{
                    o.moveDown();
                }
            }
        }
    }

    private boolean isDown(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getY()+i >=19){
                        return true;
                    }
                    else if(isThereObject(obj.getPoint().getX() + j, obj.getPoint().getY()+i+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean checkCompletedLine(){
        for (int i = 0; i < 20; i++){
            if(checkLine(i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkLine(int y){
        for (int i = 0; i < 10; i++){
            if(!isThereObject(i, y)){
                return false;
            }
        }
        lines ++;
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
        if (!validRotate()){
            obj.rotateRight();
        }
    }
    
    public void rotateRight(){
        obj.rotateRight();
        if(!validRotate()){
            obj.rotateLeft();
        }
    }
    
    private boolean validRotate(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getX()+j < 0 || obj.getPoint().getX()+j > 9){
                        return false;
                    }
                    if(isThereObject(obj.getPoint().getX() + j, obj.getPoint().getY() + i))
                        return false;
                }
            }
        }
        return true;
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
    
    public boolean pause(){
        pause = !pause;
        return pause;
    }
    
    public ArrayList<Object> getObjects(){
        return (objects);
    }
  
    public void setTime(){
        time[0] ++;
        if(time[0] == 60)
        {
            time[0] = 0;
            time[1] ++;
        }
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
    
    public boolean isGameOver(){
        return (gameOver);
    }
    
    private void checkGameOver(){
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if(obj.getPoint().getY() + i <= 0){
                        gameOver = true;/*
                        System.out.println("check");                        
                        objects.remove(obj);
                        nextObj = obj;*/
                    }
                }
            }
        }        
    }
    
    public Object getNextObejct(){
        return nextObj;
    }
}
