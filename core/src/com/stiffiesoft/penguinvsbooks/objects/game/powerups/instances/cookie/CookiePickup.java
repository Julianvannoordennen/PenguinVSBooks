package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class CookiePickup extends Pickup {

    public CookiePickup(Transform transform, PowerupFactory powerupFactory, PickupList pickupList, ScreenFlasher screenFlasher) {
        super(transform, powerupFactory, pickupList, screenFlasher);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createCookiePowerup(transform);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        Transform.draw(batch, A.m.get(A.cookiePickup), transform);
        super.render(batch);
    }
}
