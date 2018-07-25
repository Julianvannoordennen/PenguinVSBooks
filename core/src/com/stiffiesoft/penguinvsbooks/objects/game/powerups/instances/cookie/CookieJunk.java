package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie;

import com.badlogic.gdx.math.MathUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.FlyingJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.LyingJunk;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class CookieJunk extends JunkPackage {

    public CookieJunk(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    protected void loadJunk() {

        //To avoid junk spam, this junk does not appear always
        if (MathUtils.random(0,5) != 0) return;

            //Add junk parts
            junk.add(new LyingJunk(transform.clone(),context,A.m.get(A.cookieJunk1)));
            junk.add(new LyingJunk(transform.clone(),context,A.m.get(A.cookieJunk2)));
    }
}