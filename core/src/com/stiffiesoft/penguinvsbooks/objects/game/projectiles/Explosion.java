package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class Explosion implements GameObject, Projectile, Collidable {

    protected Color color;
    protected Transform transform;
    protected Body body;
    protected float decreaseSpeed;
    protected float rotationSpeed;
    protected ProjectileList projectileList;
    protected JunkFactory junkFactory;

    public Explosion(Transform transform, GameContext context) {

        //Save variables
        this.projectileList = context.getProjectileList();
        this.transform      = transform;
        this.decreaseSpeed  = 25f;
        this.rotationSpeed  = 100f;
        this.junkFactory    = context.getJunkFactory();

        //Change explosion color
        color = new Color(1f,0.1f,0.1f,1);
        start();
    }

    public void start() {

        //Create dust
        junkFactory.createDefaultExplosionDust(transform);
    }

    @Override
    public void update() {

        //Decrease size
        Vector2 newScale = new Vector2(transform.getXScale() - (decreaseSpeed * C.cGT()), transform.getYScale() - (decreaseSpeed * C.cGT()));
        transform.setScale(newScale);

        //Rotate
        transform.rotate(rotationSpeed * C.cGT());

        //Check scale
        checkScale();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(this.color.r, this.color.g, this.color.b, this.color.a));

        //Draw explosion
        Transform.draw(batch, A.m.get(A.explosion), transform);

        //Restore color
        batch.setColor(color);
    }

    protected void checkScale() {

        //Destroy if too normal
        if (transform.getXScale() <= 0.01f) {

            //Remove from the projectile list
            projectileList.destroy(this);
        }
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
    public void onCollisionEnter(Collidable other, short collisionType) {

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
        return DepthProfiles.PROJECTILES_FOREGROUND;
    }
}
