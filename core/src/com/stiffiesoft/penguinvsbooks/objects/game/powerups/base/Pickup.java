package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;
import com.stiffiesoft.penguinvsbooks.system.text.DefinedColors;

public abstract class Pickup implements Transformable, Renderable, Collidable {

    protected Transform transform;
    protected Body body;
    protected PowerupFactory powerupFactory;
    protected PickupList pickupList;
    private ScreenFlasher screenFlasher;

    public Pickup(Transform transform, GameContext context) {
        this.transform      = transform;
        this.powerupFactory = context.getPowerupFactory();
        this.pickupList     = context.getPickupList();
        this.screenFlasher  = context.getScreenFlasher();
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
    public void onCollisionEnter(Collidable other, short type) {

        //Only enemy collisions will be handled here, pickup collisions will be handled in the pickup itself
        if (type == CollisionTypes.PLAYER) {

            //Flash the screen
            screenFlasher.flash(DefinedColors.PICKUP_FLASH);

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