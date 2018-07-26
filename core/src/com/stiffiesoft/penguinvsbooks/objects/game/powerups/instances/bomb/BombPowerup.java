package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class BombPowerup extends Powerup {

    public BombPowerup(GameContext context, Transform initial) {
        super(context, initial);
        start();
    }

    @Override
    protected void start() {

        //Create rolling bomb
        projectileFactory.createBombProjectile(initial);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {

    }
}
