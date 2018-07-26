package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class KatanaSparkJunk extends FlyingJunk {

    public KatanaSparkJunk(Transform transform, GameContext context, Texture texture) {
        super(transform, context, texture);
        transform.setSize(new Vector2(C.pW() * 20, C.pW() * 20));
        transform.setCenter(new Vector2(0,0));
        speed               = 0;
        fadeSpeed           = 2;
        currentFadeAmount   = 0.25f;
    }

    //Ignore speed changes
    @Override
    public void setSpeed(float speed) {

    }
}
