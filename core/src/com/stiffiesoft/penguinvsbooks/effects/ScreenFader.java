package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.C;

public class ScreenFader {

    private Sprite layer;

    private Color color;
    private float intensityTo;
    private float speed;
    private float currentIntensity;
    private boolean increase;
    private ScreenFaderListener listener;

    public ScreenFader() {

        //Load screen fader layer
        this.layer = new Sprite(new Texture("sprites/effects/screenfade.png"));

        //Initialize default variables
        reset();
    }

    public void fade(Color color, float intensityFrom, float intensityTo, float speed, ScreenFaderListener listener) {

        //Change default values
        this.color = color;
        this.currentIntensity = intensityFrom;
        this.intensityTo = intensityTo;
        this.speed = speed;
        this.increase = intensityFrom <= intensityTo;
        this.listener = listener;
    }

    public void draw(SpriteBatch batch) {

        if (color != null) {

            //Get default color
            Color color = batch.getColor();

            //Change color
            batch.setColor(new Color(this.color.r, this.color.g, this.color.b, currentIntensity));

            //Draw current layer
            batch.draw(layer, 0, 0, C.sW(), C.sH());

            //Restore color
            batch.setColor(color);

            //Increase current intensity
            this.currentIntensity += (this.increase ? speed : -speed) * C.cET();

            //Check if done
            if ((this.currentIntensity >= intensityTo && this.increase) || (this.currentIntensity <= intensityTo && !this.increase)) {

                //Set value
                this.currentIntensity = intensityTo;

                //Done
                if (listener != null)
                    listener.onFadeDone();

                //Reset
                reset();
            }
        }
    }

    private void reset() {

        //Set default values
        this.speed = 0;
        this.intensityTo = 0;
        this.increase = false;
        this.listener = null;
    }
}
