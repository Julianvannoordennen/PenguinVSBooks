package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;
import com.stiffiesoft.penguinvsbooks.system.FontFactory;

import java.util.Timer;

public class Main extends Game {

	private SpriteBatch batch;
	private FontFactory fontFactory;

	@Override
	public void create () {

		//Instantiate objects
		batch = new SpriteBatch();
		fontFactory = new FontFactory();

		//Open correct scene
		setScreen(new com.stiffiesoft.penguinvsbooks.scenes.Game(this));
	}

	@Override
	public void render () {

		//Render all
		super.render();
	}

	@Override
	public void dispose () {
	}

	//Getter
	public SpriteBatch getBatch() {
		return batch;
	}
	public FontFactory getFontFactory() {
		return fontFactory;
	}
}
