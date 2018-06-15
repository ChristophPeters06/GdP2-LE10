package Model;

import javafx.scene.shape.Shape;

final class Circle extends Ellipse{
    // Konstruktoren der Klasse Circle
    public Circle() {}

    public Circle(double a, double x, double y) {
        super(a, a, x, y);
    }

    // Rückgabe Figurentyp
    protected String getType() {
        return "Kreis";
    }

    // Berechnung Umfang
    public double circumference() {
        return (2 * PI * (getA() / 2));
    }

    public Shape getShape() {
        double a = getWidth() / 2;
        double b = getHeight() / 2;
        Shape s = new javafx.scene.shape.Circle(getX(),getY(),50);
        setShapeColors(s);
        return s;
    }
}
