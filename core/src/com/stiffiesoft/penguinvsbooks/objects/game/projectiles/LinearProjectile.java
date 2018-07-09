package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class LinearProjectile implements Transformable, Collidable, Renderable, Projectile {

    protected Transform transform;
    protected Body body;
    protected float speed;
    protected ProjectileList projectileList;

    public LinearProjectile(Transform transform, World world, ProjectileList projectileList) {

        //Save values
        this.transform = transform;
        this.projectileList = projectileList;

        //Set default speed
        speed = 1000f;

        //Create body
        createBody(world);
    }

    private void createBody(World world) {

        //Create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody; //Projectile will be dynamic, making all enemies dynamic will take more performance
        bodyDef.position.set(transform.getPosition());
        body = world.createBody(bodyDef);

        //Create shape that works as the collision area
        CircleShape collisionShape = new CircleShape();
        collisionShape.setPosition(new Vector2(0,0));
        collisionShape.setRadius(transform.getWidth() / 4);

        //Create filter for fixture
        Filter filter = new Filter();
        filter.categoryBits = CollisionTypes.PROJECTILE;    //I am
        filter.maskBits = CollisionTypes.ENEMY;             //I hit

        //Create fixture for collision
        Fixture fixture = body.createFixture(collisionShape, 0);
        fixture.setUserData(this);
        fixture.setFilterData(filter);

        //Dispose the shape since we don't need it anymore
        collisionShape.dispose();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Move towards target
        transform.moveInDirection( speed * C.cGT());

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public void onCollision(Collidable other, short collisionType) {

        //Destroy self
        projectileList.destroy(this);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return body;
    }
}
