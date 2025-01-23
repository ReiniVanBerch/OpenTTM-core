package tech.morbit.App;

import tech.morbit.Controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            // Loads the FXML-File
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tech/morbit/Main/Main.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 500, 400);

            MainController mc = fxmlLoader.getController();
            mc.setStage(stage);

            stage.setTitle("OpenRPG-Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der FXML-Datei");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
