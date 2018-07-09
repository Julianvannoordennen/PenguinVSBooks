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

    public Counter(FontFactory fontFactory, int value) {
        this.value          = value;
        this.font           = fontFactory.createSmallFont();
        this.fontFactory    = fontFactory;
        //this.fontGlyph  = fontFactory.createGlyph(,this.font);
    }

    public Counter(FontFactory fontFactory) {
        this(fontFactory,0);
    }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }

    public void apply(int value) {
        this.value += value;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, value + "", C.pW() * 5, C.sH() + (C.pW() * -5));
    }

    public void dispose() {

        //Dispose
        font.dispose();
    }
}
