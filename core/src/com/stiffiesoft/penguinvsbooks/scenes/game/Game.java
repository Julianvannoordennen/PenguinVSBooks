package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.TimeUtils;
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
    private long nextPress;

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
        nextPress = TimeUtils.millis() + 1000;

        //Create some single normal
        PickupFactory pickupFactory = context.getPickupFactory();
        Vector2 s = new Vector2(C.sW() / 4, C.sH() / 4);
        pickupFactory.forceSpawn(new Vector2(s.x, s.y));
        pickupFactory.forceSpawn(new Vector2(s.x * 3, s.y));
        pickupFactory.forceSpawn(new Vector2(s.x, s.y * 3));
        pickupFactory.forceSpawn(new Vector2(s.x * 3, s.y * 3));

        //Fade in
        context.getScreenFader().fade(Color.BLACK, 1,0);
    }

    @Override
    protected void onRender(SpriteBatch batch) {

        //Draw statistics
        if (Gdx.input.isKeyPressed(Input.Keys.Q) && TimeUtils.millis() > nextPress) {
            System.out.println(context.getStatistics());
            nextPress = TimeUtils.millis() + 1000;

        }

        //Check if the pause window is turned off
        if (C.cGT() != 0) {

            //Update all systems
            context.getPauseChecker().update();
            context.getEnemyFactory().update();
            context.getProjectileListCleaner().update();
            context.getPowerupList().update();
            context.getBodyFactory().update();

            //Update all objects
            context.getGameObjectList().update();
        }

        //Render all objects
        context.getGameObjectList().render(batch);

        //Tell world how much times he need to check the collision
        context.getWorld().step(0, 0, 0);
//        debugRenderer.render(context.getWorld(), box2DCamera.combined);

        //Check if the pause window is turned on
        if (C.cGT() == 0) {

            //Update and render pause window
            context.getPauseWindow().update();
            context.getPauseWindow().render(batch);
        }

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
        context.getShredderCannonCounter().dispose();
    }
}
