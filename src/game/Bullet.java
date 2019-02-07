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

public class Bullet extends GameObject implements FriendlyEntity{
    
    private Textures tex;
    Game game;
    
    public Bullet(double x, double y, Textures tex, Game game){
        super(x, y);
        this.tex = tex;  
        this.game = game;
    }
    
    public void tick(){
        y-=10;
    }
    
    public void render(Graphics g){
        g.drawImage(tex.missile, (int)x, (int)y, null);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
    public double getY() {
        return y;
    }
    
    public double getX(){
        return x;
    }
    
    
}
