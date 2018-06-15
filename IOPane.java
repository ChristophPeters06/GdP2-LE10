package Application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class IOPane extends BorderPane {

    private Application parent = null;
    private Model.Figure figure = null;
    private int idFigure = 0;

    private Label lblForm = null;
    private TextField txtForm = null;
    private Label lblUmfang = null;
    private TextField txtUmfang = null;
    private Label lblArea = null;
    private TextField txtArea = null;
    private Label lblIndex = null;
    private TextField txtIndex = null;
    private Label lblA = null;
    private TextField txtA = null;
    private Label lblB = null;
    private TextField txtB = null;
    private Label lblX = null;
    private TextField txtX = null;
    private Label lblY = null;
    private TextField txtY = null;
    private Label lblOK = null;
    private Button btnOK = new Button("Bestaetigen");

    public IOPane(Model.Figure figure, Application parent) {
        this.parent = parent;
        this.figure = figure;
        this.idFigure = ((DrawingApp) parent).getIndex(figure);

        lblA = this.createLabel("Y");
        txtA = this.createTextField("100");
        lblB = this.createLabel("Y");
        txtB = this.createTextField("100");
        lblX = this.createLabel("X");
        txtX = this.createTextField("100");
        lblY = this.createLabel("Y");
        txtY = this.createTextField("100");
        lblIndex = this.createLabel("Index");
        txtIndex = this.createTextField("1");
        lblUmfang = this.createLabel("Umfang");
        txtUmfang = this.createTextField("100", true);
        lblArea = this.createLabel("Flaeche");
        txtArea = this.createTextField("100", true);
        lblForm = this.createLabel("Form");
        txtForm = this.createTextField("100", true);

        lblOK = this.createLabel("Accept");
        btnOK.setPadding(new Insets(5, 5, 5, 5));
        btnOK.setPrefWidth(100);

        btnOK.setOnAction(e -> {
            updateFigure();
            System.out.println(e.getSource());
            System.out.println(" " + getTextField(txtIndex) + " " + getTextField(txtX) + " " + getTextField(txtY) + " " + getTextField(txtA) + " " + getTextField(txtB));
        });

        HBox bottom = new HBox();
        bottom.setAlignment(Pos.BASELINE_CENTER);
        bottom.getChildren().addAll(lblIndex,txtIndex,lblX,txtX,lblY,txtX,lblA,txtA,lblB,txtB,lblOK,btnOK,lblForm,txtForm,lblUmfang,txtUmfang,lblArea,txtArea);
        bottom.setPadding(new Insets(25,25,25,25));
        this.setBottom(bottom);

        updateIOPanel();
    }

    public void updateIOPanel() {
        if(figure != null) {
            txtForm.setText(figure.getForm());
            setTextField(txtIndex, idFigure);
            setTextField(txtX,figure.getX());
            setTextField(txtY,figure.getY());
            setTextField(txtA, figure.getWidth()+figure.getX());
            setTextField(txtB, figure.getHeight()+figure.getY());
            setTextField(txtUmfang, figure.circumference());
            setTextField(txtArea, figure.area());
        }
    }

    public void updateFigure() {
        int id = (int) getTextField(txtIndex);
        if (id != idFigure) {
            this.idFigure = id;
            this.figure = ((DrawingApp) parent).getFigure((id));
            updateIOPanel();
        }
        figure.setXY(getTextField(txtX),getTextField(txtY));
        figure.setAB(getTextField(txtA),getTextField(txtB));
        ((DrawingApp) parent).updateDrawing();
    }

    public void setFigure(Model.Figure fig, int i) {
        figure = fig;
        idFigure = i;
        updateIOPanel();
    }

    private Label createLabel (String lblText) {
        Label lbl = new Label(" " + lblText + ": ");
        lbl.setAlignment(Pos.BASELINE_CENTER);
        return lbl;
    }

    private TextField createTextField (String txtText) {
        return createTextField(txtText, false);
    }

    private TextField createTextField (String txtText, Boolean ro) {
        TextField txt = new TextField(" " + txtText + " ");
        txt.setAlignment(Pos.BASELINE_CENTER);
        txt.setPrefWidth(80);
        if (ro == true) txt.setDisable(ro);
        return txt;
    }

    private void setTExtField (TextField txt, int value) {
        String s = new String();
        txt.setText(s + value);
    }

    private void setTextField (TextField txt, double value) {
        String s = new  String();
        int v = (int) value;
        txt.setText(s + v);
    }

    private double getTextField (TextField txt) {
        return Double.parseDouble(txt.getText());
    }
}
