package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class PlayerStateMoving implements PlayerState, GameObject {

    private Player player;
    private ScreenFlasher screenFlasher;
    private ProjectileFactory projectileFactory;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;
    private long fireRate;
    private long nextFire;
    private long flickerRate;
    private long nextFlicker;
    private Boolean flickerOn;
    private long flickerLast;
    private long flickerLength;

    public PlayerStateMoving(Player player, GameContext context) {

        //We can see the player as the context for this state
        this.player             = player;
        this.screenFlasher      = context.getScreenFlasher();
        this.projectileFactory  = context.getProjectileFactory();

        //Apply speed to the player
        defaultMovementSpeed    = C.pH() * 20;
        currentMovementSpeed    = defaultMovementSpeed;

        //Create fire rate, now the player cannot fire books every tick
        fireRate                = 125;
        flickerRate             = 100;
        flickerOn               = true;
        flickerLength           = 3000;
        updateFire();
        updateFlicker();
        updateFlickerDuration();
    }

    private void updateFire() {
        nextFire = TimeUtils.millis() + fireRate;
    }

    private void updateFlicker() {
        flickerOn = !flickerOn;
        nextFlicker = TimeUtils.millis() + flickerRate;
    }

    private void updateFlickerDuration() {
        flickerLast = TimeUtils.millis() + flickerLength;
    }

    public void updateMovement() {

        //Which key is holded down
        if (Gdx.input.isKeyPressed(K.up())) { //W

            //Move up
            player.getTransform().applyPosition(new Vector2(0, currentMovementSpeed * C.cGT()));

        } else if (Gdx.input.isKeyPressed(K.down())) { //S

            //Move down
            player.getTransform().applyPosition(new Vector2(0, -currentMovementSpeed * C.cGT()));
        }

        if (Gdx.input.isKeyPressed(K.left())) { //A

            //Move left
            player.getTransform().applyPosition(new Vector2(-currentMovementSpeed * C.cGT(), 0));

        } else if (Gdx.input.isKeyPressed(K.right())) { //D

            //Move right
            player.getTransform().applyPosition(new Vector2(currentMovementSpeed * C.cGT(), 0));
        }
    }

    public void updateAttack() {

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack()) && TimeUtils.millis() >= nextFire) {

            //Now we have to wait before we can fire again
            updateFire();

            //Clone the transform of the player
            Transform projectileTransform = player.getTransform().clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation()));

            //Create projectile using the projectilefactory
            projectileFactory.createPlayerProjectile(projectileTransform);
        }
    }

    @Override
    public void update() {

        //Update interaction methods
        if (!player.freeze()) {
            updateMovement();
            updateAttack();
        }

        if (!player.canReceiveDamage() && flickerLast == -1) updateFlickerDuration();

        //Look at cursor
        player.getTransform().setRotation(
                C.getAngleInDegrees(
                        player.getTransform().getPositionCenter(),
                        M.p()
                )
        );

        //Check if we need to flicker
        if (!player.canReceiveDamage()) {
            if (TimeUtils.millis() >= nextFlicker)
                updateFlicker();
            if (TimeUtils.millis() >= flickerLast) {
                player.canReceiveDamage(true);
                flickerLast = -1;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Check if the player can receive damage
        if (player.canReceiveDamage()) {

            //Just draw the player
            Transform.draw(batch, A.m.get(A.playerIdle), player.getTransform());

        } else {

            //Flicker sprite if he can't be damaged
            Color color = batch.getColor();

            //Change color
            batch.setColor(new Color(color.r, color.g, color.b, flickerOn ? 0.2f : 0.4f));

            //Draw player sprite
            Transform.draw(batch, A.m.get(A.playerIdle), player.getTransform());

            //Restore color
            batch.setColor(color);
        }
    }

    @Override
    public void onCollision(Collidable other) {

        //Check if player is immortal
        if (!player.canReceiveDamage()) return;

        //Tell counter that there is some damage
        player.getPlayerListeners().forEach(playerListener -> playerListener.onPlayerDamage(player));

        //Make player temporary immortal
        player.canReceiveDamage(false);

        //Create screen flash
        screenFlasher.flash(DefinedColors.DAMAGE_FLASH);

        //Clone the transform of the player
        Transform explosionTransform = player.getTransform().clone();

        //Create a damage explosion
        projectileFactory.createPlayerDamageExplosion(explosionTransform);
    }

    @Override
    public int getDepth() {
        return DepthProfiles.PLAYER;
    }
}
