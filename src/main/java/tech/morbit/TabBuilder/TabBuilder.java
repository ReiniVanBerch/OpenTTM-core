package tech.morbit.TabBuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import tech.morbit.Character.Character;
import tech.morbit.Controller.CharacterTabController;
import tech.morbit.Controller.InitiativeTabController;
import tech.morbit.Controller.MainController;


import java.io.IOException;

public class TabBuilder {

    private static Tab createTab(Region region, String text){
        Tab tab = new Tab();
        tab.setText(text);
        tab.setContent(region);
        return tab;
    }


    public static Tab createCharacterTab(Character character) {

        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/tech/morbit/Main/CharacterTab.fxml"));

            HBox region = loader.load();

            CharacterTabController cdc = loader.getController();

            cdc.setCharacter(character);
            cdc.displayList();

            return createTab(region, character.getName());

        } catch (IOException e) { e.printStackTrace(); }
        return new Tab();
    }

    public static Tab createCharacterBuilderTab() {
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/tech/morbit/Main/CharacterBuilderTab.fxml"));

            HBox region = loader.load();

            CharacterTabController cdc = loader.getController();



            return createTab(region, "Builder");

        } catch (IOException e) { e.printStackTrace(); }
        return new Tab();
    }

    public static Tab createInitiativeTab(){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/tech/morbit/Main/InitiativeTab.fxml"));

            HBox region = loader.load();

            return createTab(region, "Initiative");

        } catch (IOException e) { e.printStackTrace(); }

        return new Tab();
    }

}
