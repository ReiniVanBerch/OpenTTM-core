package tech.morbit.TabBuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import tech.morbit.Character.Character;
import tech.morbit.Controller.CharacterTabController;
import tech.morbit.Controller.MainController;


import java.io.IOException;

public class TabBuilder {


    public static Tab createCharacterTab(Character character) {

        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/tech/morbit/Main/CharacterTab.fxml"));

// Load the FXML and get the HBox (or root) node.
            HBox region = loader.load();

            CharacterTabController cdc = loader.getController();

            cdc.setCharacter(character);
            cdc.displayList();


            Tab tab = new Tab();
            tab.setText(character.getName());
            tab.setContent(region);
            return tab;

        } catch (IOException e) {
            e.printStackTrace();
        }



        return new Tab();
    }

}
