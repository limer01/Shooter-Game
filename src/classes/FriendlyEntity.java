/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * Classes that implement friendly entity do NOT collide with each other
 *
 */
public interface FriendlyEntity {
    
    public void tick();
    public void render(Graphics g);
     public Rectangle getBounds();
    
    public double getX();
    public double getY();

   
}
