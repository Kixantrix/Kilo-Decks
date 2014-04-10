package com.decks;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.decks.framework.Graphics;
import com.decks.framework.implementation.AndroidGraphics;

// A class to describe each player who is within a game


public class Player {
	public static final int CARDHEIGHT = 50; // Height of a card as seen by player
	public static final int CARDWIDTH  = 50; // Width of a card as seen by player
	
	public Pile hand;			 // player's hand, accessible outside 
	private String name;		 // name of player
	private boolean isDealer;	 // whether player is the current dealer, not sure if needed
	private Set<Pile> otherPiles;// non-hand piles the player possesses.
	private int x;				 // x-position of player on screen
	private int y; 				 // y-position of player on screen 
	private boolean isMainPlayer;// indicates whether this is the player playing locally 
	
	// constructor
	public Player(String name, boolean isMainPlayer) {
		this.name = name;
		isDealer = false;
		Set<String> temp = new TreeSet<String>(); // Set containing only player's name
		temp.add(name);
		hand = new Pile(false, 0, 0, temp);       // New hand viewable by player
		otherPiles = new TreeSet<Pile>();
		this.isMainPlayer = isMainPlayer;
	}
	
	// Returns name
	public String getName() {
		return name;
	}
	
	// Sets name to passed in String
	public void setName(String name) {
		this.name = name;
	}
	
	// returns if player is the dealer
	public boolean getDealer() {
		return isDealer;
	}
	
	// sets player to either be dealer or not be dealer
	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}
	
	// adds a new pile to the otherPiles
	public void add(Pile pile) {
		otherPiles.add(pile);
	}
	
	//returns x position
	public int getX() {
		return x;
	}
	
	// returns y position
	public int getY() {
		return y;
	}
	
	// sets x coordinate
	public void setX(int x) {
		this.x = x;
	}
	
	// sets y coordinate
	public void setY(int y) {
		this.y = y;
	}
	
	// draws the representation of the player in game, either as a version others see, or as the
	// version the player sees of themself. 
	public void draw(AndroidGraphics g, int viewX, int viewY) {
		if(isMainPlayer) {
			drawHand(g);
			// logic for drawing other info in default position
		} else {
			// draw information as others would see it
		}
	}
	
	// Draws the cards in the hand as they are seen 
	public void drawHand(AndroidGraphics g, int viewX) {
		ArrayList<Card> playerHand = hand.getPile();
		for(int i = 0; i < playerHand.size(); i++) {
			float rotation = 90; // rotation of card in hand
			int changeX = x;     // x position of card in hand
			int changeY = y;     // y position of card in hand
			g.drawTransformedImage(playerHand.get(i).getImage(), x, y, CARDWIDTH, CARDHEIGHT,
					1, 1, CARDWIDTH, CARDHEIGHT, rotation);
		}
	}
	
	// returns if the player is the local player
	public boolean isMainPlayer() {
		return isMainPlayer;
	}
}