package com.decks;

import com.decks.framework.Screen;
import com.decks.framework.implementation.AndroidGame;

public class DecksGame extends AndroidGame {
	
	public Screen getInitScreen() {
		@Override
		public Screen getInitScreen() {
			return new LoadingScreen(this);
		}
	}

}
