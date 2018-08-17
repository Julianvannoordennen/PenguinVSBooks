package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.extralife;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.AnimatedPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class ExtraLifePickup extends AnimatedPickup {

    public ExtraLifePickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.extraLifePickup), 30);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createExtraLifePowerup(transform);
    }
}
