package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.clover;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class CloverJunkPackage  extends JunkPackage {

    public CloverJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        for (int a = 0; a < MathUtils.random(75,100); a++) {
            Transform transform = this.transform.clone();
            transform.setRotation(MathUtils.random(0,359));
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.cloverJunk)));
        }
    }
}
