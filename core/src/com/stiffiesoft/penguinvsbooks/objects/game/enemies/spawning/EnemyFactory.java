package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances.DefaultBookEnemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances.DefaultBookEnemyBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.statistics.Statistics;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

import java.util.Random;

public class EnemyFactory {

    private EnemyList enemyList;
    private long spawnRate;
    private long next;
    private int edgeCorrection;
    private BodyFactory bodyFactory;
    private GameContext context;
    private boolean alert;

    public EnemyFactory(GameContext context) {
        edgeCorrection      = 250;
        spawnRate           = 25; //1000 = 1 second
        this.bodyFactory    = context.getBodyFactory();
        this.enemyList      = context.getEnemyList();
        this.context        = context;
        this.alert          = false;
        updateTime();
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public void updateTime() {
        next = TimeUtils.millis() + (alert ? spawnRate / 4 : spawnRate);
    }

    public void update() {

        //Check if it's time to create a new enemy
        if (TimeUtils.millis() >= next) {

            //Update the time
            updateTime();

            //Spawn enemy
            spawnEnemy();
        }
    }

    public void spawnEnemy() {

        //Create enemy
        DefaultBookEnemy enemy = new DefaultBookEnemy(context);

        //Get position around the edge of the screen
        Vector2 position = C.pOS(edgeCorrection);

        //Set position
        enemy.getTransform().setPosition(position);

        //Add to enemylist
        enemyList.add(enemy);

        //Create body task for enemy
        bodyFactory.addTask(new DefaultBookEnemyBodyTask(enemy));
    }
}
