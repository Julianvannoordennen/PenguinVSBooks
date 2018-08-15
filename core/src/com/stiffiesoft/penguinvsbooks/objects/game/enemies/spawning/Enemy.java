package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public interface Enemy {

    void update();
    void render(SpriteBatch batch);
    float getDefaultSpeed();
    void setSpeed(float speed);
    Body getBody();
    Transform getTransform();
}
