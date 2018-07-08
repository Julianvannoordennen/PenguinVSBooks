package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.calculations.M;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class PlayerStateMoving implements PlayerState {

    private Player player;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;

    public PlayerStateMoving(Player player) {

        //We can see the player as the context for this state
        this.player = player;

        //Apply speed to the player
        defaultMovementSpeed = 200;
        currentMovementSpeed = defaultMovementSpeed;
    }

    public void updateMovement() {

        //Which key is holded down
        if (Gdx.input.isKeyPressed(51)) { //W

            //Move up
            player.getTransform().applyPosition(new Vector2(0, currentMovementSpeed * C.cGT()));

        } else if (Gdx.input.isKeyPressed(47)) { //S

            //Move down
            player.getTransform().applyPosition(new Vector2(0, -currentMovementSpeed * C.cGT()));

        }

        if (Gdx.input.isKeyPressed(29)) { //A

            //Move left
            player.getTransform().applyPosition(new Vector2(-currentMovementSpeed * C.cGT(), 0));

        } else if (Gdx.input.isKeyPressed(32)) { //D

            //Move right
            player.getTransform().applyPosition(new Vector2(currentMovementSpeed * C.cGT(), 0));
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Check movement keys
        updateMovement();

        //Look at cursor
        player.getTransform().setRotation(-C.getAngleInDegrees(player.getTransform().getPositionCenter(), M.p()));

        //Draw player sprite
        Transform.draw(batch, A.m.get(A.playerIdle), player.getTransform());
    }
}
