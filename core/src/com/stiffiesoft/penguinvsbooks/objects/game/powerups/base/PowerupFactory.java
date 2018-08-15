package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.earthquake.EarthquakePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.extralife.ExtraLifePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePowerup;
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
    public GrenadePowerup createGrenadePowerup(Transform transform) {

        //Create powerup
        GrenadePowerup powerup = new GrenadePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public CookiePowerup createCookiePowerup(Transform transform) {

        //Create powerup
        CookiePowerup powerup = new CookiePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public LaserPowerup createLaserPowerup(Transform transform) {

        //Create powerup
        LaserPowerup powerup = new LaserPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public TeleporterPowerup createTeleporterPowerup(Transform transform, Pickup creator) {

        //Create powerup
        TeleporterPowerup powerup = new TeleporterPowerup(context, creator, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public MagnetPowerup createMagnetPowerup(Transform transform, Pickup creator) {

        //Create powerup
        MagnetPowerup powerup = new MagnetPowerup(context, creator, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public BombPowerup createBombPowerup(Transform transform) {

        //Create powerup
        BombPowerup powerup = new BombPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public KatanaPowerup createKatanaPowerup(Transform transform) {

        //Create powerup
        KatanaPowerup powerup = new KatanaPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public ExtraLifePowerup createExtraLifePowerup(Transform transform) {

        //Create powerup
        ExtraLifePowerup powerup = new ExtraLifePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public MegaLifePowerup createMegaLifePowerup(Transform transform) {

        //Create powerup
        MegaLifePowerup powerup = new MegaLifePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public EarthquakePowerup createEarthquakePowerup(Transform transform) {

        //Create powerup
        EarthquakePowerup powerup = new EarthquakePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public NukePowerup createNukePowerup(Transform transform) {

        //Create powerup
        NukePowerup powerup = new NukePowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public BoomerangPowerup createBoomerangPowerup(Transform transform) {

        //Create powerup
        BoomerangPowerup powerup = new BoomerangPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public PlasmaTurretPowerup createPlasmaTurretPowerup(Transform transform) {

        //Create powerup
        PlasmaTurretPowerup powerup = new PlasmaTurretPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
}
