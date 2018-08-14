package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

import java.util.ArrayList;

public class Player implements Transformable, GameObject, Collidable {

    private Main main;
    private PlayerState state;
    private Transform transform;
    private Body body;
    private ArrayList<PlayerListener> playerListeners;
    private Boolean canReceiveDamage;

    public Player(GameContext context) {

        //Create array for listeners
        playerListeners = new ArrayList<>();

        //Position player in the center of the screen
        transform = new Transform(C.sW() / 2,C.sH() / 2,C.pH() * 5, C.pH() * 5,1,1,0);

        //Register the player as a enemy target
        EnemyTargetSystem.registerTarget(this);

        //Save from context
        this.main = context.getMain();

        //Set start state
        state = new PlayerStateMoving(this, context);
        canReceiveDamage = false;
    }

    public void addListener(PlayerListener playerListener) {
        playerListeners.add(playerListener);
    }

    public ArrayList<PlayerListener> getPlayerListeners() {
        return playerListeners;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void update() {

        //Update state if it exists
        if (state != null) state.update();

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Update state if it exists
        if (state != null) state.render(batch);
    }

    @Override
    public void onCollisionEnter(Collidable other, short type) {

        //Only enemy collisions will be handled here, pickup collisions will be handled in the pickup itself
        if (type == CollisionTypes.ENEMY)

            //The state of the player will decide what to do with the collision
            state.onCollision(other);
    }

    public void die() {

        //Stop and go to primary menu
        main.setScreen(new StartMenu(main));
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
    }

    public Boolean canReceiveDamage() {
        return canReceiveDamage;
    }

    public void canReceiveDamage(Boolean canReceiveDamage) {
        this.canReceiveDamage = canReceiveDamage;
    }
}
