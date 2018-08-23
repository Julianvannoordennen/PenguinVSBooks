package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.saw;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class SawProjectile  implements Projectile, Transformable, Collidable, GameObject {

    private Body body;
    private Transform transform;
    private ProjectileList projectileList;
    private JunkFactory junkFactory;
    private float rotationSpeed;
    private float normalRotationSpeed;
    private float hitRotationSpeed;
    private float hitLowerAmount;
    private int amount;

    public SawProjectile(Transform transform, GameContext context) {

        //Save values
        this.transform              = transform;
        this.projectileList         = context.getProjectileList();
        this.junkFactory            = context.getJunkFactory();
        this.normalRotationSpeed    = 200;
        this.rotationSpeed          = this.normalRotationSpeed;
        this.hitRotationSpeed       = 800;
        this.hitLowerAmount         = 2000;

        //How many hits can the saw contain?
        this.amount                 = 150;
    }

    @Override
    public void update() {

        //Rotate the saw
        transform.rotate(rotationSpeed * C.cGT());

        //Check if we need to lower the rotation speed
        if (rotationSpeed > normalRotationSpeed)

            //Lower the rotation speed
            rotationSpeed -= hitLowerAmount * C.cGT();

        else

            //Apply default speed
            rotationSpeed = normalRotationSpeed;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.sawPickup), transform);
    }

    private void checkAmount() {

        //Check if amount is below zero
        if (amount < 0) {

            //Create junk
            junkFactory.createSawJunk(transform.clone());

            //Destroy the saw
            projectileList.destroy(this);
        }
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Decrease the amount of the saw
        amount--;

        //Make the saw go faster
        rotationSpeed = hitRotationSpeed;

        //Create junk
        junkFactory.createSawHitJunk(other.getTransform());

        //Check if there is no amount left
        checkAmount();
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
        Transform.pushInBody(transform, this.body);
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public boolean doesDamage() {
        return true;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.PROJECTILES_BACKGROUND;
    }
}
