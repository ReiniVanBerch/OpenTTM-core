package tech.morbit.Deck;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;

    public Card(String name){
        this.name = name;
    }


    public static List<Card> stringToCards(List<String> cards){
        List<Card> cardList = new ArrayList<Card>();
        for(String card : cards){
            cardList.add(new Card(card));
        }
        return cardList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
