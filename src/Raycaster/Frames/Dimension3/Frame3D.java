package Raycaster.Frames.Dimension3;

import Raycaster.Start.Start;
import Raycaster.Vektor.Vektor;

import javax.swing.*;
import java.awt.*;

public class Frame3D extends JPanel{
    JFrame frame;
    public Frame3D(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        frame.add(this);
        frame.setLocation(0, 0);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintWall(g);

    }

    private void paintWall(Graphics g) {
        g.setColor(Color.white);
        for(int i  = 0; i < Start.manager.Rays;i++){
            Vektor v = Start.manager.ray[i].getVektor();
            double winkel = Start.manager.dir.angle(v);
            double winkel2 = Math.cos(Math.toRadians(winkel));
            if(winkel2 <0){
                winkel2 *= -1;
            }
           double a = Start.manager.projektionsAbstand();
            double lengtheucl = Start.manager.ray[i].getLength();
            double lengthreal = lengtheucl * winkel2;
             double wallheigth = (64 *a) / lengthreal;
            if(Start.manager.ray[i].isHit()){
                g.drawLine(i, 250, i, (int) (250 - wallheigth));
                g.drawLine(i, 250, i, (int) (250 + wallheigth));
            }
        }
    }
}
