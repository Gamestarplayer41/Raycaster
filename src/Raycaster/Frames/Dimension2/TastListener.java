package Raycaster.Frames.Dimension2;

import Raycaster.Start.Start;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class TastListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //takes keyboard input and moves rays
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            Start.manager.dir.changeDir(-10);
        }
        if(key == KeyEvent.VK_RIGHT){
            Start.manager.dir.changeDir(10);
        }
        Start.manager.mover.mover(Start.manager.Player.getX(),Start.manager.Player.getY());
        Start.manager.calcIntersect();
        Start.manager.frame2D.repaint();
        Start.manager.frame3D.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
