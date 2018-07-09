package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Collidable;

public interface PlayerState {

    void render(SpriteBatch batch);
    void onCollision(Collidable other);
}
