package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public interface Projectile {

    void update();
    void render(SpriteBatch batch);
    Transform getTransform();
    Body getBody();
    boolean doesDamage();
    boolean outsideAllowed();
}
