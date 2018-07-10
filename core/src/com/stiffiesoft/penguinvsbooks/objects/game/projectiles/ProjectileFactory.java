package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.Random;

public class ProjectileFactory {

    private World world;
    private ProjectileList projectileList;

    public ProjectileFactory(World world) {
        this.world = world;
        this.projectileList = new ProjectileList();
    }

    public PlayerProjectile createPlayerProjectile(Transform transform) {

        //Manipulate transform
        transform.setRotation(0);
        transform.setScale(new Vector2(0.5f, 0.5f));

        //Create projectile and apply the transform send in parameter
        PlayerProjectile projectile = new PlayerProjectile(transform, world, projectileList);

        //Add projectile to the list so the program can keep track of it
        projectileList.add((Projectile)projectile);

        //Return to projectile
        return projectile;
    }

    public Explosion createBaseExplosion(Transform transform) {

        //Manipulate transform
        transform.setSize(new Vector2(C.pH() * 50, C.pH() * 50));
        transform.setCenter(new Vector2(C.pH() * 25, C.pH() * 25));

        //Create projectile and apply the transform send in parameter
        Explosion explosion = new Explosion(transform,world,projectileList);

        //Add projectile to projectilelist
        projectileList.add(explosion);

        //Return projectile
        return explosion;
    }

    public ProjectileList getProjectileList() {
        return projectileList;
    }
}
