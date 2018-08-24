package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.effects.ScreenShaker;
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
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class ShredderCannonBase implements Projectile, Transformable, GameObject {

    private Transform transform;
    private ProjectileList projectileList;
    private ProjectileFactory projectileFactory;
    private int ammo;
    private long fireRate;
    private long nextFire;
    private ScreenFlasher screenFlasher;
    private ScreenShaker screenShaker;
    private long shakeIntensity;

    public ShredderCannonBase(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.projectileFactory  = context.getProjectileFactory();
        this.ammo               = 30;
        this.fireRate           = 1000; //1 shot a second
        this.nextFire           = TimeUtils.millis() + fireRate;
        this.screenFlasher      = context.getScreenFlasher();
        this.screenShaker       = context.getScreenShaker();
        this.shakeIntensity     = 250;
    }

    public void updateAttack() {

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack()) && TimeUtils.millis() >= nextFire) {

            //Decrease amount of ammo available
            ammo--;

            //Clone the transform
            Transform projectileTransform = transform.clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation()));
            projectileTransform.setPosition(new Vector2(C.sW() / 2, C.sH() / 2));

            //Create projectile using the projectilefactory
            projectileFactory.createShredderCannonProjectile(projectileTransform);

            //Check if there is any ammo left
            if (ammo > 0) {

                //Flash and shake screen
                Color color = new Color(DefinedColors.MEGA_POWERUP_FLASH);
                color.a = 0.75f;
                screenFlasher.flash(color);
                screenShaker.shake(shakeIntensity);

                //Now we have to wait before we can fire again
                this.nextFire = TimeUtils.millis() + fireRate;

            } else {

                //Flash and shake screen
                screenFlasher.flash(DefinedColors.MEGA_POWERUP_FLASH);
                screenShaker.shake(shakeIntensity * 2);

                //Destroy mount
                projectileFactory.createShredderCannonExplosion(transform);
                projectileList.destroy(this);
            }
        }
    }

    @Override
    public void update() {

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

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.shredderCannonBase), transform);
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
        return DepthProfiles.PROJECTILES_BACKGROUND + 10;
    }
}
