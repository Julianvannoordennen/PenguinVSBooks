package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

public abstract class Pickup implements Transformable, Renderable, Collidable {

    protected Transform transform;
    protected Body body;
    protected PowerupFactory powerupFactory;
    protected PickupList pickupList;

    public Pickup(Transform transform, PowerupFactory powerupFactory, PickupList pickupList) {
        this.transform = transform;
        this.powerupFactory = powerupFactory;
        this.pickupList = pickupList;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void onCollision(Collidable other, short type) {

        //Only enemy collisions will be handled here, pickup collisions will be handled in the pickup itself
        if (type == CollisionTypes.PLAYER) {

            //Picked up the pickup, execute pickup script
            onPickup();

            //Remove itself when picked up
            pickupList.destroy(this);
        }
    }

    public abstract void onPickup();

    @Override
    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public Body getBody() {
        return body;
    }
}