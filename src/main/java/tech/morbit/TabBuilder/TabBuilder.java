package tech.morbit.TabBuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import tech.morbit.Character.Character;
import tech.morbit.Controller.CharacterDynamicController;

import javax.swing.plaf.synth.Region;
import java.io.IOException;

public class TabBuilder {


    public static Tab createCharacterTab(Character character) {

        try{
            FXMLLoader loader = new FXMLLoader(tech.morbit.App.Main.class.getResource("CharacterDynamic.fxml"));

            CharacterDynamicController cdc = loader.getController();


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
