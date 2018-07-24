package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class Explosion implements Renderable, Projectile, Collidable {

    protected Color color;
    protected Transform transform;
    protected Body body;
    protected float decreaseSpeed;
    protected float rotationSpeed;
    protected ProjectileList projectileList;

    public Explosion(Transform transform, ProjectileList projectileList) {

        //Save variables
        this.projectileList = projectileList;
        this.transform = transform;
        this.decreaseSpeed = 25f;
        this.rotationSpeed = 100f;

        //Change explosion color
        color = new Color(1f,0.1f,0.1f,1);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Decrease size
        Vector2 newScale = new Vector2(transform.getXScale() - (decreaseSpeed * C.cGT()), transform.getYScale() - (decreaseSpeed * C.cGT()));
        transform.setScale(newScale);

        //Rotate
        transform.rotate(rotationSpeed * C.cGT());

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(this.color.r, this.color.g, this.color.b, this.color.a));

        //Draw explosion
        Transform.draw(batch, A.m.get(A.explosion), transform);

        //Restore color
        batch.setColor(color);

        //Check scale
        checkScale();
    }

    protected void checkScale() {

        //Destroy if too small
        if (transform.getXScale() <= 0.01f) {
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
}
