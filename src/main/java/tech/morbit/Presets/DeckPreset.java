package tech.morbit.Presets;

import tech.morbit.Deck.Deck;
import tech.morbit.Features.DeckBuilder;

import java.util.Arrays;

public class DeckPreset {
    public static Deck getStandardPokerDeck(){
        DeckBuilder deckBuilder = new DeckBuilder();
        deckBuilder.addSuits(Arrays.asList("H", "S", "D", "C"));
        deckBuilder.addNames(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
        deckBuilder.generateDeck();
        return deckBuilder.getDeck();
    }

    public static Deck getStandardPokerDeckWithJokers(){
        Deck deck = getStandardPokerDeck();
        deck.addCard("JK", 3);
        return deck;
    }

    public static Deck getUnoDeck(){
        DeckBuilder deckBuilder = new DeckBuilder();
        deckBuilder.addSuits(Arrays.asList("G", "Y", "B", "R"));
        deckBuilder.addName("0");
        deckBuilder.addNames(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "S", "R", "D2"), 2);

        deckBuilder.generateDeck();
        Deck deck = deckBuilder.getDeck();
        deck.addCards(Arrays.asList("W", "W4" ), 4);
        return deck;
    }
}
