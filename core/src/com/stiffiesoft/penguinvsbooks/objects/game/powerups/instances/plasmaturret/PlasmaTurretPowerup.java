package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret;

import com.badlogic.gdx.graphics.Color;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.text.DefinedColors;

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
