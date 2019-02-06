/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import classes.FriendlyEntity;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Player extends GameObject implements FriendlyEntity{
    
    //Allows for smoother movement
    private double velX = 0;
    private double velY = 0;
    
    private Textures tex;
    
    
    public Player(double x, double y, Textures tex){
        super(x, y);
        this.tex = tex;
    }
    
    
    //Update method
    public void tick(){
        x+=velX;
        y+=velY;
        
        if(x <= 0)
            x=0;
        if(x >=640 - 16)
            x=640 - 16;
        if(y <= 0)
            y = 0;
        if(y >= 480 - 32)
            y = 480 - 32;
        
    }
    
    //render image
    public void render(Graphics g){
        g.drawImage(tex.player, (int)x, (int)y, null);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setVelX(double velX){
        this.velX = velX;
    }
    
    public void setVelY(double velY){
        this.velY = velY;
    }
    
    public double getVelX(){
        return velX;
    }
    
    public double getVelY(){
        return velY;
    }
        
}
