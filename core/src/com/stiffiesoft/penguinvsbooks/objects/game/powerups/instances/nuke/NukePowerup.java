package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.nuke;

import com.badlogic.gdx.graphics.Color;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.text.DefinedColors;

public class NukePowerup extends Powerup {

    private EnemyList enemyList;
    private ScreenFlasher screenFlasher;
    private Color flashColor;

    public NukePowerup(GameContext context, Transform initial) {
        super(context, initial);
        enemyList           = context.getEnemyList();
        screenFlasher       = context.getScreenFlasher();
        flashColor          = DefinedColors.NUKE_FLASH;
        start();
    }

    @Override
    protected void start() {

        //Flash screen
        screenFlasher.flash(flashColor);

        //Destroy all enemies
        for(Enemy enemy : enemyList.getArray())
            enemy.die();

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
