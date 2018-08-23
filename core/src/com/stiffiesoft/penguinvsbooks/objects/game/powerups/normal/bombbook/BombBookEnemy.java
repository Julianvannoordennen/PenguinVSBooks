package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bombbook;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class BombBookEnemy extends LinearProjectile {

    private SpriteAnimation animation;
    private float normalSpeed;
    private float returnSpeed;
    private int bombAmount;
    private Vector2 targetPosition;
    private boolean droppedBomb;
    private int edgeCorrection;
    private ProjectileFactory projectileFactory;

    public BombBookEnemy(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        animation           = new SpriteAnimation(A.m.get(A.bombBookEnemy),20);
        returnSpeed         = C.pH() * 20;
        normalSpeed         = C.pH() * 5;
        speed               = normalSpeed;
        bombAmount          = 4;
        targetPosition      = Vector2.Zero;
        droppedBomb         = false;
        edgeCorrection      = Math.round(C.pW()) * 10;
        projectileFactory   = context.getProjectileFactory();
        transform.setPosition(C.pOS(edgeCorrection));
        generateTargetPosition();
    }

    private void generateTargetPosition() {

        //Save old position
        Vector2 oldPosition = new Vector2(targetPosition);
        Vector2 newPosition = new Vector2(targetPosition);

        //Get new target
        while (oldPosition.dst(newPosition) < C.pW() * 25)
            newPosition = new Vector2(MathUtils.random(C.pW() * 2, C.pW() * 98), MathUtils.random(C.pH() * 2, C.pH() * 98));

        //Assign new position
        targetPosition = new Vector2(newPosition);
    }

    private void generateReturnPosition() {

        //Get position around the edge of the screen
        Vector2 position = C.pOS(edgeCorrection);

        //Assign new position
        targetPosition = new Vector2(position);
    }

    @Override
    public void update() {

        //Move towards the enemy
        transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), targetPosition));

        //Check if target reached
        if (targetPosition.dst(transform.getPositionCenter()) < C.pH() * 2) {

            //Check if the bomb was dropped
            if (droppedBomb) {

                //Check if there is any bomb amount left
                if (bombAmount <= 0) {

                    //Time to die
                    projectileList.destroy(this);

                } else {

                    //Restore speed
                    droppedBomb = false;
                    speed = normalSpeed;

                    //Time to plant a new bomb
                    generateTargetPosition();
                }
            } else {

                //Create bomb
                Transform transform = this.transform.clone();
                transform.applyPosition(new Vector2(0,C.pH() * -2.5f));
                projectileFactory.createBombBookProjectile(transform);
                bombAmount--;
                droppedBomb = true;
                speed = returnSpeed;

                //Fly back
                generateReturnPosition();
            }
        }

        //Update the animation
        animation.update();

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw bomb book
        if (!droppedBomb) {
            Transform transform = this.transform.clone();
            transform.applyPosition(new Vector2(0,C.pH() * -2.5f));
            Transform.draw(batch, A.m.get(A.bombBookProjectile), transform);
        }

        //Draw the animation
        animation.render(batch, transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.ENEMIES;
    }
}
