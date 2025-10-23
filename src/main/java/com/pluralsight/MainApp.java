package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Hand hand1 = new Hand();

        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask how many players
        System.out.print("Enter number of players (1–4):");
        int playerCount = scanner.nextInt();
        scanner.nextLine();

        // Step 2: Store player names
        ArrayList<String> playerNames = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            playerNames.add(scanner.nextLine());
        }

        // Step 3: Create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("\nDeck created and shuffled. Cards remaining: " + deck.getSize());

        // Step 4: Create an ArrayList to hold each player's hand
        ArrayList<Hand> playerHands = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            playerHands.add(new Hand());
        }

        // Step 5: Deal 2 cards to each player
        System.out.println("\nDealing 2 cards to each player...\n");
        for (Hand hand : playerHands) {
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // Step 6: Show each player's hand and total value
        int winningValue = 0;
        String winner = "";

        for (int i = 0; i < playerCount; i++) {
            String name = playerNames.get(i);
            Hand hand = playerHands.get(i);

            System.out.println(name + "'s hand:");
            hand.showCards();
            int value = hand.getValue();
            System.out.println("Total value: " + value + "\n");

            // Determine winner (closest to 21 without going over)
            if (value <= 21 && value > winningValue) {
                winningValue = value;
                winner = name;
            }
        }

        // Step 7: Declare the winner
        if (!winner.equals("")) {
            System.out.println("Winner: " + winner + " with " + winningValue + " points!");
        } else {
            System.out.println("No winner. All of you suck!");
        }

        System.out.println("\nGame Over!");
    }
}



