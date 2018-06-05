package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.Main;

public class Game extends BaseScene {

    private Sprite imageLogo;

    public Game(Main main) {
        super(main);

        //Instantiate
        imageLogo = new Sprite(new Texture("sprites/menu/menu_logo.png"));
    }

    @Override
    protected void onRender(SpriteBatch batch) {
        batch.draw(imageLogo,0,0);
    }

    @Override
    protected void onDispose() {

    }
}
