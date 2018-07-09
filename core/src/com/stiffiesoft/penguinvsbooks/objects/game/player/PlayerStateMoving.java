package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Collidable;
import com.stiffiesoft.penguinvsbooks.scenes.menu.StartMenu;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PlayerStateMoving implements PlayerState {

    private Player player;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;
    private long fireRate;
    private long next;

    public PlayerStateMoving(Player player) {

        //We can see the player as the context for this state
        this.player = player;

        //Apply speed to the player
        defaultMovementSpeed = 200;
        currentMovementSpeed = defaultMovementSpeed;

        //Create fire rate, now the player cannot fire books every tick
        fireRate = 100;
        updateTime();
    }

    private void updateTime() {
        next = TimeUtils.millis() + fireRate;
    }

    public void updateMovement() {

        //Which key is holded down
        if (Gdx.input.isKeyPressed(K.up())) { //W

            //Move up
            player.getTransform().applyPosition(new Vector2(0, currentMovementSpeed * C.cGT()));

        } else if (Gdx.input.isKeyPressed(K.down())) { //S

            //Move down
            player.getTransform().applyPosition(new Vector2(0, -currentMovementSpeed * C.cGT()));

        }

        if (Gdx.input.isKeyPressed(K.left())) { //A

            //Move left
            player.getTransform().applyPosition(new Vector2(-currentMovementSpeed * C.cGT(), 0));

        } else if (Gdx.input.isKeyPressed(K.right())) { //D

            //Move right
            player.getTransform().applyPosition(new Vector2(currentMovementSpeed * C.cGT(), 0));
        }
    }

    public void updateAttack() {

        //Check if the mouse button is being pressed
        if (Gdx.input.isButtonPressed(K.attack()) && TimeUtils.millis() >= next) {

            //Now we have to wait before we can fire again
            updateTime();

            //Clone the transform of the player
            Transform projectileTransform = player.getTransform().clone();

            //Manipulate the transform
            projectileTransform.setMovementAngle((float)Math.toRadians(projectileTransform.getRotation()));

            //Create projectile using the projectilefactory
            player.getProjectileFactory().createPlayerProjectile(projectileTransform);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Update interaction methods
        updateMovement();
        updateAttack();

        //Look at cursor
        player.getTransform().setRotation(
                C.getAngleInDegrees(
                        player.getTransform().getPositionCenter(),
                        M.p()
                )
        );

        //Draw player sprite
        Transform.draw(batch, A.m.get(A.playerIdle), player.getTransform());
    }

    @Override
    public void onCollision(Collidable other) {

        //Die
        Main main = player.getGame().getMain();
        main.setScreen(new StartMenu(main));
    }
}
