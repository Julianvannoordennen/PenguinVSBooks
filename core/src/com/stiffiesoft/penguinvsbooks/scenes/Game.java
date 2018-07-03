package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyList;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemySpawn;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.TargetTest;

public class Game extends BaseScene {

    private TargetTest targetTest;
    private EnemyList enemyList;
    private EnemySpawn enemySpawn;

    public Game(Main main) {
        super(main);
        targetTest = new TargetTest();
        enemyList = new EnemyList();
        enemySpawn = new EnemySpawn(enemyList);
    }

    @Override
    protected void onRender(SpriteBatch batch) {
        targetTest.draw(batch);
        enemySpawn.update();
        enemyList.render(batch);
    }

    @Override
    protected void onDispose() {
    }
}
