/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import classes.EnemyEntity;
import classes.FriendlyEntity;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author Liam
 */
public class Game extends Canvas implements Runnable{
    
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH/12*9;
    public static final int SCALE = 2;
    public static final String TITLE = "Game title";
    
    private boolean running = false;
    private Thread thread;
    
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;
    
    private boolean isShooting = false;
    
    private int enemyCount = 10;
    private int enemyKilled = 0;
    
    private Player p;
    private Controller c;
    private Textures tex;
    
    public LinkedList<FriendlyEntity> fEnt;
    public LinkedList<EnemyEntity> eEnt;
    
    //initialise
    public void init(){
        
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        
        //load spriteSheet
        try{
            spriteSheet = loader.loadImage("/spriteSheet.png");
            background = loader.loadImage("/background.png");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        tex = new Textures(this);
        p = new Player(200, 200, tex);
        c = new Controller(tex, this);
        
        //key loop
        this.addKeyListener(new KeyInput(this));
        
        c.createEnemy(enemyCount);
        
        fEnt = c.getFriendlyEntities();
        eEnt = c.getEnemyEntities();

        
    }
    
    private synchronized void start(){
        if(running) 
            return;//ensures that if thread is running no sync issues
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    //
    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0; //60 frames per second
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            
            if(delta>=1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            //calculates FPS every second
            if(System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                System.out.println(updates + "Ticks, " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    
    //Everything in the game that updates
    private void tick(){
        p.tick();
        c.tick();
        
        if(enemyKilled >= enemyCount){
            enemyCount +=2;
            enemyKilled = 0;
            c.createEnemy(enemyCount);
        }
    }
    
    
    //Everything in the game that renders
    private void render() {
        
        //Handles the buffereing behind the scemes
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3); //buffereing 2 layers behind 
            return;
        }
        
        Graphics g = bs.getDrawGraphics(); //Draws ou the buffers
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        g.drawImage(background, 0, 0, null);
        
        
        p.render(g);
        c.render(g);
        
        g.dispose();
        bs.show();
    }
    
    public static void main(String args[]){
        Game game = new Game();
        
        game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT){
            p.setVelX(5);
        }else if(key == KeyEvent.VK_LEFT){
            p.setVelX(- 5);
        }else if(key == KeyEvent.VK_DOWN){
            p.setVelY(5);
        }else if(key == KeyEvent.VK_UP){
            p.setVelY(- 5);
        }else if(key == KeyEvent.VK_SPACE && !isShooting){
            isShooting = true;
            c.addEntity(new Bullet(p.getX(), p.getY(), tex, this));
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT){
            p.setVelX(0);
        }else if(key == KeyEvent.VK_LEFT){
            p.setVelX(0);
        }else if(key == KeyEvent.VK_DOWN){
            p.setVelY(0);
        }else if(key == KeyEvent.VK_UP){
            p.setVelY(0);
        }else if(key == KeyEvent.VK_SPACE){
            isShooting = false;
        }
    }
    
    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }
    
    public int getEnemyCount(){
        return enemyCount;
    }
    
    public int getEnemyKilled(){
        return enemyKilled;
    }
    
    public void setEnemyCount(int enemyCount){
        this.enemyCount = enemyCount;
    }
    
    public void setEnemyKilled(int enemyKilled){
        this.enemyKilled = enemyKilled;
    }
    
    
}
