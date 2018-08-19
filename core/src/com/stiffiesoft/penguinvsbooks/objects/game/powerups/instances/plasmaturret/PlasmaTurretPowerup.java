package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PlasmaTurretPowerup extends Powerup {

    public PlasmaTurretPowerup(GameContext context, Transform initial) {
        super(context, initial);
        start();
    }

    @Override
    protected void start() {

        //Create plasma turret
        PlasmaTurretLaser laser = (PlasmaTurretLaser)projectileFactory.createPlasmaTurretLaser(initial);
        PlasmaTurretMount mount = (PlasmaTurretMount)projectileFactory.createPlasmaTurretMount(initial);
        laser.setMount(mount);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
