package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class BombBookProjectile implements Projectile, Transformable, GameObject {

    private Transform transform;
    private ProjectileList projectileList;
    private JunkFactory junkFactory;
    private ProjectileFactory projectileFactory;
    private int beepAmount;
    private long nextBeep;
    private long beepLength;

    public BombBookProjectile(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.junkFactory        = context.getJunkFactory();
        this.projectileFactory  = context.getProjectileFactory();

        //How many beeps before exploding?
        this.beepAmount         = 4;
        this.beepLength         = 1000; //1 second
        this.nextBeep           = TimeUtils.millis() + beepLength;
    }

    @Override
    public void update() {

        //Check if it's time for a new beep
        if (TimeUtils.millis() > this.nextBeep) {

            //Check if we can beep again
            if (beepAmount <= 0) {

                //Create explosion
                projectileFactory.createBombBookExplosion(transform.clone());

                //Destroy itself
                projectileList.destroy(this);

            } else {

                //Create junk
                junkFactory.createBombBookProjectileJunk(transform.clone());
                this.nextBeep = TimeUtils.millis() + beepLength;
                this.beepAmount--;
            }
        }

    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.bombBookProjectile), transform);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return null;
    }

    @Override
    public boolean doesDamage() {
        return false;
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
