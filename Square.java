package Model;

import java.awt.*;

final class Square extends Rectangle {
    // Konstruktoren der Klasse Square
    public Square (double a, double x, double y) {
        super(a, a, x, y);
    }

    // Rückgabe Figurentyp
    protected String getType() {
        return "Quadrat";
    }
}
