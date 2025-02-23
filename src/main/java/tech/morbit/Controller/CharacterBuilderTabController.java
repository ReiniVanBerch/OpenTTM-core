package tech.morbit.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import tech.morbit.Quality.Quality;

import java.util.ArrayList;

public class CharacterBuilderTabController extends CharacterTabController{

    @FXML
    private TextField characterName;



    @FXML
    private ChoiceBox<Class<? extends Quality>> qualityTypeChoiceBox;
    @FXML
    private ChoiceBox<Class> dataTypeChoiceBox;

    @Override
    public void initialize() {
        super.initialize();
        loadDataTypes();
        loadQualityTypes();
    }

    public void buildCharacter(){
        if(!characterName.getText().isEmpty()){
            character.setName(characterName.getText());
            qualityTreeView.getSelectionModel();
        }

    }

    public void loadQualityTypes(){
        ArrayList<Class<? extends Quality>> q = Quality.getClassAndChildren();

        for(int i = 1; i < q.size(); i++){
            qualityTypeChoiceBox.getItems().add(q.get(i));
        }

    }

    public void loadDataTypes(){
        dataTypeChoiceBox.getItems().addAll(boolean.class, int.class, double.class, String.class, Quality.class);
    }

    public void addQuality() {


    }



}
