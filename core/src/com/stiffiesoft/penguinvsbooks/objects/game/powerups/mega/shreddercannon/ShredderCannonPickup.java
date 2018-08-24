package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.AnimatedPickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class ShredderCannonPickup extends AnimatedPickup {

    private ShredderCannonCounter shredderCannonCounter;

    public ShredderCannonPickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.shredderCannonPickup), 15);
        shredderCannonCounter = context.getShredderCannonCounter();
    }

    @Override
    public void onPickup() {

        //Check if the mega powerup can start
        shredderCannonCounter.apply(1);
        if (shredderCannonCounter.get() == 10) {

            //Create the powerup using the powerup factory
            powerupFactory.createShredderCannonPowerup(transform);

            //Reset counter to 0
            shredderCannonCounter.set(0);
        }
    }
}
