/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import classes.EnemyEntity;
import classes.FriendlyEntity;
import java.util.LinkedList;

/**
 *
 * @author Liam
 */
public class Physics {
    
    public static boolean Collision(FriendlyEntity fEnt, EnemyEntity eEnt){
        
        if(fEnt.getBounds().intersects(eEnt.getBounds())){
            return true;
        }   
        
        return false;
    }
    
    public static boolean Collision(EnemyEntity eEnt, FriendlyEntity fEnt){
                  
        if(eEnt.getBounds().intersects(fEnt.getBounds())){
            return true;
        }
        return false;
    }
    
    
    
}
