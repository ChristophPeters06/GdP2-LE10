package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Figure {
    private double a, b, x, y;
    private Color flCl = Color.YELLOW;
    private Color drCl = Color.BLUE;
    public double PI = Math.PI;

    public Figure() {
        this(100, 100, 0, 0);
    }

    public Figure(double a, double b, double x, double y) {
        setAB(a,b);
        setXY(x,y);
    }

    public static Figure getFigure(Shape s){
        Figure fig = null;
        String name = s.getClass().getSimpleName();
        switch (name) {
            case "Rectangle":
                javafx.scene.shape.Rectangle r = (javafx.scene.shape.Rectangle) s;
                fig = new Model.Rectangle(r.getX(),r.getY(),r.getWidth(),r.getHeight());
                break;
            case "Ellipse":
                javafx.scene.shape.Ellipse e = (javafx.scene.shape.Ellipse) s;
                fig = new Model.Ellipse(e.getCenterX()-e.getRadiusX(),e.getCenterY()-e.getRadiusY(),2*e.getRadiusX(),2*e.getRadiusY());
                break;
        }
        return fig;
    }

    public boolean isPointInside(double s, double t) {
        double w2 = getWidth()/4;
        double h2 = getHeight()/4;
        return (s > x+w2) && (s< x+3*w2) && (t > y+h2) && (t < y+3*h2);
    }

    public String getForm() {
        return getClass().getSimpleName();
    }

    public  void setAB(double x, double y) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        }
    }

    public void setXY(double x, double y) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        }
    }

    public void  setFlCl(Color c) {
        flCl = c;
    }

    public void setDrCl(Color c) {
        drCl = c;
    }

    public abstract Shape getShape();

    public void  setShapeColors(Shape s) {
        s.setFill(getFlCl());
        s.setStroke(getDrCl());
    }

    // Rückgabe der Dimension A
    public double getA() {
        return this.a;
    }

    // Rückgabe der Dimension B
    public double getB() {
        return this.b;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return a;
    }

    public double getHeight() {
        return b;
    }

    public Color getFlCl() {
        return flCl;
    }

    public Color getDrCl() {
        return drCl;
    }

    public abstract double circumference();

    public abstract double area();

    public String toString() {
        String s = getClass().getName();
        s = s + "\n(x,y) = (" + x + "," + y + ")" + " (Width,Height) = (" + a + "," + b + ")";
        s = s + "\nArea = " + area() + " Perimeter = " + circumference();
        return s;
    }
}
