package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.S;

public class CommandFadeInState implements StartMenuState {

    private StartMenu startMenu;
    private BitmapFont font;

    public CommandFadeInState(StartMenu startMenu) {
        this.startMenu = startMenu;
        this.font = new FontFactory().createDefault();
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onRender(SpriteBatch batch) {
        font.draw(batch, S.pressSpacebarToContinue(), 100, 100, C.sW(), 1, true);
    }

    @Override
    public void onDispose() {

    }
}
