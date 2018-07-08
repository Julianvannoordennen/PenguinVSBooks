package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyList;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.TargetTest;
import com.stiffiesoft.penguinvsbooks.gameobjects.player.Player;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.CollisionDetector;
import com.stiffiesoft.penguinvsbooks.system.DynamicRenderingList;

public class Game extends BaseScene {

    private DynamicRenderingList renderList;
    private Player player;
    private EnemyFactory enemyFactory;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera box2DCamera;

    public Game(Main main) {
        super(main);

        //Create collision detection system
        world = new World(new Vector2(0,0),true);
        world.setContactListener(new CollisionDetector());

        //Create collision debugging
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false,C.sW(), C.sH());
        box2DCamera.position.set(C.sW() / 2, C.sH() / 2, 0);
        debugRenderer = new Box2DDebugRenderer();

        //Create renderinglist which will render all objects inside the game
        renderList = new DynamicRenderingList();

        //Create the player and set him as a enemy target
        player = new Player(world);

        //Create an enemylist which will keep track of all the enemies displayed
        enemyFactory = new EnemyFactory(world);

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

        //Render the world
        //debugRenderer.render(world, box2DCamera.combined);

        //Tell world how much times he need to check the collision
        world.step(C.dT(), 6, 2);
    }

    @Override
    protected void onDispose() {
    }
}
