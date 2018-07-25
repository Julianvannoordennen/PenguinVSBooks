package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class GrenadePickup extends Pickup {

    public GrenadePickup(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createGrenadePowerup(transform);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        Transform.draw(batch, A.m.get(A.grenadePickup), transform);
        super.render(batch);
    }
}
