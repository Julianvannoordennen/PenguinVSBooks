package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.AnimatedPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon.ShredderCannonCounter;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class GatlingGunnerPickup extends FramePickup {

    private GatlingGunnerCounter gatlingGunnerCounter;

    public GatlingGunnerPickup(Transform transform, GameContext context) {
        super(transform, context);
        texture                 = A.m.get(A.gatlingGunnerPickup);
        gatlingGunnerCounter    = context.getGatlingGunnerCounter();
    }

    @Override
    public void onPickup() {

        //Check if the mega powerup can start
        gatlingGunnerCounter.apply(50);
        if (gatlingGunnerCounter.get() >= 600) {

            //Create the powerup using the powerup factory
            powerupFactory.createGatlingGunnerPowerup(transform);

            //Reset counter to 0
            gatlingGunnerCounter.set(gatlingGunnerCounter.get() - 600);
        }
    }
}
