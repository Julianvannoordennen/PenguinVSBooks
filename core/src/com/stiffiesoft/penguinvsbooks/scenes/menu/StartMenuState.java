package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface StartMenuState {

    void onShow();
    void onRender(SpriteBatch batch);
    void onDispose();
}
