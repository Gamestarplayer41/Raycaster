package Raycaster.Ray;

import Raycaster.Punkt.Punkt;
import Raycaster.Vektor.Vektor;

public class Ray {
    private Punkt p1;
    private Punkt p2;
    private Vektor vektor;
    private boolean hit;
    private String color;
    private double length;

    public void setHit(boolean hit){
        this.hit = hit;
    }
    public Punkt getP1() {
        return p1;
    }

    public Punkt getP2() {
        return p2;
    }

    public boolean isHit() {
        return hit;
    }

    public String getColor() {
        return color;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public Vektor getVektor() {
        return vektor;
    }

    public Ray(Punkt p1, Punkt p2, boolean hit, String color){
        this.p1 = p1;
        this.p2 = p2;
        this.vektor = new Vektor(p1,p2);
        this.hit = hit;
        this.color = color;
        this.length = 0;
    }
    public void setP1(double x, double y){
        p1.setX(x);
        p1.setY(y);
        vektor.setX(p1.getX()-p2.getX());
    }
    public void setP2(double x, double y){
        p2.setX(x);
        p2.setY(y);
        vektor.setY(p1.getY()-p2.getY());

    }
}
