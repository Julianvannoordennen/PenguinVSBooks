package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Lifes;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Score;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileListCleaner;
import com.stiffiesoft.penguinvsbooks.scenes.BaseScene;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionDetector;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.DynamicRenderingList;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Game extends BaseScene {

    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera box2DCamera;
    private World world;
    private DynamicRenderingList renderList;
    private Player player;
    private PickupFactory pickupFactory;
    private PowerupFactory powerupFactory;
    private BodyFactory bodyFactory;
    private EnemyFactory enemyFactory;
    private ProjectileFactory projectileFactory;
    private ProjectileListCleaner projectileListCleaner;
    private Score score;
    private Lifes lifes;

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
        bodyFactory = new BodyFactory(world);
        enemyFactory = new EnemyFactory(bodyFactory);
        projectileFactory = new ProjectileFactory(bodyFactory, screenFlasher);
        powerupFactory = new PowerupFactory(projectileFactory);
        pickupFactory = new PickupFactory(bodyFactory, powerupFactory, screenFlasher);

        //Create all single instances that will be used inside the game
        player = new Player(this, projectileFactory);
        score = new Score(getMain().getFontFactory());
        lifes = new Lifes(getMain().getFontFactory());
        projectileListCleaner = new ProjectileListCleaner(projectileFactory.getProjectileList());

        //Add all connections
        bodyFactory.addTask(new PlayerBodyTask(player));
        enemyFactory.getEnemyList().addListener(score);
        enemyFactory.getEnemyList().addListener(pickupFactory);
        player.addListener(lifes);

        //Add all items that can be rendered to the renderlist, from beneath to above
        renderList = new DynamicRenderingList();
        renderList.add(pickupFactory.getPickupList());
        renderList.add(player);
        renderList.add(enemyFactory.getEnemyList());
        renderList.add(projectileFactory.getProjectileList());
        renderList.add(score);
        renderList.add(lifes);
        renderList.add(screenFlasher);


        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 4, C.sH() / 4));
        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 5, C.sH() / 5));
        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 8, C.sH() / 8));
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Update all systems
        enemyFactory.update();
        projectileListCleaner.update();
        powerupFactory.getPowerupList().update();
        bodyFactory.executeTasks();

        //Render all objects
        renderList.render(batch);

        //Render the world
//        debugRenderer.render(world, box2DCamera.combined);

        //Tell world how much times he need to check the collision
        world.step(0, 0, 0);

        //Dispose objects that are not required anymore
        projectileFactory.getProjectileList().dispose();
        enemyFactory.getEnemyList().dispose();
        pickupFactory.getPickupList().dispose();
    }

    @Override
    protected void onDispose() {

        //Dispose all things that are required to dispose
        score.dispose();
        lifes.dispose();
    }
}
