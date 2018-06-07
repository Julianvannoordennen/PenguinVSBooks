package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.stiffiesoft.penguinvsbooks.system.C;

public class SpriteAnimation {

    private TextureAtlas texture;
    private Animation animation;
    private float elapsedTime;
    private float width;
    private float height;

    public SpriteAnimation(TextureAtlas textureAtlas,float framesPerSecond, float width, float height) {

        //Load textureatlas
        texture = textureAtlas;

        //Create animation
        animation = new Animation(1f/framesPerSecond, texture.getRegions());

        //Set time and size
        elapsedTime = 0f;
        this.width = width;
        this.height = height;
    }

    public void render(SpriteBatch batch, float x, float y) {

        //Draw and increase time
        elapsedTime += C.cGT();
        batch.draw((TextureRegion)animation.getKeyFrame(elapsedTime,true),x,y,width, height);
    }
}
