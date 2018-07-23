package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PowerupFactory {

    private PowerupList powerupList;
    private ProjectileFactory projectileFactory;

    public PowerupFactory(ProjectileFactory projectileFactory) {
        this.powerupList = new PowerupList();
        this.projectileFactory = projectileFactory;
    }

    public GrenadePowerup createGrenadePowerup(Transform transform) {

        //Create powerup
        GrenadePowerup powerup = new GrenadePowerup(projectileFactory, powerupList, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }

    public PowerupList getPowerupList() {
        return powerupList;
    }
}
