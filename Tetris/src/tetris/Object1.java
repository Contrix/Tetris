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
public class Object1 extends Object{
    private final Color color = Color.YELLOW;
    private Color[][] arrayy = {{c, c}, {c, c}};
    
    public Object1(){
        array = this.arrayy;
        c = this.color;
    }
    
    @Override
    public void rotateLeft(){
    }
    
    @Override
    public void rotateRight(){
    }
}
