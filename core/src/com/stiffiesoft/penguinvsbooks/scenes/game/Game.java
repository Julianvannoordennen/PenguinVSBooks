package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.scenes.BaseScene;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Game extends BaseScene {

    //The context
    private GameContext context;

    //Debug utilities
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera box2DCamera;


    public Game(Main main) {
        super(main);

        //Clear targets
        EnemyTargetSystem.clear();

        //Create game context
        context = new GameContext(main);

        //Create collision debugging
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false,C.sW(), C.sH());
        box2DCamera.position.set(C.sW() / 2, C.sH() / 2, 0);
        debugRenderer = new Box2DDebugRenderer();

        //Create some single instances
        PickupFactory pickupFactory = context.getPickupFactory();
        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 4, C.sH() / 4));
        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 5, C.sH() / 5));
        pickupFactory.createTeleporterPickup(new Vector2(C.sW() / 8, C.sH() / 8));
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Update all systems
        context.getPauseChecker().update();
        context.getEnemyFactory().update();
        context.getProjectileListCleaner().update();
        context.getPowerupList().update();
        context.getBodyFactory().executeTasks();

        //Render all objects
        context.getRenderList().render(batch);

        //Tell world how much times he need to check the collision
        context.getWorld().step(0, 0, 0);
//        debugRenderer.render(context.getWorld(), box2DCamera.combined);

        //Dispose objects that are not required anymore
        context.getProjectileList().dispose();
        context.getEnemyList().dispose();
        context.getPickupList().dispose();
        context.getPowerupList().dispose();
        context.getJunkList().dispose();
        context.getNotificationList().dispose();
    }

    @Override
    protected void onDispose() {

        //Dispose all things that are required to dispose
        context.getScore().dispose();
        context.getLifes().dispose();
    }
}
