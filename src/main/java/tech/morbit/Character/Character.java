package tech.morbit.Character;

import tech.morbit.Quality.*;

import java.util.ArrayList;

/**
 * @author Morbit
 * @version 0.1.3
 *
 * PURPOSE:
 * Handling of a character and its qualities.
 * We figured the sole thing a character definitely and surely has is a name.
 * Everything else, whether it's HP or XP, Constituion or Insanity, will be given him in an list.
 * This list contains "qualities" these define our characters.
 *
 * For the list of qualities see {@link Quality}
 * TODO:
 * -Include more Checks
 * -Comment things better
 */


public class Character {


    ArrayList<Quality> qualities = new ArrayList<>();
    public Character(String name) {
        this.name = name.strip();
    }

    public Character(String name, ArrayList<Quality> qualities) {
        this(name);
        this.qualities = qualities;
    }

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name.strip();
    }


    public void setQualities (ArrayList<Quality> qualities){
        this.qualities = qualities;
    }

    public void setQuality (int index, Quality quality){
        this.qualities.set(index, quality);
    }

    public ArrayList<Quality> getQualities() { return qualities; }
    public ArrayList<String> getQualitiesAsString() {
        ArrayList<String> qualitiesAsString = new ArrayList<>();
        for (Quality q : this.qualities) {
            qualitiesAsString.add(q.getName());
        }
        return qualitiesAsString;
    }

    public <T extends Quality> void addQuality(T quality) {
        qualities.add(quality);
    }


    @Override
    public String toString() {

        String output = name + " ~ \n";
        for (Quality q : qualities) {
            output += q.toString() + "\n";
        }

        return output;
    }
}
