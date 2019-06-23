package Raycaster.Start;

import Raycaster.Vektor.Vektor;

public class Mathe {

    public static double calcWallHeight(int rayNr){
        Vektor v = Start.manager.ray[rayNr].getVektor();
        double winkel = Math.cos(Math.toRadians(Start.manager.dir.angle(v)));
        if(winkel <0){
            winkel *= -1;
        }
        double projektionsabstand = projektionsAbstand();
        double lengthray = Start.manager.ray[rayNr].getLength();
        double lengthreal = lengthray * winkel;
        double wallheigth = (20 *projektionsabstand) / lengthreal;
        return wallheigth;
    }
    public static double projektionsAbstand() {

        double d = (Start.manager.frame3D.heigth / 2) * java.lang.Math.tan(java.lang.Math.toRadians((Start.manager.fov)));
        return d;
    }
    public static void calcIntersect() {
        //calc smallest ray
        for (int i = 0; i < Start.manager.Rays; i++) {
            double[] intersect = new double[4];
            intersect[2] = 10000;
            intersect[3] = 0;
            for (int a = 0; a < Start.manager.walls; a++) {
                double[] intersect2;
                intersect2 = Start.manager.wall[a].intersection(Start.manager.ray[i].getP1(), Start.manager.ray[i].getP2());
                if (intersect2 != null && intersect2[2] < intersect[2]) {
                    intersect[0] = intersect2[0];
                    intersect[1] = intersect2[1];
                    intersect[2] = intersect2[2];
                    intersect[3] = 1;
                }

            }

            if (intersect[3] != 0) {
                Start.manager.ray[i].setP1(Start.manager.Player.getX(), Start.manager.Player.getY());
                Start.manager.ray[i].setP2(intersect[0], intersect[1]);
                Start.manager.ray[i].setLength(intersect[2]);
                Start.manager.ray[i].setHit(true);
            } else {
                Start.manager.ray[i].setHit(false);
            }


        }
    }
}
