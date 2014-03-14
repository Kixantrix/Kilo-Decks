package com.decks;

import java.util.ArrayList;

// Collects and interpurrrrrrrrrates events which take place in the game for execution 
public class EventListener {
	
	private ArrayList<String> events; // record of all of the events that have taken place
	
	// Creates a new EventListener with a new event list
	public EventListener() {
		events = new ArrayList<String>();
	}
	
	// Returns the current state of the events list and then removes all entries from it
	public ArrayList<String> removeEvents() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(events);
		events.removeAll(events);
		return temp;
	}

}
