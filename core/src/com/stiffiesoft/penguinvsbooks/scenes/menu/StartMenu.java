package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.scenes.BaseScene;
import com.stiffiesoft.penguinvsbooks.system.C;

public class StartMenu extends BaseScene {

    private StartMenuState state;
    private Sprite imageLogo;

    public StartMenu(Main main) {

        //Super
        super(main);

        //Instantiate
        state = new MenuFadeBeforeIntroState(this);

        //Instantiate
        imageLogo = new Sprite(new Texture("sprites/menu/menu_logo.png"));

        //Set positions
        imageLogo.setSize(C.sH(), C.sH());
        imageLogo.setPosition((C.sW() / 2) - (imageLogo.getWidth() / 2),(C.sH() / 2) - (imageLogo.getHeight() / 2));
    }

    @Override
    protected void onRender(SpriteBatch batch) {
        batch.draw(imageLogo, imageLogo.getX(), imageLogo.getY(), imageLogo.getWidth(), imageLogo.getHeight());
        state.onRender(batch);
    }

    @Override
    protected void onDispose() {
        state.onDispose();
    }


    public void setState(StartMenuState state) {
        this.state = state;
    }
}
