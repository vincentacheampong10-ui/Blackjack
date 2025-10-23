package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> players = new ArrayList<>();

        System.out.print("Enter number of players(2-4):");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of player:");
            String name =scanner.nextLine();
            players.add(name);

        }

// deal 5 cards
            for (int i = 0; i < 5; i++) {
// get a card from the deck
                Card card = deck.deal();
                card.flip();
// deal that card to the hand
                hand1.Deal(card);
            }
        int handValue = hand1.getValue();
       // System.out.println("This hand is worth " + handValue);
    }
}

