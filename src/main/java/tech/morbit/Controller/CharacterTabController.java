package tech.morbit.Controller;

/**
 * @author Morbit
 * @version 0.1.1
 *
 * PURPOSE:
 * This is the controller for the window with completely dynamic characters.
 *
 * Left are the qualities of the character listed, in the mid are the values associated with that quality
 * and right might be a way to edit the quality, depending on the specifics of the quality.
 *
 */

import tech.morbit.Character.Character;
import tech.morbit.Quality.Quality;
import tech.morbit.Quality.FixedValue;

import tech.morbit.Tools.CharacterFileJsonSerialize;

import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CharacterTabController {

    protected Character character;
    protected Quality currentQuality;

    @FXML
    protected TreeView<Quality> qualityTreeView;
    @FXML
    protected ListView<Object> qualityValueListView;

    @FXML
    protected TextField valuesTextField;

    @FXML
    protected Button qualityButton;

    @FXML
    protected Label qualityCommentLabel;
    @FXML
    protected Label qualityTypeLabel;


    @FXML
    public void initialize(){

    }

    public void displayList() {

        ArrayList<Quality> qualities = this.character.getQualities();

        qualityTreeView.setShowRoot(false);

        // Root (invisible)
        try{
            ArrayList a = new ArrayList();
            a.add(0);
            TreeItem<Quality> rootItem = new TreeItem<>(new FixedValue("root", a));

            rootItem.setExpanded(true);

            // Build Tree
            for (Quality quality : qualities) {
                rootItem.getChildren().add(resolveQuality(quality));
            }

            qualityTreeView.setRoot(rootItem);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public TreeItem<Quality> resolveQuality(Quality quality){
        TreeItem<Quality> qualityItem = new TreeItem<>(quality);
        for (Object value : quality.getValues()) {

            if(value instanceof Quality){
                Quality q = (Quality) value;

                TreeItem<Quality> valueItem = new TreeItem<>();
                qualityItem.getChildren().add(resolveQuality(q));
            }


        }
        return qualityItem;

    }

    public void loadQuality(){
        TreeItem<Quality> selection = qualityTreeView.getSelectionModel().getSelectedItem();

        selection.setExpanded(true);
        Object obj = qualityValueListView.getSelectionModel().getSelectedItem();

        this.currentQuality = selection.getValue();

        qualityValueListView.setItems(FXCollections.observableArrayList(this.currentQuality.getValues()));
        valuesTextField.setText(this.currentQuality.getValuesAsInputString());


        valuesTextField.setEditable(!selection.getChildren().isEmpty());
        qualityButton.setDisable(this.currentQuality.getClass().equals(FixedValue.class));
    }

    public Object dataTypeChecker(Class c, String input){

        try {
            if (c == Integer.class) {
                // Validate and convert to Integer
                return Integer.parseInt(input);
            } else if (c == Double.class) {
                // Validate and convert to Double
                return Double.parseDouble(input);
            } else if (c == Boolean.class) {
                // Validate and convert to Boolean
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(input);
                } else {

                    Alert a = new Alert(Alert.AlertType.ERROR, "Input is not a valid Boolean value.");
                    a.show();
                }
            } else if (c == String.class) {
                // No validation needed for String; just return it
                return input;
            } else {
                throw new IllegalArgumentException("Unsupported data type: " + c.getSimpleName());

            }

        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("There seem to be wrong datatypes in the new values textBox");
            a.show();
        }
        return null;
    }


    public void saveChange()  {
        String valuesAsString = valuesTextField.getText();
        Class dt = currentQuality.getTypeOfValues();
        Class qt = currentQuality.getClass();

        String[] valuesString = valuesAsString.split(";");
        ArrayList<Object> values = new ArrayList<>();

        if(this.currentQuality.getValues().size() == valuesString.length){

            for(int i = 0; i < valuesString.length; i++){

                System.out.println("Trying: " + i + " -> " + dt.getSimpleName());
                String valueString = valuesString[i];

                Object obj = dataTypeChecker(dt, valueString);

                if(obj != null){
                    values.add(obj);
                }

            }


            try {
                Quality quality = null;
                //quality = TypeHelper.generateQuality(this.currentQuality.getName(), casfsadfasdfurrentQuality(), values);
                this.character.setQuality(this.character.getQualities().indexOf(this.currentQuality), quality);
            } catch (Exception e){

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(e.toString());
                a.show();
            }

            this.loadQuality();
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Please give the same amount of arguments as already are given!");
            a.show();
        }
    }


    public void saveCharacter(){

        Stage saveStage = new Stage();

        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAVE CHARACTER", "*.json");
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "\\build\\resources\\main\\sample.characterDynamic"));
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog

        File file = fileChooser.showSaveDialog(saveStage);


        if (file != null) {
            try {
                saveWriter(file);
            }
            catch (IOException e){
                System.out.println("There is something wrong with the chosen file!\n" + e.toString());
            }
        }



    }

    public void saveWriter (File file) throws IOException {

        PrintWriter writer;
        writer = new PrintWriter(file);
        JSONObject jso = CharacterFileJsonSerialize.getJSON(this.character);
        writer.println(jso.toString(4));
        writer.close();
    }


    public Character getCharacter() {return character;}
    public void setCharacter(Character character) {this.character = character;}



}


