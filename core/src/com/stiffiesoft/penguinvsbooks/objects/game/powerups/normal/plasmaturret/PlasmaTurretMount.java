package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class PlasmaTurretMount implements Projectile, Transformable, GameObject {

    private SpriteAnimation animation;
    private Transform transform;
    private ProjectileList projectileList;
    private ProjectileFactory projectileFactory;
    private int ammo;
    private long fireRate;
    private long nextFire;
    private float accuracy;
    private boolean dead;

    public PlasmaTurretMount(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.projectileFactory  = context.getProjectileFactory();
        this.ammo               = 200;
        this.fireRate           = 100; //10 shots a second
        this.nextFire           = TimeUtils.millis() + fireRate;
        this.accuracy           = 10; //closer to 0 is more accurate
        this.animation          = new SpriteAnimation(A.m.get(A.plasmaTurretPowerupFire), 30);
        this.dead               = false;
    }

    public void updateAttack() {

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack()) && TimeUtils.millis() >= nextFire) {

            //Decrease amount of ammo available
            ammo--;

            //Clone the transform of the player
            Transform projectileTransform = transform.clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation() + MathUtils.random(-accuracy, accuracy)));

            //Create projectile using the projectilefactory
            projectileFactory.createPlasmaTurretProjectile(projectileTransform);

            //Check if there is any ammo left
            if (ammo > 0)

                //Now we have to wait before we can fire again
                this.nextFire = TimeUtils.millis() + fireRate;

            else {

                //Destroy mount
                dead = true;
                projectileFactory.createPlasmaTurretCrash(transform);
                projectileList.destroy(this);
            }
        }
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void update() {

        //Update animation
        animation.update();

        //Look at cursor
        transform.setRotation(
                C.getAngleInDegrees(
                        transform.getPositionCenter(),
                        M.p()
                )
        );

        //Update attack
        updateAttack();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Check if firing
        if (Gdx.input.isButtonPressed(K.attack()))

            //Draw animation
            animation.render(batch, transform);

        else

            //Draw projectile sprite
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
        return DepthProfiles.PROJECTILES_BACKGROUND;
    }
}
