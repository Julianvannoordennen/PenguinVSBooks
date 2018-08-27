package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class GatlingGunnerGuns implements Projectile, Transformable, GameObject {

    private boolean inPlace;
    private Transform transform;
    private Vector2 target;
    private float movementSpeed;
    private SpriteAnimation fireAnimationLeft;
    private SpriteAnimation fireAnimationRight;
    private long nextFire;
    private long fireRate;
    private boolean animate;
    private ProjectileFactory projectileFactory;
    private float accuracy;
    private int ammo;

    public GatlingGunnerGuns(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.inPlace            = false;
        this.target             = new Vector2(C.sW() / 2, 0);
        this.movementSpeed      = C.pH() * 50;
        this.fireAnimationLeft  = new SpriteAnimation(A.m.get(A.gatlingGunnerCannonFire), 60);
        this.fireAnimationRight = new SpriteAnimation(A.m.get(A.gatlingGunnerCannonFire), 60);
        this.fireRate           = 70;
        this.animate            = false;
        this.projectileFactory  = context.getProjectileFactory();
        this.accuracy           = C.pH() * 10;
        this.ammo               = 600;
        this.fireAnimationRight.reverse();
        updateFire();
    }

    public boolean isInPlace() {
        return inPlace;
    }

    public int getAmmo() {
        return this.ammo;
    }

    @Override
    public void update() {

        //Check if the part is not in place yet
        if (!inPlace) {

            //Move towards the center
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), target));
            transform.moveInDirection(this.movementSpeed * C.cGT());

            //Check if we are in the center
            if (transform.getPositionCenter().dst(target) < C.pH()) {

                //Apply default position
                transform.setPosition(target);
                transform.applyPosition(new Vector2(-transform.getXCenter(), -transform.getYCenter()));

                //Part in place
                inPlace = true;
            }
        }

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack())) {

            //Animate
            animate = true;
            fireAnimationLeft.update();
            fireAnimationRight.update();

            //Can we create a projectile?
            if (TimeUtils.millis() >= nextFire) {

                //Create projectile
                Transform transform = new Transform(M.x() + MathUtils.random(-accuracy,accuracy), M.iY() + MathUtils.random(-accuracy,accuracy), C.pH() * 5, C.pH() * 5, 1, 1, 0);
                projectileFactory.createGatlingGunnerProjectile(transform);

                //Now we have to wait before we can fire again
                ammo--;
                updateFire();
            }

        } else {

            //Do not animate
            this.animate = false;
            fireAnimationLeft.reset();
            fireAnimationRight.reset();
        }
    }

    private void updateFire() {
        this.nextFire = TimeUtils.millis() + this.fireRate;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw left gun
        float size = C.pH() * 50f;
        Transform gunLeft = transform.clone();
        gunLeft.setSize(new Vector2(size,size));
        gunLeft.setCenter(new Vector2(0,0));
        gunLeft.setPosition(new Vector2(0,transform.getYPosition()));

        if (animate)
            fireAnimationLeft.render(batch, gunLeft);
            else
        Transform.draw(batch, A.m.get(A.gatlingGunnerCannon), gunLeft);

        //Draw right gun
        Transform gunRight = gunLeft.clone();
        gunRight.setPosition(new Vector2(C.sW(),transform.getYPosition()));
        gunRight.setScale(new Vector2(-1,1));

        if (animate)
            fireAnimationRight.render(batch, gunRight);
        else
            Transform.draw(batch, A.m.get(A.gatlingGunnerCannon), gunRight);
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
        return DepthProfiles.PROJECTILES_FOREGROUND;
    }
}
