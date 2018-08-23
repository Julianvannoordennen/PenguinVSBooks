package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.earthquake;

import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenShaker;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public class EarthquakePowerup extends Powerup {

    private ScreenShaker screenShaker;
    private ArrayList<Enemy> enemies;
    private float initialEnemySpeed;
    private float force;
    private long destroyTime;
    private float destroyLength;

    public EarthquakePowerup(GameContext context, Transform initial) {
        super(context, initial);
        screenShaker        = context.getScreenShaker();
        enemies             = context.getEnemyList().getArray();
        force               = 4;
        destroyLength       = 1000; //Earthquake lasts 1 second
        destroyTime         = TimeUtils.millis() + (long)destroyLength;
        start();
    }

    @Override
    protected void start() {

        //Shake screen
        screenShaker.shake(1000L);

        //Check if there is an enemy
        if (enemies.size() > 0) {

            //Grab speed from first enemy
            initialEnemySpeed   = enemies.get(0).getDefaultSpeed();
            force               *= -initialEnemySpeed;

            //Go through all the enemies
            for (int index = 0; index < enemies.size(); index++)
                enemies.get(index).setSpeed(force);

        } else {

            //Done, destroy the powerup
            powerupList.destroy(this);
        }
    }

    @Override
    protected void update() {

        //Check if duration is done
        if (TimeUtils.millis() > destroyTime) {

            //Restore all enemies their speed
            for (int index = 0; index < enemies.size(); index++)
                enemies.get(index).setSpeed(initialEnemySpeed);

            //Done, destroy the powerup
            powerupList.destroy(this);
        }
    }
}
