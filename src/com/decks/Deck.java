package com.decks;


import java.io.*;
import java.util.*;

// Deck is a pile which can be filled with default values
public class Deck extends Pile {

	// default constructor
	// fills deck with cards representing all 52 cards in a standard deck
	// values assignment may later be changed, or replaced with final variables
	public Deck(boolean topVisible, int x, int y, Set<String> allowedViewers) {
		super(topVisible, x, y, allowedViewers);
		for (int i = 1; i <= 52; i++) {
			super.add(new Card(i, true, x, y));
		}
	}
	
	// File based constructor
	// takes a deck input file and builds a custom deck with custom cards
	public Deck(boolean topVisible, int x, int y, Set<String> allowedViewers, String filename) throws FileNotFoundException {
		super(topVisible, x, y, allowedViewers);
		Scanner deckFile = new Scanner(new File(filename));
		while (deckFile.hasNextLine()) {
			String[] cardLine = deckFile.nextLine().split("|");
			if (cardLine.length == 4) {					//number of this card in deck is specified
				for (int i = 1; i <= Integer.parseInt(cardLine[3]); i++) {
					super.add(new Card(cardLine[0], cardLine[2], Integer.parseInt(cardLine[1]), x, y));
				}
			} else {				//number of card is not specified, add 1
				super.add(new Card(cardLine[0], cardLine[2], Integer.parseInt(cardLine[1]), x, y));
			}
		}
		deckFile.close();
	}
}
