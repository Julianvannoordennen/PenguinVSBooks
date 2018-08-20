package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class SawPickup extends FramePickup {

    public SawPickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = A.m.get(A.sawPickup);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createSawPowerup(transform);
    }
}
