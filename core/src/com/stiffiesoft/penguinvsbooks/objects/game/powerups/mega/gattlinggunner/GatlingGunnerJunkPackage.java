package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FallingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class GatlingGunnerJunkPackage extends JunkPackage {

    public GatlingGunnerJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Randomize some different junk parts
        for (float x = C.pW() * -10; x < C.sW() * 1.1f; x += C.sW() / 10) {
            for (float y = C.pH() * -10; y < C.sH() * 1.1f; y += C.sH() / 10) {

                //Create transform
                Transform transform = new Transform(x,y,C.pH() * 20, C.pH() * 20,1,1,MathUtils.random(0,359));
                junk.add(new FallingJunk(transform.clone(),context, A.m.get(A.gatlingGunnerJunk)));
            }
        }
    }
}
