package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.ArrayList;

public class TeleporterPowerup extends Powerup {

    private PickupList pickupList;
    private Pickup pickup;

    public TeleporterPowerup(GameContext context, Pickup pickup, Transform initial) {
        super(context, initial);
        this.pickupList = context.getPickupList();
        this.pickup = pickup;
        start();
    }

    @Override
    protected void start() {

        //Create new position vector
        Vector2 currentPosition = player.getTransform().getPosition();
        Vector2 randomPosition = currentPosition;
        float distance = 0;

        //Check if there is another teleporter pickup available
        ArrayList<Pickup> nextTeleporter = pickupList.getPickupsByClassName("TeleporterPickup");
        if (nextTeleporter.size() > 1) {

            //Check if we are not grabbing ourself
            for (Pickup pickup : nextTeleporter) {
                if (pickup != this.pickup) {

                    //Use the pickup position as the target position
                    randomPosition  = pickup.getTransform().getPositionCenter();
                    distance        = currentPosition.dst(randomPosition);
                }
            }
        } else {

            //Check if the distance isn't too close to the player
            while (distance < C.pW() * 25) {

                //Grab a random position at the screen
                randomPosition = new Vector2(
                        MathUtils.random(C.pW() * 10, C.sW() - (C.pW() * 10)),
                        MathUtils.random(C.pH() * 10, C.sH() - (C.pH() * 10))
                );

                //Calculate distance
                distance = currentPosition.dst(randomPosition);
            }
        }

        //Create transforms from the aquired positions
        Transform current   = initial.clone();
        Transform chosen    = initial.clone();
        current.setPosition(currentPosition);
        chosen.setPosition(randomPosition);

        //Create junk at the current and chosen position
        junkFactory.createTeleporterJunk(current);
        junkFactory.createTeleporterJunk(chosen);

        //Create explosion at the chosen position
        projectileFactory.createTeleporterExplosion(chosen);

        //Create shock and manipulate its transform
        TeleporterShock shock = (TeleporterShock)projectileFactory.createTeleporterShock(current);
        Transform shockTransform = shock.getTransform();
        shockTransform.setRotation(C.getAngleInDegrees(currentPosition,randomPosition));
        shockTransform.setSize(new Vector2(distance, distance / 4));

        //Apply new position to the player
        player.getTransform().setPosition(randomPosition);

        //Make player immortal
        player.canReceiveDamage(false);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {

    }
}
