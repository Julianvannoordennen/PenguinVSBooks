package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;
import com.stiffiesoft.penguinvsbooks.system.FontFactory;

public class Main extends Game {

	private SpriteBatch batch;
	private FontFactory fontFactory;
	protected ScreenFader screenFader;

	@Override
	public void create () {

		//Instantiate objects
		batch = new SpriteBatch();
		fontFactory = new FontFactory();
		screenFader = new ScreenFader();

		//Open correct scene
		setScreen(new StartMenu(this));
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
	public ScreenFader getScreenFader() {
		return screenFader;
	}
}
