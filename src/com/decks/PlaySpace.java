package com.decks;
import java.awt.*;
import java.util.*;

import com.decks.framework.Graphics;
import com.decks.framework.implementation.AndroidGraphics;

// Cards in play on the board
public class PlaySpace {
	
	private Map<String, Pile> inPlay; // Map of the cards each player has in play, but not in the played pile
	private Pile played; // All cards that are not in play currently, but have been played. 
	public int maxInPlay;
	
	// new empty PlaySpace
	// has piles for each player mapped to the player's name
	public PlaySpace(Set<String> players, int maxInPlay) {
		inPlay = new TreeMap<String, Pile>();
		for(String player: players) { // Generates empty piles for inPlay
			inPlay.put(player, new Pile(true, 0, 0, players));
		}
		played = new Pile(true, 0, 0, players); // Initiates empty pile of cards which have been played
		this.maxInPlay = maxInPlay;
	}
	
	// Adds a pile from a user to the PlaySpace tagged by their name, and 
	public void play(String player, Pile toAdd) {
		inPlay.get(player).addAll(toAdd);
		/*
		if(maxInPlay != -1) {
			ArrayList<String> temp = inPlay.keySet();
			int i = maxInPlay;
			while(!inPlay.isEmpty() && i <= 0) {
				inPlay.remove(key)
			}
		}
		*/
	}
	
	// Removes the pile inPlay by a user from the PlaySpace and returns it
	public Pile remove(String player) {
		return inPlay.get(player).removeAll();
	}
	
	// Removes all of the piles inPlay by all users from the PlaySpace and returns it as a single
	// Pile 
	public Pile removeAll() {
		Pile temp = new Pile(false, 0, 0, null);
		for(String player: inPlay.keySet()) {
			temp.addAll(remove(player));
		}
		return temp;
	}
   
   // Simple toString method
   public String toString() {
      return inPlay.toString() + played.toString();
   }
   
   // Draws the PlaySpace on the android canvas 
   public void draw(AndroidGraphics g) {
	   
   }

}
