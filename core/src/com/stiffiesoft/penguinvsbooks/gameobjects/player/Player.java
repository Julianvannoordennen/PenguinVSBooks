package com.stiffiesoft.penguinvsbooks.gameobjects.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.Renderable;
import com.stiffiesoft.penguinvsbooks.system.Transform;
import com.stiffiesoft.penguinvsbooks.system.Transformable;

public class Player implements Transformable, Renderable {

    private PlayerState state;
    private Transform transform;

    public Player() {

        //Position player in the center of the screen
        transform = new Transform(C.sW() / 2,C.sH() / 2,C.pH() * 5, C.pH() * 5,1,1,0);

        //Register the player as a enemy target
        EnemyTargetSystem.registerTarget(this);

        //Set start state
        state = new PlayerStateMoving(this);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Update state if it exists
        if (state != null) state.render(batch);
    }
}
