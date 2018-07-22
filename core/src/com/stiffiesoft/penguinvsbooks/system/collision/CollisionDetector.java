package com.stiffiesoft.penguinvsbooks.system.collision;

import com.badlogic.gdx.physics.box2d.*;

public class CollisionDetector implements ContactListener {

    @Override
    public void beginContact(Contact contact) {

        //Get the fixtures that collided
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        //Get the real objects that collided
        Collidable collidableA = (Collidable)fixtureA.getUserData();
        Collidable collidableB = (Collidable)fixtureB.getUserData();

        //Get the collision groups from each collidable
        Short typeA = fixtureA.getFilterData().categoryBits;
        Short typeB = fixtureB.getFilterData().categoryBits;

        //Execute the onCollide method on both of these, include the other object in the parameters
        collidableA.onCollision(collidableB, typeB);
        collidableB.onCollision(collidableA, typeA);
    }

    @Override public void endContact(Contact contact) {}
    @Override public void preSolve(Contact contact, Manifold oldManifold) {}
    @Override public void postSolve(Contact contact, ContactImpulse impulse) {}
}
