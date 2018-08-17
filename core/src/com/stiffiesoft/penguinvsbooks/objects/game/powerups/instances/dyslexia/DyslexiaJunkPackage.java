package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class DyslexiaJunkPackage  extends JunkPackage {

    public DyslexiaJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Create a random amount of junk parts
        for (int current = 0; current < MathUtils.random(10,25); current++)
            junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.dyslexiaJunk)));
    }
}