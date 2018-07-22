package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

public class LinearProjectile implements Transformable, Collidable, Renderable, Projectile {

    protected Transform transform;
    protected Body body;
    protected float speed;
    protected ProjectileList projectileList;

    public LinearProjectile(Transform transform, ProjectileList projectileList) {

        //Save values
        this.transform = transform;
        this.projectileList = projectileList;

        //Set default speed
        speed = 1000f;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Move towards target
        transform.moveInDirection( speed * C.cGT());

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void onCollision(Collidable other, short collisionType) {

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
}
