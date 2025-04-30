package tech.morbit.Game;

import tech.morbit.Features.TurnTracker;
import tech.morbit.Character.Character;
import tech.morbit.Tag.FunctionalTag;
import tech.morbit.Tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {
    public ArrayList<Character> characters;
    public TurnTracker turnTracker;

    public Set<Tag> tags = new HashSet<>();
    public Set<FunctionalTag> functionalTags = new HashSet<>();

    public Game(){characters = new ArrayList<>();}
    public Game(ArrayList<Character> characters){
        this.characters = characters;
    }

    public TurnTracker getTurnTracker() {return turnTracker;}
    public void setTurnTracker(TurnTracker turnTracker) {this.turnTracker = turnTracker;}

    public ArrayList<Character> getCharacters() {return characters;}
    public void setCharacters(ArrayList<Character> characters) {this.characters = characters;}
}
