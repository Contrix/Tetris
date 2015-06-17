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
    private Color[][] arrayy = {{t, t, t, t}, {c, c, c, c}, {t, t, t, t}, {t, t, t, t}};
    
    public Object2(){
        array = this.arrayy;
        c = this.color;
        point.setPoint(11, 6);
    }
    
    @Override
    public void rotateLeft(){
        Color[][] rotateArray = {{t, t, t, t}, {t, t, t, t}, {t, t, t, t}, {t, t, t, t}};
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                rotateArray[3-j][i] = array[i][j];
            }
        }
        array  = rotateArray;
    }
    
    @Override
    public void rotateRight(){
        Color[][] rotateArray = {{t, t, t, t}, {t, t, t, t}, {t, t, t, t}, {t, t, t, t}};
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                rotateArray[j][3-i] = array[i][j];
            }
        }
        array  = rotateArray;
    }
}
