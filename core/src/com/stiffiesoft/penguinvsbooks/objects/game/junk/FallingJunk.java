package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class FallingJunk extends Junk {

    private float rotationSpeed;
    private float fallDegree;

    public FallingJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        speed           = C.pH() * 100;
        rotationSpeed   = MathUtils.random(-25, 25);
        fallDegree      = C.degreesToRadians(MathUtils.random(250, 290));
    }

    @Override
    public void setSpeed(float speed) {}

    @Override
    public void update() {

        //Rotate
        transform.setMovementAngle(fallDegree);
        transform.rotate(rotationSpeed * C.cGT());

        //Fall
        transform.moveInDirection(speed * C.cGT());
        speed *= 1.02f;

        //Check if the shock has to fade away
        if (transform.getYPosition() <= -(C.sH() / 2))

            //Destroy shock
            junkList.destroy(this);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw texture
        Transform.draw(batch, texture, transform);
    }

    @Override
    public int getDepth() {
        return DepthProfiles.JUNK_FOREGROUND;
    }
}
