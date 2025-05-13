package tech.morbit.Features;

import tech.morbit.Deck.Deck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckBuilder {
    private Deck deck;
    private Set<String> suits;
    private List<String> names;

    public DeckBuilder() {
        deck = new Deck();
        suits = new HashSet<>();
        names = new ArrayList<>();
    }

    public DeckBuilder(Deck deck) {
        this.deck = deck;
    }

    public DeckBuilder(Deck deck, Set<String> suits, List<String> names) {
        this.deck = deck;
        this.suits = suits;
        this.names = names;
    }

    public Deck getDeck(){
        return deck;
    }

    public void clearSuits(){this.suits.clear();}
    public void addSuit(String suit){
        this.suits.add(suit);
    }
    public void addSuits(List<String> suits){this.suits.addAll(suits);}

    public void clearNames(){this.names.clear();}
    public void addName(String name){
        this.names.add(name);
    }
    public void addName(String name, int count){
        for (int i = 0; i < count; i++) {
            this.names.add(name);
        }
    }
    public void addNames(List<String> names){
        this.names.addAll(names);
    }
    public void addNames(List<String> names, int count){
        for(int i=0; i<count; i++){addNames(names);}
    }

    public void generateDeck(){
        for (String suit : suits) {
            for (String name : names) {deck.addCard(suit + name);}
        }
    }

    public void clearDeck(){
        this.deck = new Deck();
    }

    public void shuffleDeck(){
        this.deck.shuffleDeck();
    }

}
