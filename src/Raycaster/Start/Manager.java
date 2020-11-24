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
    public Frame2D frame2D;
    public Frame3D frame3D;
    public Mover mover = new Mover(); // movingclass for rays
    public double walls = 10; //amount of Walls
    public Wall[] wall = new Wall[(int) walls]; //walls
    public double Rays = 1000;     //Amount rays
    public Ray[] ray = new Ray[(int) Rays];  //rays
    public Punkt Player = new Punkt(10, 10); // Player Pos
    public Vektor dir = new Vektor(new Punkt(0, 0), new Punkt(100, 0)); // viewingAngle
    public double fov = -30; // negative because its flipped

    private void genWalls() {
        //Gen walls Auto.
        for (int i = 0; i < walls; i++) {
            wall[i] = new Wall(new Punkt(Math.random() * (450 - 20), Math.random() * (450 - 20)), new Punkt(Math.random() * (450 - 20), Math.random() * (450 - 20)), Color.white, 100);
        }
    }

    void Init() {
        //init all
        genRays();
        genWalls();
        frame3D = new Frame3D();
        frame2D = new Frame2D();
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
