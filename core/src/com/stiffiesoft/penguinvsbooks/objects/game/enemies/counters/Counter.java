package com.stiffiesoft.penguinvsbooks.objects.game.enemies.counters;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

import java.awt.*;

public class Counter implements Renderable {

    protected int value;
    protected BitmapFont font;
    protected FontFactory fontFactory;
    protected float shakeIntensity;
    protected float shakeReturn;
    protected float shakeCurrent;
    private float shakeLimit;

    public Counter(FontFactory fontFactory, int value) {
        this.value          = value;
        this.font           = fontFactory.createSmallFont();
        this.fontFactory    = fontFactory;
        this.shakeIntensity = 25;
        this.shakeCurrent   = 0;
        this.shakeLimit     = 75;
        this.shakeReturn    = 500;
    }

    public Counter(FontFactory fontFactory) {
        this(fontFactory,0);
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
