package com.decks;
import java.util.Set;

// class to describe specific DiscardPile behavior
public class DiscardPile extends Pile {
	
	// constructs as empty Pile with assigned characteristics
	// Usually top will be visible, and all players will be able to view pile
	public DiscardPile(boolean topVisible, int x, int y, Set<String> players) {
		super(topVisible, x, y, players);
		
	}

}
