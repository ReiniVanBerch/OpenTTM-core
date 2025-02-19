package tech.morbit.Tools;

/**
 * @author Morbit
 * 0.1.3
 *
 *  PURPOSE:
 *  This file converts json files to a chacter if possible, and converts character back to json.
 */

import tech.morbit.Character.Character;
import tech.morbit.Exception.InvalidTypeException;
import tech.morbit.Quality.Quality;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;

public class CharacterFileHandler {

    public Character getCharacter(File jsonFile) throws JSONException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));
        return this.getCharacter(jsonContent);
    }

    public Character getCharacter(String jsonContent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            JSONObject jsonObject = new JSONObject(jsonContent);
            return getCharacter(jsonObject);
    }

    static public Character getCharacter(JSONObject jObj) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println(jObj.toString());
        String name = jObj.getString("name");
        JSONArray jQualities = jObj.getJSONArray("qualities");


        ArrayList<Quality> qualities = new ArrayList<>();

        for (int i = 0; i < jQualities.length(); i++) {
            JSONObject jQuality = jQualities.getJSONObject(i);

            String comment = jQuality.getString("comment");
            int typeNumber = jQuality.getInt("typeNumber");
            JSONArray jValues = jQuality.getJSONArray("values");

            ArrayList<Object> values = new ArrayList<>();


            for (int j = 0; j < jValues.length(); j++) {
                Object jValue = jValues.get(j);


                //Other than the intellisense suggesting, these casts are not redundant.
                //Because values are Object Lists we are passing a more defined child
                //This is to better handle the values later.
                if (jValue instanceof Integer) {
                    values.add((int) jValue);
                } else if (jValue instanceof BigDecimal) {
                    values.add(((BigDecimal) jValue).doubleValue());
                } else if (jValue instanceof Boolean) {
                    values.add((boolean) jValue);
                } else if (jValue instanceof String) {
                    values.add((String) jValue);
                } else {
                    values.add(jValue.toString());
                }
            }


            try{
                Quality q = TypeHelper.generateQuality(comment, typeNumber, values);
                qualities.add(q);
            } catch(InvalidTypeException e){
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("INVALID TYPING");
                a.setContentText("Your character still will be loaded, but there may be something missing.");
                a.show();
            }


        }

        return new Character(name, qualities);
    }

    static public JSONObject getJSON(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character object cannot be null.");
        }

        JSONObject characterJson = new JSONObject();
        characterJson.put("name", character.getName());

        JSONArray qualitiesArray = new JSONArray();


        for (Quality quality : character.getQualities()) {
            JSONObject qualityJson = new JSONObject();

            JSONArray valuesArray = new JSONArray(quality.getValues());

            qualityJson.put("comment", quality.getName());
            qualityJson.put("values", valuesArray);


            qualitiesArray.put(qualityJson);
        }

        // Add qualities to the main JSON object
        characterJson.put("qualities", qualitiesArray);

        // Return the JSON string
        return characterJson;
    }
}