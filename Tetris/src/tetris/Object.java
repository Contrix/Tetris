/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.lang.reflect.Array;
import javafx.scene.paint.Color;


/**
 *
 * @author Jirka
 */
public class Object {
    private final Color c = Color.AQUA;
    private final Color t = Color.TRANSPARENT;
    private Color[][] array = {{t, c, t}, {c, c, c}};
    private MyPoint point = new MyPoint(3, 3);
    
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
        System.out.println("aaaa");
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
    
}
