package Raycaster.Frames.Dimension3;

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

    }
}
