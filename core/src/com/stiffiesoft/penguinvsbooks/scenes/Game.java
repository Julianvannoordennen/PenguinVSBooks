package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyList;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.TargetTest;
import com.stiffiesoft.penguinvsbooks.gameobjects.player.Player;
import com.stiffiesoft.penguinvsbooks.system.DynamicRenderingList;

public class Game extends BaseScene {

    private DynamicRenderingList renderList;
    private Player player;
    private EnemyFactory enemyFactory;

    public Game(Main main) {
        super(main);

        //Create renderinglist which will render all objects inside the game
        renderList = new DynamicRenderingList();

        //Create the player and set him as a enemy target
        player = new Player();

        //Create an enemylist which will keep track of all the enemies displayed
        enemyFactory = new EnemyFactory();

        //Add all items that can be rendered to the renderlist
        renderList.add(enemyFactory.getEnemyList());
        renderList.add(player);
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Update all systems
        enemyFactory.update();

        //Render all objects
        renderList.render(batch);
    }

    @Override
    protected void onDispose() {
    }
}
