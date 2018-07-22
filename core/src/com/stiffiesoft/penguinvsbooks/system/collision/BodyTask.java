package com.stiffiesoft.penguinvsbooks.system.collision;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class BodyTask {

    protected Collidable collidable;

    public BodyTask (Collidable collidable) {
        this.collidable = collidable;
    }

    protected abstract Body createBody(World world);

    public void execute(World world) {
        collidable.setBody(createBody(world));
    }
}
