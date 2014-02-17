package com.decks;

import com.decks.framework.Game;
import com.decks.framework.Graphics;
import com.decks.framework.Graphics.ImageFormat;
import com.decks.framework.Screen;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		super(game);
	}
	

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);
        Assets.click = game.getAudio().createSound("explode.ogg");
        
        game.setScreen(new MainMenuScreen(game));
    }
    
    @Override
    public void paint(float deltaTime) {


    }


    @Override
    public void pause() {


    }


    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {


    }   
    

}
