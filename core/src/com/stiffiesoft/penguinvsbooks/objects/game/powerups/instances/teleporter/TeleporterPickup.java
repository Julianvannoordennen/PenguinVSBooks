package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class TeleporterPickup extends Pickup {

    private SpriteAnimation animation;

    public TeleporterPickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.teleporterPickup), 30);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createTeleporterPowerup(transform);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Render animation
        animation.render(batch, transform);
        super.render(batch);
    }
}
