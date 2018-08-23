package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.earthquake;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class EarthquakePickup extends FramePickup {

    public EarthquakePickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = A.m.get(A.earthquakePickup);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createEarthquakePowerup(transform);
    }
}
