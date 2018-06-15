package Application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import java.awt.*;

public class DrawingPane extends Group {

    private Application parent = null;
    private Model.Drawing zeichnung = null;
    private Pane pane = new Pane();
    private double x0, x1, y0, y1;
    private double width = 1000;
    private double height = 800;

    public DrawingPane(Model.Drawing zeichnung, Application parent) {

        this.parent = parent;
        this.zeichnung = zeichnung;
        pane.setStyle("-fx-background-color: black;");
        pane.setPrefSize(width,height);

        updateDrawing(pane);
        getChildren().add(pane);

        pane.setOnMousePressed(me ->{
            this.x0 = me.getX();
            this.y0 = me.getY();
            if (x0 < 0) x0 = 0;
            if (y0 < 0) y0 = 0;
            System.out.println("Mouse pressed " + x0 + " " + y0);
        });

        pane.setOnMouseReleased(me ->{
            this.x1 = me.getX();
            this.y1 = me.getY();
            System.out.println("Mouse released " + x1 + " " + y1);
            if (x1 > width) x1 = width;
            if (y1 > height) y1 = height;
            if (x1 - x0 > 0 && y1 -y0 > 5 || x1 - x0 > 5 && y1 - y0 > 0) {
                Rectangle rn = new Rectangle(x0, y0, x1-x0, y1-y0);
                rn.setFill(Color.YELLOW);
                zeichnung.add(Model.Figure.getFigure(rn));
                updateDrawing(pane);
            }
        });

        pane.setOnMouseClicked(me ->{
            System.out.println("Mouse clicked " + me.getX() + " " + me.getY());
            int id = zeichnung.isPointInside(me.getX(), me.getY());
            if (id != 1)
                ((DrawingApp) parent).updateFigure(id);
        });
    }

    public void updateDrawing() {
        updateDrawing(pane);
    }

    private void updateDrawing(Pane pane) {
        pane.getChildren().clear();
        for (Model.Figure fig : zeichnung.getListe())
            pane.getChildren().add(fig.getShape());
    }
}
