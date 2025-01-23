package tech.morbit.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.lang.reflect.Array;
import java.util.List;

public class InitiativeController {

    @FXML
    private ListView<String> listInvolved;

    @FXML
    public void initialize(){

    }

    public void listRotate(){
        List<String> involved = listInvolved.getItems();

    }


}
