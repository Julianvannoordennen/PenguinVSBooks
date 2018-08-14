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
    protected Color defaultColor;

    public FlyingJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        fadeSpeed           = 1;
        currentFadeAmount   = 1f;
        defaultColor        = new Color(1,1,1,0);
    }

    public void setFadeSpeed(float fadeSpeed) {
        this.fadeSpeed = fadeSpeed;
    }

    @Override
    public void update() {

        //Update super
        super.update();

        //Fade
        this.currentFadeAmount -= this.fadeSpeed * C.cGT();

        //Check if the shock has to fade away
        if (this.currentFadeAmount <= 0.01f)

            //Destroy shock
            junkList.destroy(this);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(defaultColor.r, defaultColor.g, defaultColor.b, this.currentFadeAmount));

        //Draw texture
        Transform.draw(batch, texture, transform);

        //Restore color
        batch.setColor(color);
    }
}
