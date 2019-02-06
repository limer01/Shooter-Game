/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import classes.EnemyEntity;
import classes.FriendlyEntity;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Liam
 */
public class Controller {
    
    private LinkedList<FriendlyEntity> friendlyEntityList = new LinkedList<FriendlyEntity>();
    private LinkedList<EnemyEntity> enemyEntityList = new LinkedList<EnemyEntity>();
    
    FriendlyEntity fEnt;
    EnemyEntity eEnt;
    
    Textures tex;
    Random r = new Random();
    private Game game;
    
    public Controller(Textures tex, Game game){
        this.tex = tex;
        this.game = game;
    }
    
    public void createEnemy(int enemyCount){
        for(int i = 0; i<enemyCount; i++){
            addEntity(new Enemy(r.nextInt(640), -10, tex, this, game));
        }
    }
    
    public void tick(){
        //Friendly Entit
        for(int i = 0; i < friendlyEntityList.size(); i++){
            fEnt = friendlyEntityList.get(i);
            
            fEnt.tick();
        }
        
        //Enemy Entity
        for(int i = 0; i < enemyEntityList.size(); i++){
            eEnt = enemyEntityList.get(i);
            
            eEnt.tick();
        }
    }
    
    public void render(Graphics g){
        //Friendly Entity
        for(int i = 0; i < friendlyEntityList.size(); i++){
            fEnt = friendlyEntityList.get(i);
            
            fEnt.render(g);
        }
        
        //Enemy Entity
        for(int i = 0; i < enemyEntityList.size(); i++){
            eEnt = enemyEntityList.get(i);
            
            eEnt.render(g);
        }
    }
    
    //Friendly Entity 
    public void addEntity(FriendlyEntity e){
        friendlyEntityList.add(e);
    }
    
    public void removeEntity(FriendlyEntity e){
        friendlyEntityList.remove(e);
    }
    
    //Enemy Entity
    public void addEntity(EnemyEntity e){
        enemyEntityList.add(e);
    }
    
    public void removeEntity(EnemyEntity e){
        enemyEntityList.remove(e);
    }
    
    public LinkedList<FriendlyEntity> getFriendlyEntities(){
        return friendlyEntityList;
    }
    
    public LinkedList<EnemyEntity> getEnemyEntities(){
        return enemyEntityList;
    }
    
}
