package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.Calc;

public class Main extends Game {

	private SpriteBatch batch;
	private Sprite imageLogo;

	@Override
	public void create () {

		//Instantiate objects
		batch = new SpriteBatch();
		imageLogo = new Sprite(new Texture("sprites/menu/menu_logo.png"));

		//Set positions
		imageLogo.setPosition((Calc.sW() / 2) - (imageLogo.getWidth() / 2),(Calc.sH() / 2) - (imageLogo.getHeight() / 2));
		imageLogo.setSize(Calc.sH(), Calc.sH());
	}

	@Override
	public void render () {

		//Clear screen
		Gdx.gl.glClearColor(0,0,0,255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Render textures
		batch.begin();
		batch.draw(imageLogo, imageLogo.getX(), imageLogo.getY(), imageLogo.getWidth(), imageLogo.getHeight());
		batch.end();
	}

	@Override
	public void dispose () {

		//Dispose
		batch.dispose();
	}
}
