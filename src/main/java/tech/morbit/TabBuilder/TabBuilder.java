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
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("CharacterDynamic.fxml"));
            System.out.println("Test:" + loader.toString());
            CharacterTabController cdc = loader.getController();


            cdc.setCharacter(character);
            cdc.displayList();


            HBox region = loader.load();
            Tab tab = new Tab(character.getName());
            tab.setContent(region);

        } catch (IOException e) {
            e.printStackTrace();
        }



        return new Tab();
    }

}
