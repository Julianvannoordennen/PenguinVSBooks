package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFaderListener;
import com.stiffiesoft.penguinvsbooks.system.C;

public class ScreenFadeInState implements StartMenuState, ScreenFaderListener {

    private StartMenu startMenu;
    private ScreenFader screenFader;

    public ScreenFadeInState(StartMenu startMenu) {
        this.startMenu = startMenu;
        this.screenFader = startMenu.getScreenFader();
    }

    @Override
    public void onShow() {
        screenFader.fade(Color.BLACK, 1f, 0f, 1f, this);
    }

    @Override
    public void onRender(SpriteBatch batch) {
        screenFader.draw(batch);
    }

    @Override
    public void onDispose() {

    }

    @Override
    public void onFadeDone() {
        startMenu.setState(new CommandFadeInState(startMenu));
    }
}
