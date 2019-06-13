package Raycaster.Frames.Dimension2;

import Raycaster.Start.Manager;
import Raycaster.Start.Start;

import javax.swing.*;
import java.awt.*;

public class Frame2D extends JPanel {
    JFrame frame;

    public Frame2D() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        frame.add(this);

        frame.setLocation(500, 0);
        frame.setSize(500, 500);

        frame.setVisible(true);
        this.setFocusable(true);
        this.addMouseMotionListener(new Mauslistener());
        this.addKeyListener(new TastListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintRay(g);
        paintWall(g);
    }

    private void paintWall(Graphics g) {
        //paints Wall
        g.setColor(Color.white);
        for(int i = 0; i<Start.manager.walls; i++){
            Start.manager.wall[i].getP1();
            g.drawLine((int)Start.manager.wall[i].getP1().getX(),(int)Start.manager.wall[i].getP1().getY(),(int)Start.manager.wall[i].getP2().getX(),(int)Start.manager.wall[i].getP2().getY());
        }
    }

    private void paintRay(Graphics g) {
        //paints Rays

        g.setColor(Color.white);
        for (int i = 0; i < Start.manager.Rays; i++) {
            g.drawLine((int) Start.manager.Player.getX(), (int) Start.manager.Player.getY(), (int) Start.manager.ray[i].getP2().getX(), (int) Start.manager.ray[i].getP2().getY());
        }
        g.setColor(Color.red);
        //g.drawLine((int)Start.manager.dir.getP1().getX(),(int)Start.manager.dir.getP1().getY(),(int)Start.manager.dir.getP2().getX(),(int)Start.manager.dir.getP2().getY());
    }
}
