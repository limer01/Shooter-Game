package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();
        
        //Play Button
        if(mouseX >= Game.WIDTH/2 + 120 && mouseX <=Game.WIDTH/2 + 220){
            if(mouseY >= 150 && mouseY <= 300){
                Game.State = Game.State.GAME;
            }
        }
        
        //Quit Button
        if(mouseX >= Game.WIDTH/2 + 120 && mouseX <=Game.WIDTH/2 + 220){
            if(mouseY >= 350 && mouseY <= 400){
                System.exit(1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
