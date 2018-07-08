package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.menu.LoadScene;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;

public class Main extends Game {

	private SpriteBatch batch;
	private FontFactory fontFactory;

	@Override
	public void create () {

		//Instantiate objects
		batch = new SpriteBatch();

		//Open correct scene
		setScreen(new LoadScene(this));
	}

	public void createAfterAssetLoading() {

		//Instantiate objects that can only be accesses with loaded assets
		fontFactory = new FontFactory();

		//Load start menu
		setScreen(new com.stiffiesoft.penguinvsbooks.scenes.game.Game(this));
	}

	@Override
	public void render () {

		//Render all
		super.render();
	}

	@Override
	public void dispose () {
		A.dispose();
	}

	//Getter
	public SpriteBatch getBatch() {
		return batch;
	}
	public FontFactory getFontFactory() {
		return fontFactory;
	}

}
