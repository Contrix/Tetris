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
public class Object2 extends Object{
    private final Color color = Color.AQUA;
    private Color[][] arrayy = {{c}, {c}, {c}, {c}};
    
    public Object2(){
        array = this.arrayy;
        c = this.color;
    }
    
    @Override
    public void rotateLeft(){
        Color[][] rotateArray = {{t, t, t, t}, {t, t, t, t}, {t, t, t, t}};
        for (int i = 0; i < getArray().length; i++){
            for (int j = 0; j < getArray()[0].length; j++){
                rotateArray[j][2-i] = array[i][j];
            }
        }
        array  = rotateArray;
        
    }
    
    @Override
    public void rotateRight(){
    }
}
