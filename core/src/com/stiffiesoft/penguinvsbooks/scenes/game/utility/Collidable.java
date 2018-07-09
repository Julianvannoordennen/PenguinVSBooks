package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

public interface Collidable {

    void onCollision(Collidable other, short collisionType);
}
