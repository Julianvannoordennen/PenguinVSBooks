package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.dyslexia;

import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyTask;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

public class DyslexiaEnemyBodyTask extends BodyTask {

    public DyslexiaEnemyBodyTask(Collidable collidable) {
        super(collidable);
    }

    @Override
    protected Body createBody(World world) {

        //Get transform from collidable
        Transform transform = collidable.getTransform();

        //Create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(transform.getPosition());
        Body body = world.createBody(bodyDef);

        //Create shape that works as the collision area
        PolygonShape collisionShape = new PolygonShape();
        collisionShape.setAsBox(transform.getWidth() / 2.75f, transform.getHeight() / 3.5f);

        //Create filter for fixture
        Filter filter = new Filter();
        filter.categoryBits = CollisionTypes.PROJECTILE;    //I am
        filter.maskBits = CollisionTypes.ENEMY;             //I hit

        //Create fixture for collision
        Fixture fixture = body.createFixture(collisionShape, 0);
        fixture.setUserData(collidable);
        fixture.setFilterData(filter);

        //Dispose the shape since we don't need it anymore
        collisionShape.dispose();

        //Return the body
        return body;
    }
}