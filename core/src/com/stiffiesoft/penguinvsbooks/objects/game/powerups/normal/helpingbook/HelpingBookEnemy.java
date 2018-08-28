package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.helpingbook;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class HelpingBookEnemy extends LinearProjectile {

    private SpriteAnimation animation;
    private float normalSpeed;
    private float returnSpeed;
    private int powerupAmount;
    private Vector2 targetPosition;
    private boolean droppedPowerup;
    private int edgeCorrection;
    private Player player;
    private Pickup pickup;
    private PickupFactory pickupFactory;
    private PickupList pickupList;

    public HelpingBookEnemy(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        animation           = new SpriteAnimation(A.m.get(A.helpingBookEnemy),20);
        player              = context.getPlayer();
        returnSpeed         = C.pH() * 20;
        normalSpeed         = C.pH() * 5;
        speed               = normalSpeed;
        powerupAmount       = MathUtils.random(2,4);
        targetPosition      = Vector2.Zero;
        droppedPowerup      = false;
        edgeCorrection      = Math.round(C.pW()) * 10;
        pickupFactory       = context.getPickupFactory();
        pickupList          = context.getPickupList();
        transform.setPosition(C.pOS(edgeCorrection));
        generateTargetPosition();
        generatePickup();
    }

    private void generatePickup() {

        //Create a pickup in the pickup factory
        pickupFactory.forceSpawn(new Vector2(C.sW() / 2, C.sH() / 2));

        //Retrieve the last pickup
        pickup = pickupList.get().get(pickupList.get().size() - 1);
    }

    private void generateTargetPosition() {

        //Assign new position
        targetPosition = new Vector2(player.getTransform().getPositionCenter());
    }

    private void generateReturnPosition() {

        //Get position around the edge of the screen
        Vector2 position = C.pOS(edgeCorrection);

        //Assign new position
        targetPosition = new Vector2(position);
    }

    @Override
    public void update() {

        //Move towards the enemy
        transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), targetPosition));

        //Check if not carrying powerup
        if (droppedPowerup) {

            //Check if target reached
            if (targetPosition.dst(transform.getPositionCenter()) < C.pH() * 2) {

                //Check if there is any powerup amount left
                if (powerupAmount <= 0) {

                    //Time to die
                    projectileList.destroy(this);

                } else {

                    //Restore speed
                    droppedPowerup = false;
                    speed = normalSpeed;
                    generatePickup();
                }
            }
        } else {

            //Still carrying powerup? Lets see where the player is
            generateTargetPosition();

            //Check if we still have the pickup
            if (pickupList.get().contains(pickup)) {

                //Update pickup position
                Vector2 position = new Vector2(transform.getPosition());
                position.add(new Vector2(0,C.pH() * -2.5f));
                pickup.getTransform().setPosition(position);

            } else {

                //Player grabbed the pickup
                powerupAmount--;
                droppedPowerup = true;
                speed = returnSpeed;

                //Fly back
                generateReturnPosition();
            }
        }

        //Update the animation
        animation.update();

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the animation
        animation.render(batch, transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.ENEMIES;
    }
}
