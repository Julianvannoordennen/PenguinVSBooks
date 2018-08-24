package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon.ShredderCannonPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bomb.BombPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bombbook.BombBookPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.boomerang.BoomerangPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.clover.CloverPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.cookie.CookiePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.dyslexia.DyslexiaPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.earthquake.EarthquakePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.extralife.ExtraLifePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower.FlameThrowerPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.grenade.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.hacker.HackerPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.helpingbook.HelpingBookPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.katana.KatanaPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.laser.LaserPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.magnet.MagnetPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.megalife.MegaLifePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.nuke.NukePowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret.PlasmaTurretPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.saw.SawPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter.TeleporterPowerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.wizard.WizardPowerup;
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
    public Powerup createFlameThrowerPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new FlameThrowerPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createSawPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new SawPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createWizardPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new WizardPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createCloverPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new CloverPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createBombBookPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new BombBookPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createHelpingBookPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new HelpingBookPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
    public Powerup createShredderCannonPowerup(Transform transform) {

        //Create powerup
        Powerup powerup = new ShredderCannonPowerup(context, transform.clone());

        //Add powerup to the list so the program can keep track of it
        powerupList.add(powerup);

        //Return powerup
        return powerup;
    }
}
