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
    
    public static boolean Collision(FriendlyEntity fEnt, LinkedList<EnemyEntity> eEnt){
        
        for(int i=0; i<eEnt.size(); i++){
            
            if(fEnt.getBounds().intersects(eEnt.get(i).getBounds())){
                return true;
            }   
        }
        return false;
    }
    
    public static boolean Collision(EnemyEntity eEnt, LinkedList<FriendlyEntity> fEnt){
        
        for(int i=0; i<fEnt.size(); i++){
            
            if(eEnt.getBounds().intersects(fEnt.get(i).getBounds())){
                return true;
            }   
        }
        return false;
    }
    
    
    
}
