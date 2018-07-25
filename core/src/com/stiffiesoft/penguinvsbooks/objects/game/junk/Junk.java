package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public abstract class Junk implements Transformable, Renderable {

    protected Transform transform;
    protected JunkList junkList;
    protected Texture texture;
    protected float speed;

    public Junk(Transform transform, GameContext context, Texture texture) {
        this.transform  = transform;
        this.junkList   = context.getJunkList();
        this.texture    = texture;
        this.speed      = 1;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Move forward
        transform.moveInDirection(speed * C.cGT());
    }
}