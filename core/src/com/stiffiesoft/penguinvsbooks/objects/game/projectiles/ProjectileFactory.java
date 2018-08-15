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
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadeExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaThrowProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.magnet.MagnetShock;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterShock;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class ProjectileFactory {

    private ProjectileList projectileList;
    private BodyFactory bodyFactory;
    private ScreenFlasher screenFlasher;
    private GameContext context;

    public ProjectileFactory(GameContext context) {
        this.projectileList = context.getProjectileList();
        this.bodyFactory    = context.getBodyFactory();
        this.screenFlasher  = context.getScreenFlasher();
        this.context        = context;
    }

    /***** Create methods *****/
    public PlayerDamageExplosion createPlayerDamageExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(20f, 20f));

        //Create projectile and apply the transform send in parameter
        PlayerDamageExplosion explosion = new PlayerDamageExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public GrenadeExplosion createGrenadeExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create projectile and apply the transform send in parameter
        GrenadeExplosion explosion = new GrenadeExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public PlayerProjectile createPlayerProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(0.5f, 0.5f));

        //Create projectile and apply the transform send in parameter
        PlayerProjectile projectile = new PlayerProjectile(transform, context);

        //Add projectile to the list so the program can keep track of it
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PlayerProjectileBodyTask(projectile));

        //Return to projectile
        return projectile;
    }
    public CookieProjectile createCookieProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        CookieProjectile cookieProjectile = new CookieProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(cookieProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new CookieBodyTask(cookieProjectile));

        //Return explosion
        return cookieProjectile;
    }
    public LaserProjectile createLaserProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(1f, 1f));

        //Create projectile and apply the transform send in parameter
        LaserProjectile laserProjectile = new LaserProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(laserProjectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new LaserBodyTask(laserProjectile));

        //Return explosion
        return laserProjectile;
    }
    public TeleporterExplosion createTeleporterExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(8f, 8f));

        //Create projectile and apply the transform send in parameter
        TeleporterExplosion explosion = new TeleporterExplosion(transform,context);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public TeleporterShock createTeleporterShock(Transform transform) {

        //Create projectile and apply the transform send in parameter
        transform = transform.clone();
        TeleporterShock shock = new TeleporterShock(transform,context);

        //Add projectile to projectilelist
        projectileList.add(shock);

        //Return explosion
        return shock;
    }
    public MagnetShock createMagnetShock(Pickup pickup) {

        //Create projectile and apply the transform send in parameter
        MagnetShock shock = new MagnetShock(pickup,context);

        //Add projectile to projectilelist
        projectileList.add(shock);

        //Return explosion
        return shock;
    }
    public BombProjectile createBombProjectile(Transform transform) {

        //Create projectile and apply the transform send in parameter
        transform = transform.clone();
        BombProjectile projectile = new BombProjectile(transform,context);

        //Add projectile to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new BombProjectileBodyTask(projectile));

        //Return projectile
        return projectile;
    }
    public BombExplosion createBombExplosion(Transform transform) {

        //Manipulate transform
        transform = transform.clone();
        transform.setRotation(0);
        transform.setScale(new Vector2(12f, 12f));

        //Create explosion and apply the transform send in parameter
        BombExplosion explosion = new BombExplosion(transform,context);

        //Add explosion to projectilelist
        projectileList.add(explosion);

        //Add bodytask for the projectile
        bodyFactory.addTask(new DefaultExplosionBodyTask(explosion));

        //Return explosion
        return explosion;
    }
    public KatanaProjectile createKatanaProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create explosion and apply the transform send in parameter
        KatanaProjectile projectile = new KatanaProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new KatanaBodyTask(projectile));

        //Return explosion
        return projectile;
    }
    public KatanaThrowProjectile createKatanaThrowProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create explosion and apply the transform send in parameter
        KatanaThrowProjectile projectile = new KatanaThrowProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new KatanaBodyTask(projectile));

        //Return explosion
        return projectile;
    }
    public BoomerangProjectile createBoomerangProjectile(Transform transform) {

        //Manipulate transform
        transform = transform.clone();

        //Create and apply the transform send in parameter
        BoomerangProjectile projectile = new BoomerangProjectile(transform,context);

        //Add explosion to projectilelist
        projectileList.add(projectile);

        //Add bodytask for the projectile
        bodyFactory.addTask(new BoomerangBodyTask(projectile));

        //Return explosion
        return projectile;
    }
}
