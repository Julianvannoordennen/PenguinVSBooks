package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FadingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class SawHitJunkPackage extends JunkPackage {

    public SawHitJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Add junk parts
        junk.add(new SawHitJunk(transform.clone(), context));

        //Create a random amount of junk parts
        for (int current = 0; current < MathUtils.random(5,10); current++)
            junk.add(new SawHitSparkJunk(transform.clone(), context));
    }
}