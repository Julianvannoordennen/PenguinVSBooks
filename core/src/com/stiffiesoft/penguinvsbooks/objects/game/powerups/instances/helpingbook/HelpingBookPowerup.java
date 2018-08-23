package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.helpingbook;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower.FlameThrowerBase;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public class HelpingBookPowerup extends Powerup {

    public HelpingBookPowerup(GameContext context, Transform initial) {
        super(context, initial);
        start();
    }

    @Override
    protected void start() {

        //Create
        projectileFactory.createHelpingBookEnemy(initial);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {

    }
}
