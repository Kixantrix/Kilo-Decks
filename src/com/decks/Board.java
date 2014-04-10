package com.decks;

import java.util.*;

import com.decks.framework.Graphics;

// defines the card on the board that are not directly related to any played in particular place
public class Board {
	
	private Map<String, Pile> boardPiles; // Set of all piles on board
	
	// constructor
	public Board() {
		boardPiles = new TreeMap<String, Pile>(); // board is empty to start, added to in game
		
		
	}
	
	// Returns the set of Piles to directly alter
	public Set<Pile> boardPiles() {
		return (Set)boardPiles.values();
	}
	
	// Returns a pile with the given name
	public Pile getPile(String name) {
		return boardPiles.get(name);
	}
	
	// adds a Pile to the board
	public void add(Pile pile, String pileName) {
		boardPiles.put(pileName, pile);
	}
	
	// Returns a pile of cards of given name and removes them from the board
	public Pile removePile(String name) {
		return boardPiles.remove(name);
	}
	
	// Draws all items on board
	public void draw(Graphics g) {
		Set<String> piles = boardPiles.keySet();
		for(String key: piles) {
			boardPiles.get(key).draw(g);
		}
	}

}
