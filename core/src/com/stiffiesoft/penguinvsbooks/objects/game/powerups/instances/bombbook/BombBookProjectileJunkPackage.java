package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw.SawHitJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw.SawHitSparkJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class BombBookProjectileJunkPackage  extends JunkPackage {

    public BombBookProjectileJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new SawHitJunk(transform.clone(), context));
    }
}