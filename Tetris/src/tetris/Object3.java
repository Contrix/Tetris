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
public class Object3 extends Object{
    private final Color color = Color.PURPLE;
    private Color[][] arrayy = {{t, c, t}, {c, c, c}, {t, t, t}};
    
    public Object3(){
        array = this.arrayy;
        c = this.color;
    }
}
