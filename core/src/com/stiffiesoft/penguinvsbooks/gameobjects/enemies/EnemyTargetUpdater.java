package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.system.Transformable;

import java.util.Timer;
import java.util.TimerTask;

public class EnemyTargetUpdater {

    private Transformable target;
    private Transformable enemy;
    private long spawnRate;
    private long next;

    public EnemyTargetUpdater(Transformable enemy) {
        target = null;
        spawnRate = 1000; //1000 = 1 second
        this.enemy = enemy;
        updateTime();
    }

    public void updateTime() {
        next = TimeUtils.millis() + spawnRate;
    }

    public void update() {
        if (TimeUtils.millis() >= next) {
            updateTime();

            if (enemy != null)
                target = EnemyTargetSystem.getNearestTarget(enemy.getTransform().getPosition());
        }
    }

    public Transformable getTarget() {
        return target;
    }
}
