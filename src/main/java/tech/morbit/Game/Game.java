package tech.morbit.Game;

import tech.morbit.Features.TurnTracker;
import tech.morbit.Character.Character;

import java.util.ArrayList;

public class Game {
    public ArrayList<Character> characters;
    public TurnTracker turnTracker;

    public Game(){characters = new ArrayList<>();}
    public Game(ArrayList<Character> characters){
        this.characters = characters;
    }

    public TurnTracker getTurnTracker() {
        return turnTracker;
    }

    public void setTurnTracker(TurnTracker turnTracker) {
        this.turnTracker = turnTracker;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }
}
