package tech.morbit.App;

import org.json.JSONObject;

import tech.morbit.Controller.MainController;
import tech.morbit.Character.Character;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import tech.morbit.Tools.CharacterFileJsonDeserialize;
import tech.morbit.Tools.CharacterFileJsonSerialize;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main extends Application {

    public static void main(String[] args) {
        //launch();
        try {
            //just launching the application. Trying cause no major error handling 2 date.
            launch();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("the end.");
        }
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
