/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Liam
 */
public class KeyInput extends KeyAdapter{
    
    Game game;
    
    public KeyInput(Game game) {
        this.game = game;
    }
    
    
    //Calls methods in game so key input can always be accessed
    @Override
    public void keyPressed(KeyEvent e){
        game.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }
    
}
