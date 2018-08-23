package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public class FlameThrowerPowerup extends Powerup {

    private ProjectileList projectileList;

    public FlameThrowerPowerup(GameContext context, Transform initial) {
        super(context, initial);
        this.projectileList = context.getProjectileList();
        start();
    }

    @Override
    protected void start() {

        //Check if the flamethrower already exists
        ArrayList<Projectile> list = projectileList.getByClassName(FlameThrowerBase.class.getSimpleName());

        if (list.size() > 0) {

            //Get the projectile from the list
            FlameThrowerBase projectile = (FlameThrowerBase)list.get(0);

            //Increase its duration
            projectile.increaseDuration();

        } else

            //Create flamethrower projectile
            projectileFactory.createFlameThrowerBase(initial);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
