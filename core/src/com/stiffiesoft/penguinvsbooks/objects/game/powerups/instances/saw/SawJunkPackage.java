package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class SawJunkPackage  extends JunkPackage {

    public SawJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Create a random amount of junk parts
        for (int current = 0; current < MathUtils.random(10,20); current++)
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.sawJunk1)));
        for (int current = 0; current < MathUtils.random(10,20); current++)
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.sawJunk2)));
    }
}