package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia.DyslexiaPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.earthquake.EarthquakePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.extralife.ExtraLifePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker.HackerPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.magnet.MagnetPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.megalife.MegaLifePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.nuke.NukePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret.PlasmaTurretPowerup;
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
    public Powerup createGrenadePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new GrenadePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createCookiePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new CookiePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createLaserPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new LaserPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createTeleporterPowerup(Transform transform, Pickup creator) {

        //Create powerup
        Powerup powerup = new TeleporterPowerup(context, creator, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createMagnetPowerup(Transform transform, Pickup creator) {

        //Create powerup
        Powerup powerup = new MagnetPowerup(context, creator, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createBombPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new BombPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createKatanaPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new KatanaPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createExtraLifePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new ExtraLifePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createMegaLifePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new MegaLifePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createEarthquakePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new EarthquakePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createNukePowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new NukePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createBoomerangPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new BoomerangPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createPlasmaTurretPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new PlasmaTurretPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createHackerPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new HackerPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createDyslexiaPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new DyslexiaPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
}
