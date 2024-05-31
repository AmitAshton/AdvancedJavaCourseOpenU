package Question1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;

/*
This class represents the controller class for the FXML JavaFX structure
 */
public class ShapeController {

    @FXML
    private Pane pane;

    @FXML
    private ToggleGroup shape;

    private Double startX, startY; //starting coordinates for the shapes

    private Boolean filled;

    private ArrayList<Shape> shapes; // shapes list

    @FXML
    private ColorPicker colorPicker;

    private Color selectedColor;

    public void initialize() {
        shapes = new ArrayList<Shape>();

        this.filled = false;

        this.startX = -1.0; //default values
        this.startY = -1.0;

        selectedColor = colorPicker.getValue();
    }

    @FXML
    void colorSelected(ActionEvent event) {
        // set the selected color for the shapes to the value of the color picker
        selectedColor = colorPicker.getValue();
    }

    @FXML
    void filled(ActionEvent event) {
        // checkbox logic
        this.filled = !this.filled;
    }

    @FXML
    void mousePressed(MouseEvent event) {
        // getting the starting (press event) coordinates for the shape
        this.startX = event.getX();
        this.startY = event.getY();
    }

    @FXML
    void mouseReleased(MouseEvent event) {
        Double finalX = event.getX();
        Double finalY = event.getY();
        RadioButton selectedRadioButton = (RadioButton) shape.getSelectedToggle(); // get selection
        if (!(selectedRadioButton == null)){
            ShapeType selectedShape = ShapeType.valueOf(selectedRadioButton.getText().toUpperCase()); // convert to enum
            switch (selectedShape) {
                case LINE:
                    drawLine(finalX, finalY);
                    break;
                case RECTANGLE:
                    drawRectangle(finalX, finalY);
                    break;
                case ELLIPSE:
                    drawEllipse(finalX, finalY);
                    break;
            }
            this.startX = -1.0; // restart to default values
            this.startY = -1.0;
        }
    }

    @FXML
    void clear(ActionEvent event) {
        pane.getChildren().clear(); // clear all pane's children(the shapes)
        shapes.clear();
    }

    @FXML
    void undo(ActionEvent event) {
        // as kong that there are shapes left, remove the last shape that entered the list
        if (!shapes.isEmpty()) {
            Shape lastShape = shapes.remove(shapes.size() - 1);
            pane.getChildren().remove(lastShape); // also remove from the pane's children list
        }
    }

    private void drawLine(Double x, Double y) {
        Shape line = new Line(startX, startY, x, y); // coordinates
        line.setStroke(this.selectedColor); // color
        pane.getChildren().add(line);
        shapes.add(line);
    }

    private void drawRectangle(Double x, Double y) {
        double rectX = Math.min(startX, x);
        double rectY = Math.min(startY, y);
        double width = Math.abs(startX - x);
        double height = Math.abs(startY - y);

        Rectangle rectangle = new Rectangle(rectX, rectY, width, height);
        rectangle.setStroke(this.selectedColor);
        if (filled) {
            rectangle.setFill(this.selectedColor); //fill
        } else {
            rectangle.setFill(Color.TRANSPARENT);
        }
        pane.getChildren().add(rectangle);
        shapes.add(rectangle);
    }

    private void drawEllipse(Double x, Double y) {
        Ellipse ellipse = new Ellipse((startX + x) / 2, (startY + y) / 2, Math.abs(x - startX), Math.abs(y - startY));
        ellipse.setStroke(this.selectedColor);
        if (filled) {
            ellipse.setFill(this.selectedColor);
        } else {
            ellipse.setFill(Color.TRANSPARENT);
        }
        pane.getChildren().add(ellipse);
        shapes.add(ellipse);
    }

}
