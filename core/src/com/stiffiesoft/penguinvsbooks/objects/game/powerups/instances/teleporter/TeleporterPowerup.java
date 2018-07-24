package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class TeleporterPowerup extends Powerup {

    public TeleporterPowerup(ProjectileFactory projectileFactory, PowerupList powerupList, Transform initial) {
        super(projectileFactory, powerupList, initial);
    }

    @Override
    protected void start() {

        //Create new position vector
        Vector2 currentPosition = Player.main.getTransform().getPosition();
        Vector2 randomPosition = currentPosition;
        float distance = currentPosition.dst(randomPosition);

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

        //Create explosion at the chosen position
        Transform transform = initial.clone();
        transform.setPosition(randomPosition);
        projectileFactory.createTeleporterExplosion(transform);

        //Create shock and manipulate its transform
        Transform current = initial.clone();
        current.setPosition(currentPosition);
        TeleporterShock shock = projectileFactory.createTeleporterShock(current);
        Transform shockTransform = shock.getTransform();
        shockTransform.setRotation(C.getAngleInDegrees(currentPosition,randomPosition));
        shockTransform.setSize(new Vector2(distance, distance / 4));

        //Apply new position to the player
        Player.main.getTransform().setPosition(randomPosition);

        //Make player immortal
        Player.main.canReceiveDamage(false);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {

    }
}
