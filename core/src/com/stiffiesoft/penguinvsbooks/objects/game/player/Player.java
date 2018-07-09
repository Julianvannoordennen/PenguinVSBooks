package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.Game;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Player implements Transformable, Renderable, Collidable {

    private PlayerState state;
    private Transform transform;
    private Body body;
    private Game game;
    private ProjectileFactory projectileFactory;

    public Player(World world, Game game, ProjectileFactory projectileFactory) {

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

        //Create body
        createBody(world);
    }

    private void createBody(World world) {

        //Create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody; //Player will be dynamic, making the enemies would have cost a lot of performance
        bodyDef.position.set(transform.getPosition());
        body = world.createBody(bodyDef);

        //Create shape that works as the collision area
        CircleShape collisionShape = new CircleShape();
        collisionShape.setPosition(new Vector2(0,0));
        collisionShape.setRadius(transform.getWidth() / 2);

        //Create filter for fixture
        Filter filter = new Filter();
        filter.categoryBits = CollisionTypes.PLAYER;    //I am
        filter.maskBits = CollisionTypes.ENEMY;         //I hit

        //Create fixture for collision
        Fixture fixture = body.createFixture(collisionShape, 0);
        fixture.setUserData(this);
        fixture.setFilterData(filter);

        //Dispose the shape since we don't need it anymore
        collisionShape.dispose();
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
}
