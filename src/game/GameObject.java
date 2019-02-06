/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Rectangle;

/**
 *
 * @author Liam
 */
public class GameObject {
    
    public double x, y;
    
    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    //returns border around objects in game
    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, width, height);
    }
    
}
