package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PowerupFactory {

    private PowerupList powerupList;
    private ProjectileFactory projectileFactory;
    private GameContext context;

    public PowerupFactory(GameContext context) {
        this.powerupList        = context.getPowerupList();
        this.projectileFactory  = context.getProjectileFactory();
        this.context            = context;
    }

    /***** Create methods *****/
    public GrenadePowerup createGrenadePowerup(Transform transform) {

        //Create powerup
        GrenadePowerup powerup = new GrenadePowerup(context, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public CookiePowerup createCookiePowerup(Transform transform) {

        //Create powerup
        CookiePowerup powerup = new CookiePowerup(context, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public LaserPowerup createLaserPowerup(Transform transform) {

        //Create powerup
        LaserPowerup powerup = new LaserPowerup(context, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public TeleporterPowerup createTeleporterPowerup(Transform transform) {

        //Create powerup
        TeleporterPowerup powerup = new TeleporterPowerup(context, transform);

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
}
