package tech.morbit.Tools;

/**
 * @author Morbit
 * @version 0.1.3
 *
 *
 * PURPOSE:
 * This file converts json files to a character if possible.
 */

import org.json.JSONArray;
import org.json.JSONObject;
import tech.morbit.Character.Character;
import tech.morbit.Exception.InvalidInputException;
import tech.morbit.Exception.InvalidTypeException;
import tech.morbit.Quality.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.ArrayList;


public class CharacterFileJsonDeserialize {



    public static Character getCharacter(File jsonFile) throws Exception {
        String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));
        return CharacterFileJsonDeserialize.getCharacter(jsonContent);
    }

    public static Character getCharacter(String jsonContent) throws Exception {
        JSONObject jsonObject = new JSONObject(jsonContent);
        return getCharacter(jsonObject);
    }

    static public Character getCharacter(JSONObject jObj) throws Exception {


        String name = jObj.getString("name");
        JSONArray jQualities = jObj.getJSONArray("qualities");


        ArrayList<Quality> qualities = new ArrayList<>();

        for (int i = 0; i < jQualities.length(); i++) {
            JSONObject jQuality = jQualities.getJSONObject(i);

            Quality q = resolveQuality(jQuality);
            qualities.add(q);
        }

        return new Character(name, qualities);
    }

    static public Quality resolveQuality(JSONObject jQuality) throws InvalidInputException, InvalidTypeException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        String name = jQuality.getString("name");
        String qualityString = jQuality.getString("quality").toLowerCase();
        String typeString = jQuality.getString("type");
        JSONArray jValues = jQuality.getJSONArray("values");

        //System.out.println("Resolving... " + name + " - " + qualityString + " - " + typeString);



        ArrayList<?> values = createTypedList(typeString, jValues);



        switch (qualityString) {
            case "fixedvalue":
                return new FixedValue(name, values);

            case "changingvalue":
                return new ChangingValue(name, values);

            case "range":
                return new Range(name, values);

            case "rangedvalue":
                return new RangedValue(name, values);

            case "listvalue":
                return new ListValue(name, values);

            default:
                throw new InvalidTypeException();
        }
    }

    private static <T> ArrayList<T> createTypedList(String type, JSONArray inputValues) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvalidInputException, InvalidTypeException, ClassNotFoundException {
        // Create a typed ArrayList
        ArrayList<T> typedList = new ArrayList<>();

        for (int i = 0; i < inputValues.length() ; i++) {

            T value = null;

            if (type.equals("Integer" )|| type.equals("int")) {

                value = (T) Integer.valueOf(inputValues.getInt(i));

            } else if (type.equals("double") || type.equals("Double")) {

                value = (T) Double.valueOf(inputValues.getDouble(i));

            } else if (type.equals("Boolean") || type.equals("boolean") || type.equals("bool")) {

                value = (T) Boolean.valueOf(inputValues.getBoolean(i));

            } else if (type.equals("String")) {

                value = (T) String.valueOf(inputValues.getString(i));
            } else if (type.equals("Quality")) {

                value = (T) (Quality) resolveQuality(inputValues.getJSONObject(i));
            } else {
                // Use a constructor or reflection for other types
                System.out.println(type + ": " + inputValues.get(i));
                throw new InvalidInputException();
            }
            typedList.add(value);

        }

        return typedList;
    }
}