package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class SpriteAnimation {

    private TextureAtlas texture;
    private Animation animation;
    private Sprite sprite;
    private float elapsedTime;
    private float width;
    private float height;

    public SpriteAnimation(TextureAtlas textureAtlas,float framesPerSecond) {

        //Load textureatlas
        texture = textureAtlas;
        sprite = new Sprite();

        //Create animation
        animation = new Animation(1f/framesPerSecond, texture.getRegions());

        //Set time and size
        elapsedTime = 0f;
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
