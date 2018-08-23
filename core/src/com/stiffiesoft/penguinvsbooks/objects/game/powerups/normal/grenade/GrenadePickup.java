package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.grenade;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class GrenadePickup extends FramePickup {

    public GrenadePickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = A.m.get(A.grenadePickup);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createGrenadePowerup(transform);
    }
}
