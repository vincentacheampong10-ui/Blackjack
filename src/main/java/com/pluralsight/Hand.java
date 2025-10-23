package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // A Card is dealt to the Hand and the Hand is responsible
// to store the card
    public void deal(Card card) {
        card.flip();
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            value += card.getPointValue();
        }
        return value;
    }
    public void showCards() {
        for (Card card : cards) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }
}

