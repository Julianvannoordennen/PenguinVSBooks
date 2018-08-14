package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class LaserPickup extends Pickup {

    public LaserPickup(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createLaserPowerup(transform);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        Transform.draw(batch, A.m.get(A.laserPickup), transform);
    }
}
