package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances.DefaultBookEnemyJunk;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePowerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.ArrayList;

public class JunkFactory {

    private JunkList junkList;

    public JunkFactory() {
        this.junkList = new JunkList();
    }

    public JunkList getJunkList() {
        return junkList;
    }

    private void extractJunk(ArrayList<Junk> junk) {

        //For each junk part
        for (Junk junkPart : junk) {

            //Randomize junk
            junkPart.setSpeed(MathUtils.random(350f,500f));
            junkPart.getTransform().setRotation(MathUtils.random(0,359));
            junkPart.getTransform().setMovementAngle(MathUtils.random(0,359));

            //Check what kind of junk it is
            String className = junkPart.getClass().getSimpleName();
            if (className.equals("LyingJunk")) {

                //Randomize junk
                LyingJunk lyingJunk = (LyingJunk)junkPart;
                lyingJunk.setDecreaseSpeed(MathUtils.random(450f, 550f));
                lyingJunk.setFadeDelay(MathUtils.random(250, 1000));

            } else if (className.equals("FlyingJunk")) {

                //Randomize junk
                FlyingJunk flyingJunk = (FlyingJunk)junkPart;
                flyingJunk.setFadeSpeed(MathUtils.random(1.5f, 2.5f));
            }

            //Add junk to the junklist
            junkList.add(junkPart);
        }
    }

    /***** Create methods *****/
    public JunkPackage createDefaultEnemyDyingJunk(Transform transform) {

        //Create junk package
        transform.setSize(new Vector2(C.pH() * 3.5f, C.pH() * 3.5f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new DefaultBookEnemyJunk(transform, junkList);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
}
