package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontFactory {

    //Standardize font
    public BitmapFont createDefault() {
        return new BitmapFont(Gdx.files.internal("fonts/default.fnt"));
    }
}
