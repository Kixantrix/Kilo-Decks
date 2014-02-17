package com.decks;

// Defines a card that could be used in a game of cards and makes up the contents of a pile

import java.awt.*;
import java.net.URL;

import com.decks.framework.Image;

// import android.media.Image;
public class Card implements Comparable<Card> {
	private int value;   	   // Value from 0 - 14 of the card, ace is either 0 or 14
	private String suit; 	   // Suit of the card in normal suits
	private int centerX; 	   // Center x coordinate
	private int centerY; 	   // Center y coordinate
	private String name; 	   // Full string name of the card
	private Image image; 	   // image used to draw the card
	private boolean isSelected; // True if it is, else false
	
	// builds card, assigning value and suit
	// takes a value 1-52 to correspond to a card in a deck, and converts that to a 
	// number 0-14 corresponding to the value of that card. The suit is similarly assigned.
	// aceshigh determines 
	public Card(int value, boolean acesHigh, int x, int y) {
		// assigns coordinates
		this.centerX = x;
		this.centerY = y;
		
		isSelected = false;
		
		// assigns value
		if(value % 13 == 1) { // ace case
			if(acesHigh) {    // assigns ace value to 14 if high, 1 if low
				this.value = 14;
			} else {
				this.value = 1;
			}
		} else if(value % 13 == 0) {
			this.value = 13;  // king case
		} else {              // otherwise assigns value according to 1 - 13 range
			this.value = value % 13;
		}
		
		// assigns suit
		switch((value-1) / 13) {  // smallest values clubs, then diamonds, etc
			case 0: suit = "Clubs";
			break;
			case 1: suit = "Diamonds";
			break;
			case 2: suit = "Hearts";
			break;
			case 3: suit = "Spades";
			break;
			default: suit = "joker"; 
			break; // default suit is joker
		}
		
		// Assigns the name of the card
		if(this.value >= 2 && this.value <= 10) { // simple case
			name = "" + this.value + " of " + suit;
		} else { 						// complex case
			String temp;
			switch(this.value) {             
				case 1:  temp = "Ace";
				break;
				case 11: temp = "Jack";
				break;
				case 12: temp = "Queen";
				break;
				case 13: temp = "King";
				break;
				case 14: temp = "Ace";
				break;
				default: temp = "joker"; 
				break;
			}
			name = temp + " of " + suit;
		}
	}
	
	//general-case constructor for custom decks
	public Card(String name, String suit, int value, int centerX, int centerY) {
		this.name = name;
		this.suit = suit;
		this.value = value;
		this.centerX = centerX;
		this.centerY = centerY;
	}

	public String toString() {
		return name;
	}
	
	// returns suit of card
	public String getSuit() {
		return suit;
	}
	
	// return value of card
	public int getValue() {
		return value;
	}
	
	// Triggers card to be selected
	public void select() {
		isSelected = true;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	// compares two cards based on first their suit alphabetically, and then breaks ties with 
	//	card value.
	public int compareTo(Card other) {
		if(suit.equals(other.suit)) {
			return value - other.value;
		} else {
			return suit.compareTo(other.suit);
		}
	}
	
	// Do not know how to get images in constructor, so this message allows images to be generated
	// in Decks and passed in to the cards.
	public void setImage(Image other) {
		image = other;
	}
	
	// Returns the image of the card
	public Image getImage() {
		return image;
	}
	
}
