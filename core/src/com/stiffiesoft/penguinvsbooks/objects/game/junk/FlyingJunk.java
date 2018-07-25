package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class FlyingJunk extends Junk {

    protected float fadeSpeed;
    protected float currentFadeAmount;

    public FlyingJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        fadeSpeed = 1;
        currentFadeAmount = 1f;
    }

    public void setFadeSpeed(float fadeSpeed) {
        this.fadeSpeed = fadeSpeed;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Move forward
        super.render(batch);

        //Get default color
        Color color = batch.getColor();

        //Change color
        this.currentFadeAmount -= this.fadeSpeed * C.cGT();
        batch.setColor(new Color(color.r, color.g, color.b, this.currentFadeAmount));

        //Draw texture
        Transform.draw(batch, texture, transform);

        //Restore color
        batch.setColor(color);

        //Check if the shock has to fade away
        if (this.currentFadeAmount <= 0.01f)

            //Destroy shock
            junkList.destroy(this);
    }
}
