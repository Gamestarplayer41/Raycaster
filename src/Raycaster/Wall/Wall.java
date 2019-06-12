package Raycaster.Wall;

import Raycaster.Punkt.Punkt;
import Raycaster.Vektor.Vektor;

import java.awt.*;

public class Wall {
    private Punkt punkt1;
    private Punkt punkt2;
    private Color color;
    private double height;
    public Wall(Punkt p1, Punkt p2, Color color, double height){
        this.punkt1 = p1;
        this.punkt2 = p2;
        this.color = color;
        this.height = height;
    }

    public void setP1(Punkt p1) {
        this.punkt1 = p1;
    }

    public void setP2(Punkt p2) {
        this.punkt2 = p2;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Punkt getP1() {
        return punkt1;
    }

    public Punkt getP2() {
        return punkt2;
    }

    public Color getColor() {
        return color;
    }

    public double getHeight() {
        return height;
    }

    /**
     *
     * @param p1 ray point 1
     * @param p2 ray point 2
     * @return returns array with length, x, y
     */
    public double[] intersection(Punkt p1, Punkt p2) {
        // calculates Intersection with ray
        Punkt p3 = punkt1;
        Punkt p4 = punkt2;
        double[] xylength = new double[3];
        double t = ((p1.getX() - p3.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p3.getY()) * (p3.getX() - p4.getX())) / ((p1.getX() - p2.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p2.getY()) * (p3.getX() - p4.getX()));

        double u = -((p1.getX() - p2.getX()) * (p1.getY() - p3.getY()) - (p1.getY() - p2.getY()) * (p1.getX() - p3.getX())) / ((p1.getX() - p2.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p2.getY()) * (p3.getX() - p4.getX()));


        double xintersect = p1.getX() + t * (p2.getX() - p1.getX());
        double yintersect = p1.getY() + t * (p2.getY() - p1.getY());
        if (t >= 0 && t <= 1 && 0 <= u && u <= 1) {
            xylength[0] = xintersect;
            xylength[1] = yintersect;
            xylength[2] = Vektor.length(p1,new Punkt(xylength[0],xylength[1]));
            return xylength;
        } else {
            return null;
        }


    }
}
