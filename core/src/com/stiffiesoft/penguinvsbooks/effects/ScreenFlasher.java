package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class ScreenFlasher implements Renderable {

    private Sprite layer;
    private Color color;
    private float decreaseSpeed;

    public ScreenFlasher() {

        //Load screen fader layer
        this.layer = new Sprite(A.m.get(A.screenFader));

        //Set color to null
        color = null;
        decreaseSpeed = 1;
    }

    public void flash(Color color) {
        this.color = color;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Check if there is a flash going on
        if (color != null) {

            //Get default color
            Color color = batch.getColor();

            //Change color
            this.color = new Color(this.color.r, this.color.g, this.color.b, this.color.a - (decreaseSpeed * C.cGT()));
            batch.setColor(this.color);

            //Draw current layer
            batch.draw(layer, 0, 0, C.sW(), C.sH());

            //Restore color
            batch.setColor(color);

            //Check if the alpha is below zero
            if (this.color.a <= 0) {

                //Clear color, flash is done
                color = null;
            }
        }
    }
}
