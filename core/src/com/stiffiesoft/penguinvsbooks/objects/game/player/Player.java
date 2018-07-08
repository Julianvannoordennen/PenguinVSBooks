package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Player implements Transformable, Renderable {

    private PlayerState state;
    private Transform transform;
    private Body body;
    public static final String NAME = "Player";

    public Player(World world) {

        //Position player in the center of the screen
        transform = new Transform(C.sW() / 2,C.sH() / 2,C.pH() * 5, C.pH() * 5,1,1,0);

        //Register the player as a enemy target
        EnemyTargetSystem.registerTarget(this);

        //Set start state
        state = new PlayerStateMoving(this);

        //Create body
        createBody(world);
    }

    private void createBody(World world) {

        //Create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(transform.getPosition());
        body = world.createBody(bodyDef);

        //Create shape that works as the collision area
        CircleShape collisionShape = new CircleShape();
        collisionShape.setPosition(new Vector2(0,0));
        collisionShape.setRadius(transform.getWidth() / 2);

        //Create filter for fixture
        Filter filter = new Filter();
        filter.categoryBits = 0;
        filter.groupIndex = 1;

        //Create fixture for collision
        Fixture fixture = body.createFixture(collisionShape, 0);
        fixture.setUserData(NAME);
        fixture.setFilterData(filter);

        //Dispose the shape since we don't need it anymore
        collisionShape.dispose();
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
}
