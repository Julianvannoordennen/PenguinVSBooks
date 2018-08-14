package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb;

import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class BombJunkPackage extends JunkPackage {

    public BombJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new BombJunk(transform.clone(),context,A.m.get(A.pickupSpark)));
    }
}
