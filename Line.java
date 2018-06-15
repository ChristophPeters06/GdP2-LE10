package Model;

import javafx.scene.shape.Shape;

public class Line extends Figure{
    // Konstruktoren für die Klasse Line
    public Line(double a, double b, double x, double y) {
        super(a, b, x, y);
    }

    // Rückgabe Figurentyp
    protected String getType() { return "Linie"; }

    // Berechnung des Umfangs = Linienlänge
    public double circumference() {
        return (Math.sqrt(Math.pow(getA(), 2) + Math.pow(getB(), 2)));
    }

    @Override
    public double area() {
        return 0;
    }

    public Shape getShape() {
        double a = getWidth() / 2;
        double b = getHeight() / 2;
        Shape s = new javafx.scene.shape.Line(getX() + a, getY() + b, a, b);
        setShapeColors(s);
        return s;
    }
}
