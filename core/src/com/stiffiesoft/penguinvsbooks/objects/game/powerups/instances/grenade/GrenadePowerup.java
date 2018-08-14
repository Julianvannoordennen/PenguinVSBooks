package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class GrenadePowerup extends Powerup {

    public GrenadePowerup(GameContext context, Transform initial) {
        super(context, initial);
        start();
    }

    @Override
    protected void start() {

        //Create grenade explosion
        projectileFactory.createGrenadeExplosion(initial);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {

    }
}
