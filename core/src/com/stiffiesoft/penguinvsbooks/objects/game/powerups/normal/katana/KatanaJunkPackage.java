package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.katana;

import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class KatanaJunkPackage extends JunkPackage {

    public KatanaJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new KatanaSlashJunk(transform.clone(),context,A.m.get(A.pickupSpark)));
//        junk.add(new KatanaSparkJunk(transform.clone(),context,A.m.getArray(A.pickupSpark)));
    }
}
