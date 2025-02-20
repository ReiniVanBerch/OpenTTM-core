package tech.morbit.Tools;

import org.json.JSONArray;
import org.json.JSONObject;
import tech.morbit.Character.Character;
import tech.morbit.Quality.Quality;

import java.util.ArrayList;

public class CharacterFileJsonSerialize {
    static public JSONObject getJSON(Character character) {



        if (character == null) {
            throw new IllegalArgumentException("Character object cannot be null.");
        }

        JSONObject characterJson = new JSONObject();
        characterJson.put("name", character.getName());

        JSONArray qualitiesArray = new JSONArray();



        for (Quality quality : character.getQualities()) {
            qualitiesArray.put(decodeQuality(quality));
        }

        // Add qualities to the main JSON object
        characterJson.put("qualities", qualitiesArray);

        // Return the JSON string
        return characterJson;
    }

    static public JSONObject decodeQuality(Quality quality){

        JSONObject jsonQuality = new JSONObject();
        JSONArray jsonValues = new JSONArray();

        Class type = quality.getTypeOfValues();

        jsonQuality.put("name", quality.getName());
        jsonQuality.put("quality", quality.getClass().getSimpleName());

        ArrayList<Object> values = quality.getValues();

        if(Quality.getClassAndChildren().contains(type)){

            jsonQuality.put("type", "Quality");
            for (int i = 0; i < quality.getValues().size(); i++) {
                Quality q = (Quality) quality.getValues().get(i);
                jsonValues.put(decodeQuality(q));
            }

        } else{

            jsonQuality.put("type", type.getSimpleName());
            for (int i = 0; i < quality.getValues().size(); i++) {
                jsonValues.put(values.get(i));
            }
        }

        jsonQuality.put("values", jsonValues);
        return  jsonQuality;
    }
}
