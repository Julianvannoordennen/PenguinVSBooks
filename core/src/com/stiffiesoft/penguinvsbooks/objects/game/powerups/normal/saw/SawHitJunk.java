package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.saw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FadingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class SawHitJunk extends FadingJunk {

    public SawHitJunk(Transform transform, GameContext context) {
        super(transform, context, A.m.get(A.pickupSpark));
        transform.setScale(new Vector2(C.pH(), C.pH()));
        currentFadeAmount = 0.75f;
        defaultColor = new Color(0.75f,0,0,0);
    }
}
