package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFaderListener;

public class MenuFadeBeforeIntroState implements StartMenuState, ScreenFaderListener {

    private StartMenu startMenu;
    private ScreenFader screenFader;

    public MenuFadeBeforeIntroState(StartMenu startMenu) {
        this.startMenu = startMenu;
        this.screenFader = new ScreenFader();
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
        this.startMenu.setState(new MenuIntroState(this.startMenu));
    }
}
