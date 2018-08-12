package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;

public class Counter implements Renderable {

    protected int value;
    protected BitmapFont font;
    protected FontFactory fontFactory;
    protected float shakeIntensity;
    protected float shakeReturn;
    protected float shakeCurrent;
    private float shakeLimit;

    public Counter(GameContext context, int value) {
        this.value          = value;
        this.fontFactory    = context.getFontFactory();
        this.font           = fontFactory.createSmallFont();
        this.shakeIntensity = 25;
        this.shakeCurrent   = 0;
        this.shakeLimit     = C.pH() * 7.5f;
        this.shakeReturn    = C.pH() * 50;
    }

    public Counter(GameContext context) {
        this(context,0);
    }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
        shake();
    }

    public void apply(int value) {
        this.value += value;
        shake();
    }

    private void shake() {
        shakeCurrent += shakeIntensity;
        if (shakeCurrent > shakeLimit)
            shakeCurrent = shakeLimit;
    }

    protected void returnShake() {
        shakeCurrent -= (shakeCurrent > 0) ? shakeReturn * C.cGT() : 0;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Return shake
        returnShake();

        //Draw the text including the score
        font.draw(batch, value + "", C.pW() * 5, (C.sH() + (C.pW() * -5)) + shakeCurrent);
    }

    public void dispose() {

        //Dispose
        font.dispose();
    }
}
