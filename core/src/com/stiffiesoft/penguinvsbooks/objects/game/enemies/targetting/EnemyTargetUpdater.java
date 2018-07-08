package com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting;

import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;

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
