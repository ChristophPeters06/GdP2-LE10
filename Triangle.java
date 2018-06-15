package Model;

import javafx.scene.shape.Shape;

class Triangle extends Figure {
    // Konstruktoren der Klasse Triangle
    public Triangle(double a, double x, double y) {
        super(a, a, x, y);
    }

    // Rückgabe Figurentyp
    protected String getType(){ return "Dreieck"; }

    // Berechnung Flächeninhalt
    public double area() {
        return ((Math.pow(getA(), 2) / 4) * Math.sqrt(3));
    }

    // Berechnung Umfang
    public double circumference() {
        return (3 * getA());
    }

    public Shape getShape() {
        double a = getWidth() / 2;
        double b = getHeight() / 2;
        Shape s = new javafx.scene.shape.TriangleMesh(getX() + a, getY() + b, a, b);
        setShapeColors(s);
        return s;
    }
}
