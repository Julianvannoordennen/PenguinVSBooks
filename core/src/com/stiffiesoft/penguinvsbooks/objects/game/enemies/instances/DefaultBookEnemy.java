package com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetUpdater;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Collidable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.CollisionTypes;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class DefaultBookEnemy implements Transformable, Enemy, Collidable {

    private SpriteAnimation currentSpriteAnimation;
    private Transform transform;
    private EnemyTargetUpdater targetUpdater;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;
    private Body body;
    private EnemyList enemyList;

    public DefaultBookEnemy(World world, EnemyList enemyList) {

        //Transform
        transform = new Transform(256,256,C.pH() * 5, C.pH() * 5,1,1,0);
        defaultMovementSpeed = 50;
        currentMovementSpeed = defaultMovementSpeed;

        //Sprite Animation
        currentSpriteAnimation = new SpriteAnimation(A.m.get(A.defaultBookEnemyAtlas),30);

        //Enemy target updater
        this.targetUpdater = new EnemyTargetUpdater(this);

        //Save the enemy list
        this.enemyList = enemyList;

        //Create collision detector
        createBody(world);
    }

    private void createBody(World world) {

        //Create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(transform.getPosition());
        body = world.createBody(bodyDef);

        //Create shape that works as the collision area
        PolygonShape collisionShape = new PolygonShape();
        collisionShape.setAsBox(transform.getWidth() / 2.75f, transform.getHeight() / 3.5f);

        //Create filter for fixture
        Filter filter = new Filter();
        filter.categoryBits = CollisionTypes.ENEMY;                                //I am
        filter.maskBits = CollisionTypes.PLAYER | CollisionTypes.PROJECTILE;       //I hit

        //Create fixture for collision
        Fixture fixture = body.createFixture(collisionShape, 0);
        fixture.setUserData(this);
        fixture.setFilterData(filter);

        //Dispose the shape since we don't need it anymore
        collisionShape.dispose();
    }

    public void render(SpriteBatch batch) {

        //Update targetting system
        targetUpdater.update();

        //Render animation
        currentSpriteAnimation.render(batch, transform);

        //Set movement angle
        Transformable target = targetUpdater.getTarget();
        if (target != null) {
            Vector2 targetPosition = target.getTransform().getPositionCenter();
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), targetPosition));
        }

        //Move towards target
        transform.moveInDirection( currentMovementSpeed * C.cGT());

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void onCollision(Collidable other, short type) {

        //Check if it's a projectile
        if (type == CollisionTypes.PROJECTILE)

            //Destroy enemy
            enemyList.destroy(this);
    }

    @Override
    public Body getBody() {
        return body;
    }
}
