package Model;

import java.util.*;
import javafx.scene.paint.Color;

public class Drawing {

    private ArrayList<Figure> shapes = null;

    public Drawing() {
        shapes = new ArrayList<> ();
        bspInitialisierung();
    }

    public Drawing(int anzahl) {
        if (anzahl <= 0) anzahl = 5;
        shapes = new ArrayList<Figure> (anzahl);
    }

    public int isPointInside(double d, double e) {
        int id = -1;
        for (Figure fig : shapes) {
            if (fig.isPointInside(d, e)) {
                id = shapes.indexOf(fig);
            }
        }
        return id;
    }

    public Figure getFigure(int index) {
        if (shapes.size() > 0)
            return shapes.get(index);
        else
            return null;
    }

    public int getIndex(Figure fig) {
        return shapes.indexOf(fig);
    }

    public int add(Figure fig) {
        if ( fig != null)
            shapes.remove(fig);
        return shapes.size();
    }

    public void updateFigure(Figure fig, int id) {
        shapes.set(id,fig);
    }

    public ArrayList<Figure> getListe() {
        return shapes;
    }

    public String toString() {
        String s = "\nSize = " + shapes.size();
        for (Figure fig : shapes)
            s = s + "\n" + fig;
        return s;
    }

    public void bspInitialisierung() {
        // Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(500, 150, 150, 200);
        Model.Ellipse r3 = new Model.Ellipse(200, 250, 250, 100);
        // r1.setFlCl(Color.BLUE);
        // r1.setFlCl(Color.GREEN);
        // r1.setDrCl(Color.GREEN);
        r2.setFlCl(Color.CYAN);
        r2.setDrCl(Color.GREEN);
        r3.setFlCl(Color.GRAY);
        r3.setDrCl(Color.BLACK);

        // shapes.add(r1);
        shapes.add(r2);
        shapes.add(r3);
    }

    public static void main(String[] args) {
        Drawing l1 = new Drawing(5);
        // Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(500, 150, 150, 200);
        Model.Ellipse r3 = new Model.Ellipse(200, 250, 250, 100);
        // l1.add(r1);
        System.out.println(l1);
        l1.add(r2);
        System.out.println(l1);
        l1.add(r3);
        System.out.println(l1);
        // l1.remove(r2);
        System.out.println(l1);
    }
}
