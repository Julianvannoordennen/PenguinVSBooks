package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public class HackerPowerup  extends Powerup {

    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;
    private float hackAmount;

    public HackerPowerup(GameContext context, Transform initial) {
        super(context, initial);
        enemies             = (ArrayList<Enemy>)context.getEnemyList().getArray().clone();
        projectiles         = context.getProjectileList().getArray();
        hackAmount          = 200;
        start();
    }

    @Override
    protected void start() {

        //Go through all projectiles
        for (Projectile projectile : projectiles) {

            //Check if the projectile is from the correct class
            if (projectile.getClass().getSimpleName().equals(HackerProjectile.class.getSimpleName())) {

                //Filter out all enemies that already are being hacked
                HackerProjectile hackerProjectile = (HackerProjectile)projectile;
                enemies.remove(hackerProjectile.getEnemy());
            }
        }

        //Check if there are still enemies to hack left
        while (hackAmount > 0 && enemies.size() > 0) {

            //Grab a random enemy from the array list
            int random      = MathUtils.random(0,enemies.size() - 1);
            Enemy enemy     = enemies.get(random);

            //Create a hack projectile and assign the enemy to it
            HackerProjectile projectile = (HackerProjectile)projectileFactory.createHackerProjectile(initial.clone());
            projectile.setEnemy(enemy);

            //Decrease hack amount
            hackAmount--;
        }

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
