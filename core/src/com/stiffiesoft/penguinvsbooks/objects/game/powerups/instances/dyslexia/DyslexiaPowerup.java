package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia;

import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class DyslexiaPowerup extends Powerup {

    private EnemyList enemyList;

    public DyslexiaPowerup(GameContext context, Transform initial) {
        super(context, initial);
        enemyList = context.getEnemyList();
        start();
    }

    @Override
    protected void start() {

        //Find nearest enemy
        Enemy enemy = enemyList.getNearest(initial.getPosition());

        //Create dyslexia powerup at the nearest enemy
        projectileFactory.createDyslexiaEnemy(enemy.getTransform().clone());

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {}
}
