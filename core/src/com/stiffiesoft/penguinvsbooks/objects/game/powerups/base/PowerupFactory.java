package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PowerupFactory {

    private PowerupList powerupList;
    private ProjectileFactory projectileFactory;

    public PowerupFactory(ProjectileFactory projectileFactory) {
        this.powerupList = new PowerupList();
        this.projectileFactory = projectileFactory;
    }

    public PowerupList getPowerupList() {
        return powerupList;
    }

    /***** Create methods *****/
    public GrenadePowerup createGrenadePowerup(Transform transform) {

        //Create powerup
        GrenadePowerup powerup = new GrenadePowerup(projectileFactory, powerupList, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public CookiePowerup createCookiePowerup(Transform transform) {

        //Create powerup
        CookiePowerup powerup = new CookiePowerup(projectileFactory, powerupList, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
}
