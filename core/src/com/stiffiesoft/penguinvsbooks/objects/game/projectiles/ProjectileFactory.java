package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerDamageExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectileBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombProjectileBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook.BombBookEnemy;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook.BombBookExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook.BombBookProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia.DyslexiaEnemyBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia.DyslexiaEnemy;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower.FlameThrowerBase;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower.FlameThrowerBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower.FlameThrowerProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadeExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker.HackerProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaThrowProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.magnet.MagnetShock;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret.*;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw.SawBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw.SawProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterShock;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.wizard.WizardEnemy;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.wizard.WizardProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class ProjectileFactory {

    private ProjectileList projectileList;
    private BodyFactory bodyFactory;
    private GameContext context;

    public ProjectileFactory(GameContext context) {
        this.projectileList = context.getProjectileList();
        this.bodyFactory    = context.getBodyFactory();
        this.context        = context;
    }

    /***** Create methods *****/
    public Projectile createPlayerDamageExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(20f, 20f));

        //Create projectile and apply the transform send in parameter
        Projectile explosion = new PlayerDamageExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
    public Projectile createGrenadeExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create projectile and apply the transform send in parameter
        Projectile explosion = new GrenadeExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
    public Projectile createPlayerProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(0.5f, 0.5f));

        //Create projectile and apply the transform send in parameter
        Projectile projectile = new PlayerProjectile(transform, context);

        //Add projectile to the list so the program can keep track of it
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PlayerProjectileBodyTask((Collidable)projectile));

        //Return to projectile
        return projectile;
    }
    public Projectile createCookieProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        Projectile cookieProjectile = new CookieProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(cookieProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new CookieBodyTask((Collidable)cookieProjectile));

        //Return explosion
        return cookieProjectile;
    }
    public Projectile createLaserProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        Projectile laserProjectile = new LaserProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(laserProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new LaserBodyTask((Collidable)laserProjectile));

        //Return explosion
        return laserProjectile;
    }
    public Projectile createTeleporterExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(8f, 8f));

        //Create projectile and apply the transform send in parameter
        Projectile explosion = new TeleporterExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
    public Projectile createTeleporterShock(Transform transform) {

        //Create projectile and apply the transform send in parameter
        transform = transform.clone();
        Projectile shock = new TeleporterShock(transform,context);

        //Add projectile to projectilelist
        projectileList.add(shock);

        //Return explosion
        return shock;
    }
    public Projectile createMagnetShock(Pickup pickup) {

        //Create projectile and apply the transform send in parameter
        Projectile shock = new MagnetShock(pickup,context);

        //Add projectile to projectilelist
        projectileList.add(shock);

        //Return explosion
        return shock;
    }
    public Projectile createBombProjectile(Transform transform) {

        //Create projectile and apply the transform send in parameter
        transform = transform.clone();
        Projectile projectile = new BombProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new BombProjectileBodyTask((Collidable)projectile));

        //Return projectile
        return projectile;
    }
    public Projectile createBombExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create explosion and apply the transform send in parameter
        Projectile explosion = new BombExplosion(transform,context);

        //Add explosion to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
    public Projectile createKatanaProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create explosion and apply the transform send in parameter
        Projectile projectile = new KatanaProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new KatanaBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createKatanaThrowProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create explosion and apply the transform send in parameter
        Projectile projectile = new KatanaThrowProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new KatanaBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createBoomerangProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new BoomerangProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new BoomerangBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createPlasmaTurretMount(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new PlasmaTurretMount(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createPlasmaTurretLaser(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new PlasmaTurretLaser(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createPlasmaTurretProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new PlasmaTurretProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PlasmaTurretBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createPlasmaTurretCrash(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new PlasmaTurretCrash(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createPlasmaTurretExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(6f, 6f));

        //Create and apply the transform send in parameter
        Projectile explosion = new PlasmaTurretExplosion(transform,context);

        //Add explosion to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
    public Projectile createHackerProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new HackerProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createDyslexiaEnemy(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new DyslexiaEnemy(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DyslexiaEnemyBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createFlameThrowerBase(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new FlameThrowerBase(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createFlameThrowerProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new FlameThrowerProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new FlameThrowerBodyTask((Collidable)projectile, 0));

        //Return explosion
        return projectile;
    }
    public Projectile createSawProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setScale(new Vector2(2,2));

        //Create and apply the transform send in parameter
        Projectile projectile = new SawProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new SawBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createWizardEnemy(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new WizardEnemy(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createWizardProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setScale(new Vector2(0.5f, 0.5f));

        //Create and apply the transform send in parameter
        Projectile projectile = new WizardProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PlasmaTurretBodyTask((Collidable)projectile));

        //Return explosion
        return projectile;
    }
    public Projectile createBombBookEnemy(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new BombBookEnemy(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createBombBookProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        Projectile projectile = new BombBookProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Return explosion
        return projectile;
    }
    public Projectile createBombBookExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create and apply the transform send in parameter
        Projectile explosion = new BombBookExplosion(transform,context);

        //Add explosion to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask((Collidable)explosion));

        //Return explosion
        return explosion;
    }
}
