package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class BombJunk extends JunkPackage {

    public BombJunk(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new BombRollingJunk(transform.clone(),context,A.m.get(A.pickupSpark)));
    }
}
