package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerDamageExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectileBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadeExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterShock;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class ProjectileFactory {

    private ProjectileList projectileList;
    private BodyFactory bodyFactory;
    private ScreenFlasher screenFlasher;

    public ProjectileFactory(BodyFactory bodyFactory, ScreenFlasher screenFlasher) {
        this.projectileList = new ProjectileList();
        this.bodyFactory = bodyFactory;
        this.screenFlasher = screenFlasher;
    }

    public ProjectileList getProjectileList() {
        return projectileList;
    }

    /***** Create methods *****/
    public PlayerDamageExplosion createPlayerDamageExplosion(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(20f, 20f));

        //Create projectile and apply the transform send in parameter
        PlayerDamageExplosion explosion = new PlayerDamageExplosion(transform,projectileList);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public GrenadeExplosion createGrenadeExplosion(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create projectile and apply the transform send in parameter
        GrenadeExplosion explosion = new GrenadeExplosion(transform,projectileList);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public PlayerProjectile createPlayerProjectile(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(0.5f, 0.5f));

        //Create projectile and apply the transform send in parameter
        PlayerProjectile projectile = new PlayerProjectile(transform, projectileList);

        //Add projectile to the list so the program can keep track of it
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PlayerProjectileBodyTask(projectile));

        //Return to projectile
        return projectile;
    }
    public CookieProjectile createCookieProjectile(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        CookieProjectile cookieProjectile = new CookieProjectile(transform,projectileList);

        //Add projectile to projectilelist
        projectileList.add(cookieProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new CookieBodyTask(cookieProjectile));

        //Return explosion
        return cookieProjectile;
    }
    public LaserProjectile createLaserProjectile(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        LaserProjectile laserProjectile = new LaserProjectile(transform,projectileList, screenFlasher);

        //Add projectile to projectilelist
        projectileList.add(laserProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new LaserBodyTask(laserProjectile));

        //Return explosion
        return laserProjectile;
    }
    public TeleporterExplosion createTeleporterExplosion(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(8f, 8f));

        //Create projectile and apply the transform send in parameter
        TeleporterExplosion explosion = new TeleporterExplosion(transform,projectileList);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public TeleporterShock createTeleporterShock(Transform transform) {

        //Create projectile and apply the transform send in parameter
        TeleporterShock shock = new TeleporterShock(transform,projectileList);

        //Add projectile to projectilelist
        projectileList.add(shock);

        //Return explosion
        return shock;
    }
}
