package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances.DefaultBookEnemy;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.Random;

public class EnemyFactory {

    private long spawnRate;
    private EnemyList enemyList;
    private long next;
    private int edgeCorrection;
    private Random random;
    private World world;

    public EnemyFactory(World world) {
        edgeCorrection = 50;
        spawnRate = 25; //1000 = 1 second
        this.world = world;
        this.enemyList = new EnemyList();
        random = new Random();
        updateTime();
    }

    public void updateTime() {
        next = TimeUtils.millis() + spawnRate;
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
        DefaultBookEnemy enemy = new DefaultBookEnemy(world, enemyList);

        //Get position around the edge of the screen
        Vector2 position;
        switch (random.nextInt(4)) {
            case 0:
                position = new Vector2(
                        random.nextInt((int)C.sW()),
                        (int)C.sH() + edgeCorrection
                );
                break;

            case 1:
                position = new Vector2(
                        random.nextInt((int)C.sW()),
                        -edgeCorrection
                );
                break;

            case 2:
                position = new Vector2(
                        -edgeCorrection,
                        random.nextInt((int)C.sH())
                );
                break;

            default:
                position = new Vector2(
                        (int)C.sW() + edgeCorrection,
                        random.nextInt((int)C.sH())
                );
                break;
        }
        //Set position
        enemy.getTransform().setPosition(position);

        //Add to enemylist
        enemyList.add(enemy);
    }

    public EnemyList getEnemyList() {
        return this.enemyList;
    }
}
