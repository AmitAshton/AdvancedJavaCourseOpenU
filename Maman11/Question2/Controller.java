package Question2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Controller {

    @FXML
    private Canvas canv;

    private GraphicsContext gc;
    private int[][] matrix;
    private int rows;
    private int cols;
    private Random random = new Random();

    @FXML
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        rows = (int) (canv.getHeight() / 10);
        cols = (int) (canv.getWidth() / 10);
        matrix = new int[rows][cols];

        // Fill matrix with white cells
        clearMatrix();

        // Draw lines and matrix
        drawMatrix();
    }

    @FXML
    void drawPressed(ActionEvent event) {
        clearMatrix(); // Clear matrix before filling with new cells
        fillRandomCells();
        drawMatrix();
    }

    private void clearMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0; // White cell
            }
        }
    }

    private void fillRandomCells() {
        int totalCells = rows * cols;
        int cellsToFill = totalCells / 10; // 10% of cells

        for (int i = 0; i < cellsToFill; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            matrix[row][col] = 1; // Fill cell
        }
    }

    private void drawMatrix() {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        gc.setFill(Color.BLACK);

        // Draw cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    gc.fillRect(j * 10, i * 10, 10, 10);
                }
            }
        }

        // Draw lines
        gc.setStroke(Color.BLACK);
        for (int i = 0; i < rows; i++) {
            gc.strokeLine(0, i * 10, canv.getWidth(), i * 10);
        }
        for (int j = 0; j < cols; j++) {
            gc.strokeLine(j * 10, 0, j * 10, canv.getHeight());
        }
    }
}
