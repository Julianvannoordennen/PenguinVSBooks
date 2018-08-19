package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower;

import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class FlameThrowerJunkPackage  extends JunkPackage {

    public FlameThrowerJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.explosionDust)));
    }
}
