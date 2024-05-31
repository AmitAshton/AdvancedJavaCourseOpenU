package Question2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Question2Controller {

    @FXML
    private GridPane buttonsGrid;

    @FXML
    private GridPane matrixGrid;

    private Button[] buttons;

    private Rectangle[][] rectangles; //borders

    private Circle[][] circles;

    private final Color PLAYER1_COLOR = Color.RED;

    private final Color PLAYER2_COLOR = Color.BLUE;

    private int currentTurn;

    private final int BUTTON_SIZE = 7;

    private final int DISK_PER_COLUMN = 6;

    public void initialize() {
        initializeButtons();
        initializeRectangles();
        circles = new Circle[DISK_PER_COLUMN][BUTTON_SIZE];
        currentTurn = 1;
    }

    // init buttons for each column
    private void initializeButtons() {
        buttons = new Button[BUTTON_SIZE];
        for (int i = 0; i < BUTTON_SIZE; i++) {
            buttons[i] = new Button(""+(i+1));
            buttons[i].setPrefSize(buttonsGrid.getPrefWidth() / BUTTON_SIZE, buttonsGrid.getPrefHeight() / BUTTON_SIZE);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    handleButton(event);
                }
            });
            buttonsGrid.add(buttons[i], i % BUTTON_SIZE, 0);
        }
    }

    // init borders for each cell in the matrix
    private void initializeRectangles() {
        rectangles = new Rectangle[DISK_PER_COLUMN][BUTTON_SIZE];
        for (int i = 0; i < DISK_PER_COLUMN; i++) {
            for (int j = 0; j < BUTTON_SIZE; j++) {
                rectangles[i][j] = new Rectangle(matrixGrid.getPrefWidth() / BUTTON_SIZE, matrixGrid.getPrefHeight() / DISK_PER_COLUMN);
                rectangles[i][j].setStroke(Color.BLACK);
                rectangles[i][j].setFill(Color.TRANSPARENT);
                matrixGrid.add(rectangles[i][j], j, i);
            }
        }
    }

    // add circle by clicking a button
    private void handleButton(ActionEvent event) {
        Button buttonPressed = (Button) event.getSource();
        int column = Integer.parseInt(buttonPressed.getText()) - 1; // Subtract 1 to match array index
        boolean firstDisk = false;
        for (int i = DISK_PER_COLUMN - 1; i >= 0; i--) { // Start from the last row and go upwards
            if (circles[i][column] == null) {
                firstDisk = true;
                double cellWidth = matrixGrid.getWidth() / BUTTON_SIZE;
                double cellHeight = matrixGrid.getHeight() / DISK_PER_COLUMN;
                double radius = Math.min(cellWidth, cellHeight) / 2 * 0.8; // Adjust the multiplier as needed
                circles[i][column] = new Circle(radius);
                circles[i][column].setFill(currentTurn == 1 ? PLAYER1_COLOR : PLAYER2_COLOR);
                matrixGrid.add(circles[i][column], column, i);
                if (currentTurn == 1) currentTurn = 0;
                else currentTurn = 1;
                checkWinner();
                return; // Exit the loop once a disk is placed
            }
        }
        // If the loop completes without placing a disk, show error alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error message");
        alert.setHeaderText("No cells left at this column");
        alert.show(); // Show the alert
    }

    private void checkWinner() {
        // Check horizontally
        for (int row = 0; row < DISK_PER_COLUMN; row++) {
            for (int col = 0; col <= BUTTON_SIZE - 4; col++) {
                if (checkLine(circles[row][col], circles[row][col + 1], circles[row][col + 2], circles[row][col + 3])) {
                    declareWinner(currentTurn);
                    return;
                }
            }
        }

        // Check vertically
        for (int col = 0; col < BUTTON_SIZE; col++) {
            for (int row = 0; row <= DISK_PER_COLUMN - 4; row++) {
                if (checkLine(circles[row][col], circles[row + 1][col], circles[row + 2][col], circles[row + 3][col])) {
                    declareWinner(currentTurn);
                    return;
                }
            }
        }

        // Check diagonally (top-left to bottom-right)
        for (int row = 0; row <= DISK_PER_COLUMN - 4; row++) {
            for (int col = 0; col <= BUTTON_SIZE - 4; col++) {
                if (checkLine(circles[row][col], circles[row + 1][col + 1], circles[row + 2][col + 2], circles[row + 3][col + 3])) {
                    declareWinner(currentTurn);
                    return;
                }
            }
        }

        // Check diagonally (top-right to bottom-left)
        for (int row = 0; row <= DISK_PER_COLUMN - 4; row++) {
            for (int col = BUTTON_SIZE - 1; col >= 3; col--) {
                if (checkLine(circles[row][col], circles[row + 1][col - 1], circles[row + 2][col - 2], circles[row + 3][col - 3])) {
                    declareWinner(currentTurn);
                    return;
                }
            }
        }
    }

    private boolean checkLine(Circle c1, Circle c2, Circle c3, Circle c4) {
        if (c1 != null && c2 != null && c3 != null && c4 != null) {
            Color color1 = (Color) c1.getFill();
            Color color2 = (Color) c2.getFill();
            Color color3 = (Color) c3.getFill();
            Color color4 = (Color) c4.getFill();
            return color1.equals(color2) && color1.equals(color3) && color1.equals(color4);
        }
        return false;
    }

    private void declareWinner(int player) {
        String winner = (player == 1) ? "Player Blue" : "Player Red";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Winner!");
        alert.setHeaderText(winner + " wins!");
        alert.show();
        restartGame();
    }

    @FXML
    void clearPressed(ActionEvent event) {
        restartGame();
    }

    private void restartGame() {
        // Clear circles
        for (int row = 0; row < DISK_PER_COLUMN; row++) {
            for (int col = 0; col < BUTTON_SIZE; col++) {
                circles[row][col] = null;
            }
        }

        // Reset currentTurn
        currentTurn = 1;

        // Clear grid
        matrixGrid.getChildren().clear();

        // Reinitialize rectangles
        initializeRectangles();
    }

}

