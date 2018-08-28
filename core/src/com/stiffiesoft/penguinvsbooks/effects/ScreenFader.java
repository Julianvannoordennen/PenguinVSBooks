package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class ScreenFader implements GameObject {

    private Sprite layer;
    private Color color;
    private float fadeSpeed;
    private float currentFade;
    private float targetIntensity;
    private boolean changingIntensity;

    public ScreenFader() {

        //Load screen fader layer
        this.layer              = new Sprite(A.m.get(A.screenFader));

        //Set color to null
        this.color              = null;
        this.fadeSpeed          = 2;
        this.changingIntensity  = false;
    }

    public void fade(Color color, float intensityFrom, float intensityTo) {
        this.color              = color;
        this.currentFade        = intensityFrom;
        this.targetIntensity    = intensityTo;
        this.changingIntensity  = true;
    }

    public boolean isFading() {
        return changingIntensity;
    }

    @Override
    public void update() {

        //Check if there is a fade going on
        if (color != null && changingIntensity) {

            if (targetIntensity > currentFade) {

                currentFade += fadeSpeed * C.cGT();
                if (currentFade >= targetIntensity) {

                    currentFade = targetIntensity;
                    changingIntensity = false;
                }

            } else {

                currentFade -= fadeSpeed * C.cGT();
                if (currentFade <= targetIntensity) {

                    currentFade = targetIntensity;
                    changingIntensity = false;
                }
            }

            //Change intensity from the color
            color = new Color(this.color.r, this.color.g, this.color.b, currentFade);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Check if there is a flash going on
        if (color != null) {

            //Get default color
            Color color = batch.getColor();

            //Change color
            batch.setColor(this.color);

            //Draw current layer
            batch.draw(layer, 0, 0, C.sW(), C.sH());

            //Restore color
            batch.setColor(color);
        }
    }

    @Override
    public int getDepth() {
        return DepthProfiles.SCREEN_FADER;
    }
}
