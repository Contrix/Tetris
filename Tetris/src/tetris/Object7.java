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
public class Object7 extends Object{
    private final Color color = Color.RED;
    private Color[][] arrayy = {{c, c, t}, {t, c, c}};
    
    public Object7(){
        array = this.arrayy;
        c = this.color;
    }
}
