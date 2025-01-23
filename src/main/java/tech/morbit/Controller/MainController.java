package tech.morbit.Controller;

import javafx.scene.control.*;
import tech.morbit.Character.Character;
import tech.morbit.TabBuilder.TabBuilder;
import tech.morbit.Tools.CharacterFileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class MainController {

    private Stage stage;

    @FXML
    private Button exit;

    @FXML
    private TabPane tabPane;

    @FXML
    public void initialize(){
        exit.setOnAction(actionEvent -> exit.setOnMouseClicked(event -> exit()));
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }


    public void openCharacterDynamic(Character cd){
        Tab tab = TabBuilder.createCharacterTab(cd);
        this.tabPane.getTabs().add(tab);
    }

    public void openCharacterDynamicFileChooser() throws IOException{


        Stage saveStage = new Stage();
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Open Character", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open dialog
        File file = fileChooser.showOpenDialog(saveStage);
        if (file != null) {
            try {
                CharacterFileHandler chf = new CharacterFileHandler();

                Character cd = chf.getCharacter(file);

                openCharacterDynamic(cd);
            }
            catch (InvocationTargetException ITex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occured");
                a.show();
            }
            catch (NoSuchMethodException NMSex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occurred");
                a.show();
            }
            catch (InstantiationException Iex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("An error occurred");
                a.show();
            }
            catch (IllegalAccessException IAex){
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("You aren't allowed to open this.");
                a.show();
            }
            catch (JSONException e){
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("ERROR");
                a.setContentText("Your JSON seems faulty.");
                a.show();
            }

        }
        else {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("ERROR");
            a.setContentText("The file you selected is empty!");
            a.show();
        }
    }

    
    @FXML
    private void exit() {
        System.exit(0);
    }

}