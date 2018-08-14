package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class CookieProjectile implements Projectile, Transformable, Collidable, GameObject {

    private Body body;
    private Transform transform;
    private ProjectileList projectileList;
    private JunkFactory junkFactory;
    private int amount;

    public CookieProjectile(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.junkFactory        = context.getJunkFactory();

        //How many bookbites does the cookie contain?
        amount                  = 5000;

        //Add cookie to the targetting list
        EnemyTargetSystem.registerTarget(this);
    }

    @Override
    public void update() {

        //Switch colliding state, now the enemies will see it as a new contact every time
        body.setActive(!body.isActive());

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.cookiePickup), transform);
    }

    private void checkAmount() {

        //Check if amount is below zero
        if (amount < 0) {

            //Delete cookie from the targetting list
            EnemyTargetSystem.removeTarget(this);

            //Destroy the cookie
            projectileList.destroy(this);
        }
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Decrease the amount of the cookie
        amount--;

        //Create junk
        junkFactory.createCookieJunk(transform);

        //Check if there is no cookie left
        checkAmount();
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public boolean doesDamage() {
        return false;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }
}
