package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
    
    public Rectangle playButton = new Rectangle(Game.WIDTH/2 + 120, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(Game.WIDTH/2 + 120, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(Game.WIDTH/2 + 120, 350, 100, 50);
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        Font fnt1 = new Font("arial", Font.BOLD, 59);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("SPACE GAME", (Game.WIDTH/2) - 30, 100);
        
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt2);
        g.setColor(Color.WHITE);
        g.drawString("Play", playButton.x + 19, playButton.y + 35);
        g2d.draw(playButton);
        
        g.drawString("Help", helpButton.x + 19, helpButton.y + 35);
        g2d.draw(helpButton);
        
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 35);
        g2d.draw(quitButton);
    }
    
    
    
}
