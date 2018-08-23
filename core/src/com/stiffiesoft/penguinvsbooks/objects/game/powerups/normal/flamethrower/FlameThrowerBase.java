package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class FlameThrowerBase implements Projectile, Transformable, GameObject {

    private Transform transform;
    private ProjectileList projectileList;
    private ProjectileFactory projectileFactory;
    private Player player;
    private long duration;
    private long killTime;
    private long fireRate;
    private long nextFire;

    public FlameThrowerBase(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.player             = context.getPlayer();
        this.projectileList     = context.getProjectileList();
        this.projectileFactory  = context.getProjectileFactory();
        this.duration           = 5000;     //5 seconds
        this.killTime           = TimeUtils.millis() + this.duration;
        this.fireRate           = 50;       //20 shots a second
        this.nextFire           = TimeUtils.millis() + fireRate;
    }

    private void updateAttack() {

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack()) && TimeUtils.millis() >= nextFire) {

            //Clone the transform of the player
            Transform projectileTransform = transform.clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation()));

            //Create projectile using the projectilefactory
            projectileFactory.createFlameThrowerProjectile(projectileTransform);

            //Now we have to wait before we can fire again
            this.nextFire = TimeUtils.millis() + fireRate;
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

        //Check if time is over
        if (TimeUtils.millis() > this.killTime)

            //Destroy the projectile
            projectileList.destroy(this);

        //Check if player still exists
        if (player != null)

            //Set position to player
            transform.setPosition(player.getTransform().getPosition());

        //Update attack
        updateAttack();
    }

    public void increaseDuration() {
        this.killTime += this.duration;
    }

    @Override
    public void render(SpriteBatch batch) {
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
        return DepthProfiles.INVISIBLE;
    }
}
