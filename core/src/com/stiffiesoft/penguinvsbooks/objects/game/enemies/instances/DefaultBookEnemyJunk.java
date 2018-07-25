package com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkList;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class DefaultBookEnemyJunk extends JunkPackage {

    public DefaultBookEnemyJunk(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //Load all junk parts that will appear
        junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.defaultBookEnemyJunk1)));

        //Randomize some different junk parts
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.defaultBookEnemyJunk1)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.defaultBookEnemyJunk2)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.defaultBookEnemyJunk2)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),context,A.m.get(A.defaultBookEnemyJunk2)));
    }
}
