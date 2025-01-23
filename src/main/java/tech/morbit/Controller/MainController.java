package tech.morbit.Controller;

import tech.morbit.App.Main;
import tech.morbit.Character.CharacterDynamic;
import tech.morbit.Tools.CharacterFileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
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
    private MenuItem about;

    private ArrayList<Stage> stages;
    private ArrayList<FXMLLoader> loaders;
    private ArrayList<CharacterDynamicController> controllersDynamic;

    @FXML
    public void initialize(){
        stages = new ArrayList<>();
        loaders = new ArrayList<>();
        controllersDynamic = new ArrayList<>();


        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exit.setOnMouseClicked(event ->
                        exit());

            }
        });
    }




    public void openCharacterDynamic(CharacterDynamic cd){
        try{
            Stage newStage = new Stage();
            stages.add(newStage);
            loaders.add(new FXMLLoader(tech.morbit.App.Main.class.getResource("CharacterDynamic.fxml")));

            //last index
            int lil = loaders.size() - 1;
            int lis = stages.size() - 1;

            Scene scene = new Scene(loaders.get(lil).load(), 800, 400);

            CharacterDynamicController cdc = loaders.get(lil).getController();


            cdc.setCharacter(cd);
            cdc.displayList();

            controllersDynamic.add(cdc);


            stages.get(lis).setTitle(cd.getName());
            stages.get(lis).setScene(scene);
            stages.get(lis).show();

        } catch (IOException e) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("There was an Error loading this character. Something is in the IO");
            a.show();

        }
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

                CharacterDynamic cd = chf.getCharacter(file);

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

    public void setStage(Stage stage) {
    }
}