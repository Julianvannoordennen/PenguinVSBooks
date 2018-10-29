package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObjectList;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyList {

    private GameObjectList gameObjectList;
    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> disposableEnemies;
    private ArrayList<EnemyListListener> listeners;
    private EnemyStatisticsGroup statistics;

    public EnemyList(GameContext context) {
        gameObjectList      = context.getGameObjectList();
        enemies             = new ArrayList<>();
        disposableEnemies   = new ArrayList<>();
        listeners           = new ArrayList<>();
        statistics          = context.getStatistics().getEnemyStatistics();
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
        gameObjectList.add((GameObject)enemy);
        statistics.getEnemiesSpawned().increase();
        statistics.getEnemiesOnScreen().increase();
    }

    public ArrayList<Enemy> getArray() {
        return enemies;
    }

    public void addListener(EnemyListListener listener) {
        listeners.add(listener);
    }

    public void destroy(Enemy enemy) {

        //Place item in special dispose list
        disposableEnemies.add(enemy);
    }

    public Enemy getNearest(Vector2 position) {

        //Check if there is an enemy in the array list
        if (enemies.size() == 0)

            //Send null back, there are no enemies
            return null;

        //Get distance from first enemy
        Enemy nearest           = enemies.get(0);
        float distance          = position.dst(nearest.getTransform().getPosition());

        //Go through all other enemies
        for (int index = 1; index < enemies.size(); index++) {

            //Check distance
            Enemy enemy         = enemies.get(index);
            float tempDistance  = position.dst(enemy.getTransform().getPosition());

            //Is it closer than the previous distance?
            if (tempDistance < distance) {

                //Save the data
                nearest         = enemy;
                distance        = tempDistance;
            }
        }

        //Return the nearest enemy
        return nearest;
    }

    public void dispose() {

        //Check each enemy in the disposable list
        Iterator iterator = disposableEnemies.iterator();
        while(iterator.hasNext()) {

            //Get body
            Enemy enemy = (Enemy)iterator.next();
            Body body = enemy.getBody();

            //Update statistics
            statistics.getEnemiesDied().increase();
            statistics.getEnemiesOnScreen().decrease();

            //Destroy fixtures and object
            for(Fixture fixture : body.getFixtureList()) body.destroyFixture(fixture);
            enemies.remove(enemy);
            gameObjectList.remove((GameObject)enemy);
            iterator.remove();

            //Call listeners
            for(EnemyListListener listener : listeners) listener.onEnemyDisposed(enemy);
        }
    }
}
