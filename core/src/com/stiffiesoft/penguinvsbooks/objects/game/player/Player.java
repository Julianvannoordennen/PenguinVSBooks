package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.Game;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

import java.util.ArrayList;

public class Player implements Transformable, Renderable, Collidable {

    private PlayerState state;
    private Transform transform;
    private Body body;
    private Game game;
    private ProjectileFactory projectileFactory;
    private ArrayList<PlayerListener> playerListeners;

    public Player(Game game, ProjectileFactory projectileFactory) {

        //Create array for listeners
        playerListeners = new ArrayList<>();

        //Position player in the center of the screen
        transform = new Transform(C.sW() / 2,C.sH() / 2,C.pH() * 5, C.pH() * 5,1,1,0);

        //Register the player as a enemy target
        EnemyTargetSystem.registerTarget(this);

        //We need to save the game variable since the player can change game scenes (For example when dying, the game will return to the menu)
        this.game = game;

        //Save the projectile factory
        this.projectileFactory = projectileFactory;

        //Set start state
        state = new PlayerStateMoving(this);
    }

    public void addListener(PlayerListener playerListener) {
        playerListeners.add(playerListener);
    }

    public ArrayList<PlayerListener> getPlayerListeners() {
        return playerListeners;
    }

    //Get the game from the player context, will be used in the states
    public Game getGame() {
        return game;
    }

    public ProjectileFactory getProjectileFactory() {
        return this.projectileFactory;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Update state if it exists
        if (state != null) state.render(batch);

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void onCollision(Collidable other, short type) {

        //Only enemy collisions will be handled here, pickup collisions will be handled in the pickup itself
        if (type == CollisionTypes.ENEMY)

            //The state of the player will decide what to do with the collision
            state.onCollision(other);
    }

    public void die() {

        //Stop and go to main menu
        game.getMain().setScreen(new StartMenu(game.getMain()));
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
    }
}
