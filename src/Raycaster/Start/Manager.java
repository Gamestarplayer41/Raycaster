package Raycaster.Start;


import Raycaster.Frames.Dimension2.Frame2D;
import Raycaster.Frames.Dimension3.Frame3D;
import Raycaster.Frames.Mover;
import Raycaster.Punkt.Punkt;
import Raycaster.Ray.Ray;
import Raycaster.Vektor.Vektor;
import Raycaster.Wall.Wall;

import javax.swing.*;
import java.awt.*;

public class Manager {
    public Frame2D frame2D = new Frame2D(); //2D Frame
    public Frame3D frame3D = new Frame3D(); // 3D Frame
    public Mover mover = new Mover(); // Bewegt Rays
    public double walls = 10; //anzahl der Walls
    public Wall[] wall = new Wall[(int) walls]; //walls
    public double Rays = frame3D.width;     //anzahl rays
    public Ray[] ray = new Ray[(int) Rays];  //rays
    public Punkt Player = new Punkt(10, 10); // Spieler Pos
    public Vektor dir = new Vektor(new Punkt(0, 0), new Punkt(100, 0)); // sichtrichtung
    public double fov = -30; // negative because its flipped


    private void genWalls() {
        //Gen walls Auto.
        for (int i = 0; i < walls; i++) {
            wall[i] = new Wall(new Punkt(Math.random() * (450 - 20), Math.random() * (450 - 20)), new Punkt(Math.random() * (450 - 20), Math.random() * (450 - 20)), Color.white, 100);
        }
    }

    public void calcIntersect() {
        //calc smallest ray
        for (int i = 0; i < Rays; i++) {
            double[] intersect = new double[4];
            intersect[2] = 10000;
            intersect[3] = 0;
            for (int a = 0; a < walls; a++) {
                double[] intersect2;
                intersect2 = wall[a].intersection(ray[i].getP1(), ray[i].getP2());
                if (intersect2 != null && intersect2[2] < intersect[2]) {
                    intersect[0] = intersect2[0];
                    intersect[1] = intersect2[1];
                    intersect[2] = intersect2[2];
                    intersect[3] = 1;
                }

            }

            if (intersect[3] != 0) {
                ray[i].setP1(Player.getX(), Player.getY());
                ray[i].setP2(intersect[0], intersect[1]);
                ray[i].setLength(intersect[2]);
                ray[i].setHit(true);
            } else {
                ray[i].setHit(false);
            }


        }
    }

    void Init() {
        //init all
        genRays();
        genWalls();

    }

    public double projektionsAbstand() {

        double d = (frame3D.heigth / 2) * java.lang.Math.tan(java.lang.Math.toRadians((fov)));
        return d;
    }


    private void genRays() {
        //create rays
        for (int i = 0; i < Rays; i++) {
            double step = 2 * (fov / Rays);
            double x = (dir.getX() * Math.cos(Math.toRadians((fov - (step * i)))) - (dir.getY() * Math.sin(Math.toRadians((fov - (step * i))))));
            double y = (dir.getX() * Math.sin(Math.toRadians((fov - (step * i)))) + (dir.getY() * Math.cos(Math.toRadians((fov - (step * i))))));


            ray[i] = new Ray(Player, new Punkt((x * 100 + Player.getX()), (y * 100 + Player.getY())), false, "white");
        }
    }
    public double calcWallHeight(int rayNr){
        Vektor v = ray[rayNr].getVektor();
        double winkel = Math.cos(Math.toRadians(Start.manager.dir.angle(v)));
        if(winkel <0){
            winkel *= -1;
        }
        double projektionsabstand = projektionsAbstand();
        double lengthray = ray[rayNr].getLength();
        double lengthreal = lengthray * winkel;
        double wallheigth = (20 *projektionsabstand) / lengthreal;
        return wallheigth;
    }

}
