package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public abstract class LinearProjectile implements Transformable, Collidable, GameObject, Projectile {

    protected Transform transform;
    protected Body body;
    protected float speed;
    protected ProjectileList projectileList;

    public LinearProjectile(Transform transform, GameContext context) {

        //Save values
        this.transform      = transform;
        this.projectileList = context.getProjectileList();

        //Set default speed
        speed               = 1000f;
    }

    @Override
    public void update() {

        //Move towards target
        transform.moveInDirection( speed * C.cGT());

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Destroy self
        projectileList.destroy(this);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public boolean doesDamage() {
        return true;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }
}
