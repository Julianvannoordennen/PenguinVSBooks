package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyList implements Renderable {

    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> disposableEnemies;

    public EnemyList() {
        enemies = new ArrayList<>();
        disposableEnemies = new ArrayList<>();
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public void render(SpriteBatch batch) {
        for(Enemy enemy : enemies)
            enemy.render(batch);
    }

    public void destroy(Enemy enemy) {

        //Place item in special dispose list
        disposableEnemies.add(enemy);

        //Remove from first list
        enemies.remove(enemy);
    }

    public void dispose() {

        //Check each enemy in the disposable list
        Iterator iterator = disposableEnemies.iterator();
        while(iterator.hasNext()) {

            //Get body
            Enemy enemy = (Enemy)iterator.next();
            Body body = enemy.getBody();

            //Destroy fixtures and object
            for(Fixture fixture : body.getFixtureList()) body.destroyFixture(fixture);
            iterator.remove();
        }
    }
}
