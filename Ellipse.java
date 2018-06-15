package Model;

import javafx.scene.shape.Shape;

public class Ellipse extends Figure {
    // Konstruktoren der Klasse Ellipse
    public Ellipse() { super();}

    public Ellipse(double a, double b, double x, double y){
        super(a, b, x, y);
    }

    // Rückgabe Figurentyp
    protected String getType() {
        return "Ellipse";
    }

    // Berechnung der Kreisfläche
    public double area() {
        return (this.PI * getA() * getB());
    }

    // Berechnung Umfang = Näherungsformel zur Berechnung des quadr. Mittels der Halbachsen
    public double circumference() {
        return (PI * Math.sqrt(2 * (Math.pow(getA() / 2, 2) + Math.pow(getB() / 2, 2))));
    }

    public Shape getShape() {
        double a = getWidth()/2;
        double b = getHeight()/2;
        Shape s = new javafx.scene.shape.Ellipse(getX()+a,getY()+b,a,b);
        setShapeColors(s);
        return s;
    }
}
