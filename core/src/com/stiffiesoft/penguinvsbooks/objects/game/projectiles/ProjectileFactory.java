package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerDamageExplosion;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectileBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.GrenadeExplosion;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class ProjectileFactory {

    private ProjectileList projectileList;
    private BodyFactory bodyFactory;

    public ProjectileFactory(BodyFactory bodyFactory) {
        this.projectileList = new ProjectileList();
        this.bodyFactory = bodyFactory;
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

    public Explosion createPlayerDamageExplosion(Transform transform) {

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

    public Explosion createGrenadeExplosion(Transform transform) {

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

    public ProjectileList getProjectileList() {
        return projectileList;
    }
}
