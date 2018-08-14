package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyList implements GameObject {

    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> disposableEnemies;
    private ArrayList<EnemyListListener> listeners;

    public EnemyList() {
        enemies             = new ArrayList<>();
        disposableEnemies   = new ArrayList<>();
        listeners           = new ArrayList<>();
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addListener(EnemyListListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        for(Enemy enemy : enemies)
            enemy.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        for(Enemy enemy : enemies)
            enemy.render(batch);
    }

    public void destroy(Enemy enemy) {

        //Place item in special dispose list
        disposableEnemies.add(enemy);
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
            enemies.remove(enemy);
            iterator.remove();

            //Call listeners
            for(EnemyListListener listener : listeners) listener.onEnemyDisposed(enemy);
        }
    }
}
