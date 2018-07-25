package com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkList;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

import static com.stiffiesoft.penguinvsbooks.system.assets.A.defaultBookEnemyJunk1;
import static com.stiffiesoft.penguinvsbooks.system.assets.A.defaultBookEnemyJunk2;

public class DefaultBookEnemyJunk extends JunkPackage {

    public DefaultBookEnemyJunk(Transform transform, JunkList junkList) {
        super(transform, junkList);
    }

    @Override
    protected void loadJunk() {

        //Load all junk parts that will appear
        junk.add(new LyingJunk(transform.clone(),junkList,A.m.get(defaultBookEnemyJunk1)));

        //Randomize some different junk parts
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),junkList,A.m.get(defaultBookEnemyJunk1)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),junkList,A.m.get(defaultBookEnemyJunk2)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),junkList,A.m.get(defaultBookEnemyJunk2)));
        if (MathUtils.randomBoolean()) junk.add(new FlyingJunk(transform.clone(),junkList,A.m.get(defaultBookEnemyJunk2)));
    }
}
