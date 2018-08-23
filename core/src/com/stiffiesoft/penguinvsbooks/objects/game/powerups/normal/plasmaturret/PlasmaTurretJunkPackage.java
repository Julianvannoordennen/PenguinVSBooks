package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class PlasmaTurretJunkPackage  extends JunkPackage {

    public PlasmaTurretJunkPackage(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Create the default junk
        junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk3)));
        junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk3)));
        junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk4)));

        //Create a random amount of junk parts
        for (int current = 0; current < MathUtils.random(6, 12); current++)
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk1)));

        for (int current = 0; current < MathUtils.random(6, 12); current++)
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk2)));

        for (int current = 0; current < MathUtils.random(6, 12); current++)
            junk.add(new LyingJunk(transform.clone(), context, A.m.get(A.plasmaTurretJunk5)));
    }
}
