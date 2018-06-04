package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;

public class Main extends Game {

	private SpriteBatch batch;

	@Override
	public void create () {

		//Instantiate objects
		batch = new SpriteBatch();

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

	//SpriteBatch getter
	public SpriteBatch getBatch() {
		return batch;
	}
}
