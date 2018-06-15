package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DrawingApp extends Application{

    private Model.Drawing zeichnung = new Model.Drawing();
    private IOPane ioPane = new IOPane(zeichnung.getFigure(1), this);
    private DrawingPane drPane = new DrawingPane(zeichnung, this);

    public void start(Stage primStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,1000,800);

            root.setBottom(ioPane);
            root.setCenter(drPane);

            primStage.setScene(scene);
            primStage.setTitle("DrawingApp");
            primStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFigure(int id) {
        ioPane.setFigure(getFigure(id),id);
    }

    public int getIndex(Model.Figure fig) {
        return zeichnung.getIndex(fig);
    }

    public Model.Figure getFigure(int id) {
        return zeichnung.getFigure(id);
    }

    public void updateDrawing() {
        drPane.updateDrawing();
    }

}
