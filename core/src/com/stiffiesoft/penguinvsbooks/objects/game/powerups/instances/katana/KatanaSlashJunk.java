package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class KatanaSlashJunk extends FlyingJunk {

    public KatanaSlashJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        transform.setCenter(new Vector2(0,0));
        transform.setRotation(MathUtils.random(0,359));
        speed = 0;
    }

    //Ignore speed changes
    @Override
    public void setSpeed(float speed) {

    }
}
