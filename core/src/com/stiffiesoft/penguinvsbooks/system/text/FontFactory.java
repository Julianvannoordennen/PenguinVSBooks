package com.stiffiesoft.penguinvsbooks.system.text;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;

public class FontFactory {

    private BitmapFont font;

    public FontFactory() {
        font = A.m.get(A.defaultFont);
        font.getData().setScale(C.pH() / 100,C.pH() / 100);
    }

    public BitmapFont createFont() {
        return font;
    }

    public GlyphLayout createGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.SECONDARY,C.sW(),Align.center,true);
        return layout;
    }

    public GlyphLayout createCounterGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.PRIMARY,C.pW() * 20,Align.center,true);
        return layout;
    }

    public GlyphLayout createScoreGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.SECONDARY,C.pW() * 80,Align.center,true);
        return layout;
    }

    public GlyphLayout createNotificationGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.SECONDARY,C.pW() * 30,Align.center,true);
        return layout;
    }
}
