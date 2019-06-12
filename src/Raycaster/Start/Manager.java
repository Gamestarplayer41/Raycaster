package Raycaster.Start;


import Raycaster.Frames.Dimension2.Frame2D;
import Raycaster.Frames.Dimension3.Frame3D;
import Raycaster.Frames.Mover;
import Raycaster.Punkt.Punkt;
import Raycaster.Ray.Ray;
import Raycaster.Vektor.Vektor;
import Raycaster.Wall.Wall;

import java.awt.*;

public class Manager {
    public Mover mover = new Mover(); // Bewegt Rays
    public double walls = 10; //anzahl der Walls
    public Wall[] wall = new Wall[(int) walls]; //walls
    public double Rays = 300;     //anzahl rays
    public Ray[] ray = new Ray[(int) Rays];  //rays
    public Punkt Player = new Punkt(10, 10); // Spieler Pos
    public Vektor dir = new Vektor(new Punkt(0, 0), new Punkt(100, 0)); // sichtrichtung

    public double fov = 20; // degree *2
    public Frame2D frame2D; //2D Frame
    public Frame3D frame3D; // 3D Frame

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
                intersect2 = wall[a].intersection(ray[i].getP1(),ray[i].getP2());
                if (intersect2 != null && intersect2[2] < intersect[2]) {
                    intersect[0] = intersect2[0];
                    intersect[1] = intersect2[1];
                    intersect[2] = intersect2[2];
                    intersect[3] = 1;
                }

            }

            if (intersect[3] != 0) {
                ray[i].setP2(intersect[0], intersect[1]);
                ray[i].setHit(true);
            } else {
                ray[i].setHit(false);
            }


        }
    }

    public void Init() {
        //init all
        genRays();
        genWalls();
        frame2D = new Frame2D();
        frame3D = new Frame3D();
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

}
