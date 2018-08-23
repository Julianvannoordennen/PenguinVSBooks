package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.cookie;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyTask;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;

public class CookieBodyTask extends BodyTask {

    public CookieBodyTask(Collidable collidable) {
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
        CircleShape collisionShape = new CircleShape();
        collisionShape.setPosition(new Vector2(0,0));
        collisionShape.setRadius(transform.getWidth() / 2f);

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

        //Return body
        return body;
    }
}
