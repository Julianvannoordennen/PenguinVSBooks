package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

public class FontFactory {

    private BitmapFont fontNormal;
    private BitmapFont fontSmall;

    public FontFactory() {
        fontNormal = new BitmapFont(Gdx.files.internal("fonts/default.fnt"));
        fontNormal.getData().setScale(0.3f,0.3f);
        fontSmall = new BitmapFont(Gdx.files.internal("fonts/default.fnt"));
        fontSmall.getData().setScale(0.1f,0.1f);
    }

    public BitmapFont createNormalFont() {
        return fontNormal;
    }

    public BitmapFont createSmallFont() {
        return fontSmall;
    }

    public GlyphLayout createGlyph(String text, BitmapFont font) {

        GlyphLayout layout = new GlyphLayout(font,text,new Color(0.67f, 0.67f, 0.67f, 1),C.sW(),Align.center,true);
        return layout;
    }
}
