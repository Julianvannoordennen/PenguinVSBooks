package com.stiffiesoft.penguinvsbooks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.system.C;

public class Main extends Game {

	private SpriteBatch batch;
	private Sprite imageLogo;
	private ScreenFader screenFader;

	@Override
	public void create () {

		//Instantiate objects
		batch 				= new SpriteBatch();
		imageLogo 			= new Sprite(new Texture("sprites/menu/menu_logo.png"));
		screenFader = new ScreenFader();

		//Set positions
		imageLogo.setSize(C.sH(), C.sH());
		imageLogo.setPosition((C.sW() / 2) - (imageLogo.getWidth() / 2),(C.sH() / 2) - (imageLogo.getHeight() / 2));

		screenFader.fade(Color.BLACK, 1f, 0f, 1, null);
	}

	@Override
	public void render () {

		//Clear screen
		Gdx.gl.glClearColor(0,0,0,255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Render textures
		batch.begin();

		//Default textures
		batch.draw(imageLogo, imageLogo.getX(), imageLogo.getY(), imageLogo.getWidth(), imageLogo.getHeight());

		//Effects
		screenFader.draw(batch);

		//End
		batch.end();
	}

	@Override
	public void dispose () {

		//Dispose
		batch.dispose();
	}
}
