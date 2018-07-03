package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyList;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemySpawn;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.TargetTest;
import com.stiffiesoft.penguinvsbooks.system.DynamicRenderingList;

public class Game extends BaseScene {

    private DynamicRenderingList renderList;
    private TargetTest targetTest;
    private EnemyList enemyList;
    private EnemySpawn enemySpawn;

    public Game(Main main) {
        super(main);

        //Create renderinglist which will render all objects inside the game
        renderList = new DynamicRenderingList();
        targetTest = new TargetTest();

        //Create an enemylist which will keep track of all the enemies displayed
        enemyList = new EnemyList();
        enemySpawn = new EnemySpawn(enemyList);

        //Add all items that can be rendered to the renderlist
        renderList.add(targetTest);
        renderList.add(enemyList);
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Update all systems
        enemySpawn.update();

        //Render all objects
        renderList.render(batch);
    }

    @Override
    protected void onDispose() {
    }
}
