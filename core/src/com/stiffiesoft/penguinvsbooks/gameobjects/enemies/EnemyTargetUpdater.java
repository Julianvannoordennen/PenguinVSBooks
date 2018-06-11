package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.stiffiesoft.penguinvsbooks.system.Transformable;

import java.util.Timer;
import java.util.TimerTask;

public class EnemyTargetUpdater extends TimerTask {

    private Transformable target;
    private Transformable enemy;
    private Timer timer;
    public final long REFRESH_RATE = 1;

    public EnemyTargetUpdater(Transformable enemy) {
        target = null;
        timer = new Timer();
        timer.schedule(this, REFRESH_RATE, REFRESH_RATE);
        this.enemy = enemy;
    }

    public void stop() {
        this.cancel();
        timer.cancel();
    }

    @Override
    public void run() {
        target = EnemyTargetSystem.getNearestTarget(enemy.getTransform().getPosition());
    }

    public Transformable getTarget() {
        return target;
    }
}
