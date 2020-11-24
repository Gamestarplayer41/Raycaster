package Raycaster.Frames;

import Raycaster.Start.Start;

import java.awt.event.KeyEvent;

public class Mover {
    /**
     *
     * @param x1 input the current or updated coordinate of the rays
     * @param y1 input the current or updated coordinate of the rays
     *
     */
    public void mover(double x1, double y1){
        // recalculates rays
        for(int i = 0; i< Start.manager.Rays;i++){
            double step = 2 * (Start.manager.fov / Start.manager.Rays);
            // x = dir.x * cos(fov) + dir.y *sin(fov)
            double x = (Start.manager.dir.getX()* Math.cos(Math.toRadians((Start.manager.fov-(step*i))))-(Start.manager.dir.getY()*Math.sin(Math.toRadians((Start.manager.fov-(step*i))))));
            double y = (Start.manager.dir.getX()* Math.sin(Math.toRadians((Start.manager.fov-(step*i))))+(Start.manager.dir.getY()*Math.cos(Math.toRadians((Start.manager.fov-(step*i))))));



            Start.manager.ray[i].setP2(x*10+x1,y*10+y1);


        }
        Start.manager.frame2D.repaint();
    }
}
