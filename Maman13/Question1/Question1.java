package Question1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Main class for question 1 lunching the javaFX application
 */
public class Question1 extends Application{

    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Question1.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Question1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}
