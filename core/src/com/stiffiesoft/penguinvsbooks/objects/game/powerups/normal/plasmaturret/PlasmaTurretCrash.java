package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class PlasmaTurretCrash implements Projectile, Transformable, GameObject {

    private Transform transform;
    private float rotationAmount;
    private ProjectileList projectileList;
    private ProjectileFactory projectileFactory;
    private JunkFactory junkFactory;
    private long fireRate;
    private long nextFire;

    public PlasmaTurretCrash(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.rotationAmount     = 1f;
        this.projectileList     = context.getProjectileList();
        this.projectileFactory  = context.getProjectileFactory();
        this.junkFactory        = context.getJunkFactory();
        this.fireRate           = 200; //5 shots a second
        this.nextFire           = TimeUtils.millis() + fireRate;
    }

    @Override
    public void update() {

        //Check if it is time to fire
        if (TimeUtils.millis() > this.nextFire) {

            //Now we have to wait before we can fire again
            this.nextFire = TimeUtils.millis() + fireRate;

            //Clone the transform of the player
            Transform projectileTransform = transform.clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation()));

            //Create projectile using the projectilefactory
            projectileFactory.createPlasmaTurretProjectile(projectileTransform);
        }

        //Rotate
        this.rotationAmount += this.rotationAmount * C.cGT();
        transform.rotate(this.rotationAmount);

        //Destroy when going to fast
        if (this.rotationAmount > 250) {

            //Create explosion
            projectileFactory.createPlasmaTurretExplosion(transform.clone());

            //Create junk
            junkFactory.createPlasmaTurretJunk(transform.clone());

            //Destroy
            projectileList.destroy(this);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw turret sprite
        Transform.draw(batch, A.m.get(A.plasmaTurretPowerup), transform);
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
        return DepthProfiles.JUNK_BACKGROUND;
    }
}
