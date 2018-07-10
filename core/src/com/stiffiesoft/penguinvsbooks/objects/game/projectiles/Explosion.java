package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Collidable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.CollisionTypes;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class Explosion implements Renderable, Projectile, Collidable {

    protected Transform transform;
    protected Body body;
    protected float decreaseSpeed;
    protected ProjectileList projectileList;

    public Explosion(Transform transform, World world, ProjectileList projectileList) {

        //Save variables
        this.projectileList = projectileList;
        this.transform = transform;
        this.decreaseSpeed = 1f;

        //Create body for collision detecting
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
        collisionShape.setPosition(transform.getCenter());
        collisionShape.setRadius(transform.getWidth() / 2);

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

        //Decrease size
        Vector2 newScale = new Vector2(transform.getXScale() - (decreaseSpeed * C.cGT()), transform.getYScale() - (decreaseSpeed * C.cGT()));
        transform.setScale(newScale);

        //Draw explosion
        Transform.draw(batch, A.m.get(A.explosion), transform);

        //Check if too small
        if (newScale.x <= 0.01f) {
            projectileList.destroy(this);
        }
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void onCollision(Collidable other, short collisionType) {

    }
}
