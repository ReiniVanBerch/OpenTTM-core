package tech.morbit.Features;

import tech.morbit.Deck.Deck;
import java.util.HashSet;
import java.util.List;
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
        this.suits.add(suit);
    }

    public void addSuits(List<String> suits{
        this.suits.addAll(suits);
    }


    public void addName(String name){
        this.names.add(name);
    }

    public void addNames(List<String> names){
        this.names.addAll(names);
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
