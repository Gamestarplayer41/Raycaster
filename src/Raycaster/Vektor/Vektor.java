package Raycaster.Vektor;

import Raycaster.Punkt.Punkt;

public class Vektor {
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public static double length(Punkt p1, Punkt p2){
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        double length = java.lang.Math.sqrt((x*x+y*y));


        return length;
    }

    public Vektor(Punkt p1, Punkt p2) {
        x = p2.getX()- p1.getX();
        y = p2.getY()-p1.getY();
    }

    public double angle(Vektor v) {
        //gibt keine Grad zurück (glaube ich)
        double oben = this.x * v.getX() + this.y * v.getY();
        double unten = Math.pow((this.x * this.x + this.y * this.y), 0.5) * Math.pow((v.getX() * v.getX() + v.getY() * v.getY()), 0.5);
        double cos = Math.cos((oben / unten));
        return (cos);

    }

    public double length() {
        //returns length of Vektor
        return (java.lang.Math.pow((x * x + y * y), 0.5));
    }

    public double getX() {
        return x;
    }
    public void changeDir(double degrees){
        //changes dir of dir vektor
        double x=  (this.x*Math.cos(Math.toRadians(degrees)))-(this.y*Math.sin(Math.toRadians(degrees)));
        double y=  (this.x*Math.sin(Math.toRadians(degrees)))+(this.y*Math.cos(Math.toRadians(degrees)));
        this.x = x;
        this.y = y;


    }

    public double getY() {
        return y;
    }
}
