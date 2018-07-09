package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.counters.Counter;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.counters.Score;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileListCleaner;
import com.stiffiesoft.penguinvsbooks.scenes.BaseScene;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.CollisionDetector;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.DynamicRenderingList;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Game extends BaseScene {

    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera box2DCamera;
    private World world;
    private DynamicRenderingList renderList;
    private Player player;
    private EnemyFactory enemyFactory;
    private ProjectileFactory projectileFactory;
    private ProjectileListCleaner projectileListCleaner;
    private Score score;

    public Game(Main main) {
        super(main);

        //Clear targets
        EnemyTargetSystem.clear();

        //Create collision detection system
        world = new World(new Vector2(0,0),true);
        world.setContactListener(new CollisionDetector());

        //Create collision debugging
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false,C.sW(), C.sH());
        box2DCamera.position.set(C.sW() / 2, C.sH() / 2, 0);
        debugRenderer = new Box2DDebugRenderer();

        //Create all factories that will be used inside the game
        enemyFactory = new EnemyFactory(world);
        projectileFactory = new ProjectileFactory(world);

        //Create all single instances that will be used inside the game
        player = new Player(world, this, projectileFactory);
        projectileListCleaner = new ProjectileListCleaner(projectileFactory.getProjectileList());
        score = new Score(getMain().getFontFactory());

        //Add all items that can be rendered to the renderlist
        renderList = new DynamicRenderingList();
        renderList.add(projectileFactory.getProjectileList());
        renderList.add(enemyFactory.getEnemyList());
        renderList.add(player);
        renderList.add(score);
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Update all systems
        enemyFactory.update();

        //Render all objects
        renderList.render(batch);
        projectileListCleaner.update();

        //Render the world
        //debugRenderer.render(world, box2DCamera.combined);

        //Tell world how much times he need to check the collision
        world.step(C.dT(), 6, 2);

        //Dispose objects that are not required anymore
        projectileFactory.getProjectileList().dispose();
        enemyFactory.getEnemyList().dispose();
    }

    @Override
    protected void onDispose() {

        //Dispose all things that are required to dispose
        score.dispose();
    }
}
