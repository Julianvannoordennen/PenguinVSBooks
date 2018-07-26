package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class BombRollingJunk extends FlyingJunk {

    public BombRollingJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        transform.setPosition(new Vector2(transform.getXPosition() - (C.pW() * 1.5f), transform.getYPosition() - (C.pW() * 1)));
        transform.setScale(new Vector2(0.5f, 0.5f));
        fadeSpeed       = 5;
        defaultColor    = new Color(1,0.25f,0,0);
    }
}
