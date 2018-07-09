package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

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

    public ProjectileList getProjectileList() {
        return projectileList;
    }
}
