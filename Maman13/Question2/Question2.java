package Question2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Main class for question 2 lunching the javaFX application
 */
public class Question2 extends Application{

    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Question2.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Question2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}