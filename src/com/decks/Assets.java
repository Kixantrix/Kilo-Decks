package com.decks;

import java.util.*;

import com.decks.framework.Image;
import com.decks.framework.Sound;
import com.decks.SampleGame;

public class Assets {
	
	public static Image menu;					// Also from kilobolt menu system
	public static Sound click;					// From kilobolt
	public Set<Player> players;					// All players in game
	public ArrayList<Deck> decks; 				// All decks in play
	public ArrayList<DiscardPile> discardPiles; // All DiscardPiles in play
	public PlaySpace playSpace; 				// PlaySpace where players play cards
	public Board board; 						// Board where players cannot play cards

	public static void load(SampleGame sampleGame) {
	}
	
}
