package tech.morbit.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }


    public <T> Deck(List<T> cards) {
        this.addCards(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(String card) {
        this.cards.add(new Card(card));
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public <T> void addCards(List<T> cards) {

        this.cards = new ArrayList<>();

        if (!cards.isEmpty()) {
            Object first = cards.get(0);

            if (first instanceof String) {
                for (T item : cards) {
                    this.cards.add(new Card((String) item));
                }
            } else if (first instanceof Card) {
                for (T item : cards) {
                    this.cards.add((Card) item);
                }
            } else {
                throw new IllegalArgumentException("Unsupported card type: " + first.getClass());
            }
        }

    }



    public void shuffleDeck(){
        Collections.shuffle(cards);
    }



}
