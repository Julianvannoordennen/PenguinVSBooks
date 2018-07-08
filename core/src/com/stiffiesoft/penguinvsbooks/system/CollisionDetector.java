package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class CollisionDetector implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        System.out.println("Contact");
    }

    @Override
    public void endContact(Contact contact) {
        System.out.println("No Contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
