package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.Arrays;
import java.util.Collections;

public class SpriteAnimation {

    private TextureAtlas texture;
    private Animation animation;
    private Sprite sprite;
    private float elapsedTime;
    private float width;
    private float height;
    private float framesPerSecond;

    public SpriteAnimation(TextureAtlas textureAtlas, float framesPerSecond) {

        //Load textureatlas
        this.framesPerSecond    = framesPerSecond;
        this.texture            = textureAtlas;
        this.sprite             = new Sprite();

        //Create animation
        this.animation          = new Animation(1f/framesPerSecond, texture.getRegions());

        //Set time and size
        this.elapsedTime        = 0f;
    }

    public void reverse() {

        //Revert the regions array inside the animation
        Object[] frames = animation.getKeyFrames();
        Collections.reverse(Arrays.asList(frames));
        animation = new Animation(1f/framesPerSecond, frames);
    }

    public void update() {

        //Increase time
        elapsedTime += C.cGT();
    }

    public void render(SpriteBatch batch, Transform transform) {

        //Draw
        Transform.draw(batch, (TextureRegion)animation.getKeyFrame(elapsedTime,true), transform);
    }
}
