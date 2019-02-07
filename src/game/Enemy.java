/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import classes.EnemyEntity;
import classes.FriendlyEntity;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject implements EnemyEntity{
    
    Random r = new Random();
    private Textures tex;
    private Game game;
    private Controller c;
    
    private int speed = r.nextInt(3) + 1;
    
    public Enemy(double x, double y, Textures tex, Controller c, Game game){
        super(x, y);
        this.tex = tex;
        this.c = c;
        this.game = game;
    }
    
    public void tick(){
        y+=speed;
        
        //randomise x position after enemy goes off screen
        if(y > (Game.HEIGHT * Game.SCALE)){
            speed = r.nextInt(3) + 1;
            y = -10;
            x = r.nextInt(640);
        }
        
        
        for(int i = 0; i< game.fEnt.size(); i++){
            FriendlyEntity tempEnt = game.fEnt.get(i);
            if(Physics.Collision(this, tempEnt)){
                c.removeEntity(tempEnt); //Remove Bullet on contact with enemy
                c.removeEntity(this); //Remove Enemy when hit
                game.setEnemyKilled(game.getEnemyKilled()+ 1); 
            }
        }
    }
    
    public void render(Graphics g){
        g.drawImage(tex.enemy, (int)x, (int)y, null);
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
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
}
