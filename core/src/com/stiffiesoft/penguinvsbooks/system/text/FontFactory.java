package com.stiffiesoft.penguinvsbooks.system.text;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class FontFactory {

    private BitmapFont fontNormal;
    private BitmapFont fontSmall;

    public FontFactory() {
        fontNormal = A.m.get(A.defaultFont);
        fontNormal.getData().setScale(1f,1f);
        fontSmall = A.m.get(A.defaultFont);
        fontSmall.getData().setScale(0.3f,0.3f);
    }

    public BitmapFont createNormalFont() {
        return fontNormal;
    }

    public BitmapFont createSmallFont() {
        return fontSmall;
    }

    public GlyphLayout createGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.SECONDARY,C.sW(),Align.center,true);
        return layout;
    }

    public GlyphLayout createCounterGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,DefinedColors.PRIMARY,C.pW() * 10,Align.center,true);
        return layout;
    }
}
