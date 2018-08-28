package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;

public class Counter implements GameObject {

    protected int value;
    protected BitmapFont font;
    protected FontFactory fontFactory;
    protected float shakeIntensity;
    protected float shakeReturn;
    protected float shakeCurrent;
    private float shakeLimit;
    protected int max;
    protected boolean blockMax;

    public Counter(GameContext context, int value) {
        this.value          = value;
        this.fontFactory    = context.getFontFactory();
        this.font           = fontFactory.createFont();
        this.shakeIntensity = 25;
        this.shakeCurrent   = 0;
        this.shakeLimit     = C.pH() * 7.5f;
        this.shakeReturn    = C.pH() * 50;
        this.blockMax       = false;
    }

    public Counter(GameContext context) {
        this(context,0);
    }

    public int get() {
        return value;
    }

    private void checkMax() {
        if (value > max && blockMax)
            value = max;
    }

    public void set(int value) {
        this.value = value;
        checkMax();
        shake();
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() { return max; }

    public void apply(int value) {
        this.value += value;
        checkMax();
        shake();
    }

    private void shake() {
        shakeCurrent += shakeIntensity;
        if (shakeCurrent > shakeLimit)
            shakeCurrent = shakeLimit;
    }

    private void returnShake() {
        shakeCurrent -= shakeReturn * C.cGT();
        if (shakeCurrent < 0)
            shakeCurrent = 0;
    }

    public void reset() {
        set(0);
    }

    @Override
    public void update() {

        //Return shake
        returnShake();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, value + "", C.pW() * 5, (C.sH() + (C.pW() * -5)) + shakeCurrent);
    }

    public void dispose() {

        //Dispose
        font.dispose();
    }

    @Override
    public int getDepth() {
        return DepthProfiles.COUNTERS;
    }
}
