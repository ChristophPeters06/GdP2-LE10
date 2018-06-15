package Model;

import javafx.scene.shape.Shape;

public class Polygon extends Figure {
    // Eckenanzahl
    private int numCorners;

    // Konstruktoren für die Klasse Polygon
    public Polygon(double a, double x, double y, int numCorners) {
        super(a, a, x, y);
        this.numCorners = numCorners;
    }

    // Rückgabe Figurentyp
    protected String getType() {
        return "Polygon";
    }

    // Berechnung Flächeninhalt
    public double area() {
        return ((this.getA() * Math.pow(this.numCorners, 2)) / 2 * Math.sin(2 * PI / this.numCorners));
    }

    // Berechnung Umfang
    public double circumference() {
        return (2 * getA() * this.numCorners * Math.sin(PI / this.numCorners));
    }

    public Shape getShape() {
        double a = getWidth() / 2;
        double b = getHeight() / 2;
        Shape s = new javafx.scene.shape.Polygon(getX() + a, getY() + b, a, b);
        setShapeColors(s);
        return s;
    }

}
