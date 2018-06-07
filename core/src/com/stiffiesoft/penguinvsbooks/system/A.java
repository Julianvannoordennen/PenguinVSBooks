package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

//Asset manager
public class A {

    public static final AssetManager manager = new AssetManager();

    public static final String defaultBookEnemyAtlas = "sprites/game/enemies/defaultBookEnemy/default_book_enemy.atlas";

    //Load all assets
    public static void load() {
        manager.load(defaultBookEnemyAtlas, TextureAtlas.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}
