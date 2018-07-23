package com.stiffiesoft.penguinvsbooks.system.collision;

import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public interface Collidable {

    void onCollision(Collidable other, short collisionType);
    Transform getTransform();
    void setBody(Body body);
    Body getBody();
}
