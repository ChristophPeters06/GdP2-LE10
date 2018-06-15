package Model;

import javafx.scene.shape.Shape;

public class Rectangle extends Figure{
    // Konstruktoren für die Klasse Rectangle
    public Rectangle (double a, double b, double x, double y) {
        super(a, b , x, y);
    }

    // Rückgabe Figurentyp
    protected String getType() { return "Rechteck"; }

    // Berechnung Flächeninhalt
    public double area() {
        return (getA() * getB());
    }

    // Berechnung Umfang
    public double circumference() {
        return (2 * (getA() + getB()));
    }

    public Shape getShape() {
        double a = getWidth() / 2;
        double b = getHeight() / 2;
        Shape s = new javafx.scene.shape.Rectangle(getX() + a, getY() + b, a, b);
        setShapeColors(s);
        return s;
    }
}
