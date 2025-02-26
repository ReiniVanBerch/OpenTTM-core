package tech.morbit.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import tech.morbit.Exception.InvalidInputException;
import tech.morbit.Quality.FixedValue;
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
    public void initialize() throws InvalidInputException {
        super.initialize();
        loadDataTypes();
        loadQualityTypes();
    }

    public void resettleQuality(Quality parent, ArrayList<TreeItem<Quality>> children) {
        if (parent.getTypeOfValues() == Quality.class){
            TreeItem qualityItem = new TreeItem<>(parent);
            TreeItem childrenParent = children.getFirst().getParent();

            //int c = parent.getQuality().get;

            for (int i = 0; i < children.size(); i++) {
                TreeItem<Quality> q = children.get(i);



                qualityItem.getChildren().add(q);
                childrenParent.getChildren().remove(q);
            }

            childrenParent.getChildren().add(qualityItem);

        }




    }

    public void buildCharacter(){
        if(!characterName.getText().isEmpty()){
            character.setName(characterName.getText());
            qualityTreeView.getSelectionModel();

            saveCharacter();
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

    public void saveQuality() {
        Class dataType = dataTypeChoiceBox.getValue();
        Class<? extends Quality> qualityType = qualityTypeChoiceBox.getValue();

        if(dataType.equals(Quality.class)){
            ObservableList ol = qualityTreeView.getSelectionModel().getSelectedItems();
            if( ol.size() == 0);
        }


    }



}
