package tech.morbit.Features;

import tech.morbit.Deck.Deck;
import java.util.HashSet;
import java.util.Set;

public class DeckBuilder {
    private Deck deck;
    private Set<String> suits;
    private Set<String> names;

    public DeckBuilder() {
        deck = new Deck();
        suits = new HashSet<>();
        names = new HashSet<>();
    }

    public DeckBuilder(Deck deck) {
        this.deck = deck;
    }

    public DeckBuilder(Deck deck, Set<String> suits, Set<String> names) {
        this.deck = deck;
        this.suits = suits;
        this.names = names;
    }

    public Deck getDeck(){
        return deck;
    }

    public void addSuit(String suit){
        suits.add(suit);
    }

    public void addName(String name){
        names.add(name);
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

    }

}
