package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class LyingJunk extends Junk {

    protected float decreaseSpeed;
    protected long fadeDelay;
    protected long fadeWait;
    protected float fadeSpeed;
    protected float currentFadeAmount;
    protected boolean fade;

    public LyingJunk(Transform transform, JunkList junkList, Texture texture) {
        super(transform, junkList, texture);
        currentFadeAmount = 1;
        decreaseSpeed = 1;
        fadeSpeed = 1;
        fadeDelay = 3000;
        fadeWait = 0;
        fade = false;
    }

    public void setFadeDelay(long fadeDelay) {
        this.fadeDelay = fadeDelay;
    }

    public void setDecreaseSpeed(float decreaseSpeed) {
        this.decreaseSpeed = decreaseSpeed;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Is junk still moving
        if (speed >= 0.01f) {

            //Decrease speed
            speed -= decreaseSpeed * C.cGT();

        } else if (!fade) {

            //Disable speed
            speed = 0;

            //Start junk disappearing
            fade = true;
            fadeWait = TimeUtils.millis() + fadeDelay;
        }

        //Does the junk need to fade away?
        if (TimeUtils.millis() > fadeWait && fade) {

            //Get default color
            Color color = batch.getColor();

            //Change color
            this.currentFadeAmount -= this.fadeSpeed * C.cGT();
            batch.setColor(new Color(color.r, color.g, color.b, this.currentFadeAmount));

            //Draw texture
            Transform.draw(batch, texture, transform);

            //Restore color
            batch.setColor(color);

            //Check if the junk has to fade away
            if (this.currentFadeAmount <= 0.01f) {

                //Destroy
                junkList.destroy(this);
            }

        } else {

            //Draw texture
            Transform.draw(batch, texture, transform);
        }

        //Move forward
        super.render(batch);
    }
}
