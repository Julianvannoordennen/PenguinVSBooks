package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class KatanaProjectile implements Projectile, Transformable, Collidable, GameObject {

    private Body body;
    private Transform transform;
    private ProjectileList projectileList;
    private ProjectileFactory projectileFactory;
    private JunkFactory junkFactory;
    private float rotationSpeed;
    private Player player;
    private long destroyTime;

    public KatanaProjectile(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.junkFactory        = context.getJunkFactory();
        this.player             = context.getPlayer();
        this.projectileFactory  = context.getProjectileFactory();
        this.rotationSpeed      = 1000;
        this.destroyTime        = TimeUtils.millis() + 7000; //Katana lasts 7 seconds
        this.transform.setCenter(new Vector2(0,0));
    }

    @Override
    public void update() {

        //Rotate katana
        transform.rotate(this.rotationSpeed * C.cGT());

        //Check if player still exists
        if (player != null)

            //Set position to player
            transform.setPosition(player.getTransform().getPositionCenter());

        //Update body
        Transform.pushInBody(transform, body);

        //Check if duration is done
        if (TimeUtils.millis() > destroyTime) {

            //Create throw projectile
            projectileFactory.createKatanaThrowProjectile(transform);

            //Destroy laser
            projectileList.destroy(this);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.katanaPickup), transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Create junk
        junkFactory.createKatanaJunk(other.getTransform());
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
        return true;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }
}
