package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {

    void update();
    void render(SpriteBatch batch);
    int getDepth();
}
