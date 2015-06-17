/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.scene.paint.Color;


/**
 *
 * @author Jirka
 */
public class Object {
    protected final Color t = Color.TRANSPARENT;
    protected Color c; 
    protected Color[][] array;
    protected MyPoint point = new MyPoint(12, 6);
    protected boolean activ = true;
    
    public Color[][] getArray(){
        return (array);
    }
    
    public MyPoint getPoint(){
        return(point);
    }
    
    public Color getColor(){
        return(c);
    }
    
    public void rotateLeft(){
        Color[][] rotateArray = {{t, t, t}, {t, t, t}, {t, t, t}};
        for (int i = 0; i < getArray().length; i++){
            for (int j = 0; j < getArray()[0].length; j++){
                rotateArray[2-j][i] = array[i][j];
            }
        }
        array  = rotateArray;
    }
    
    public void rotateRight(){
        Color[][] rotateArray = {{t, t, t}, {t, t, t}, {t, t, t}};
        for (int i = 0; i < getArray().length; i++){
            for (int j = 0; j < getArray()[0].length; j++){
                rotateArray[j][2-i] = array[i][j];
            }
        }
        array  = rotateArray;
    }
    
    public void moveDown(){
        point.incY();
    }
    
    public void moveLeft(){
        point.decX();
    }
    
    public void moveRight(){
        point.incX();
    }
    
    public void deactivate(){
        activ = false;
        //dodělat
    }
    
    public void removeRow(int y){
        for (int i = getArray().length; i >= 0; i--){
            for (int j = 0; j < getArray()[0].length ; j++){
                if (i <= y){
                    if (i > 0){
                        getArray()[i][j] = getArray()[i-1][j];
                    }
                    else{
                        getArray()[i][j] = t;
                    }
                }
            }
        }
    }
}
