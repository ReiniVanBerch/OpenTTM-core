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
        deck.addCards(Arrays.asList("JK", "JK", "JK"));
        return deck;
    }
}
