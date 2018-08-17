package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances.DefaultBookEnemyJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia.DyslexiaJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret.PlasmaTurretJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret.PlasmaTurretProjectileJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterJunkPackage;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ExplosionJunkPackage;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.ArrayList;

public class JunkFactory {

    private JunkList junkList;
    private GameContext context;

    public JunkFactory(GameContext context) {
        this.junkList   = context.getJunkList();
        this.context    = context;
    }

    private void extractJunk(ArrayList<Junk> junk) {

        //For each junk part
        for (Junk junkPart : junk) {

            //Randomize junk
            junkPart.setSpeed(MathUtils.random(C.pH() * 35,C.pH() * 50));
            junkPart.getTransform().setRotation(MathUtils.random(0,359));
            junkPart.getTransform().setMovementAngle(MathUtils.random(0,359));

            //Check what kind of junk it is
            String className = junkPart.getClass().getSimpleName();
            if (className.equals("LyingJunk")) {

                //Randomize junk
                LyingJunk lyingJunk = (LyingJunk)junkPart;
                lyingJunk.setDecreaseSpeed(MathUtils.random(C.pH() * 45, C.pH() * 55));
                lyingJunk.setFadeDelay(MathUtils.random(250, 1000));

            } else if (className.equals("FlyingJunk")) {

                //Randomize junk
                FlyingJunk flyingJunk = (FlyingJunk)junkPart;
                flyingJunk.setFadeSpeed(MathUtils.random(C.pH() * 0.15f, C.pH() * 0.25f));
            }

            //Add junk to the junklist
            junkList.add(junkPart);
        }
    }

    /***** Create methods *****/
    public JunkPackage createDefaultEnemyDyingJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 3.5f, C.pH() * 3.5f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new DefaultBookEnemyJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createDefaultExplosionDust(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 16f, C.pH() * 16f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new ExplosionJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createCookieJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new CookieJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createTeleporterJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new TeleporterJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createRollingBombJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new BombJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createKatanaJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 20f, C.pH() * 1f));
        JunkPackage junk = new KatanaJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createPlasmaTurretProjectileJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new PlasmaTurretProjectileJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createPlasmaTurretJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new PlasmaTurretJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
    public JunkPackage createDyslexiaJunk(Transform transform) {

        //Create junk package
        transform = transform.clone();
        transform.setSize(new Vector2(C.pH() * 2f, C.pH() * 2f));
        transform.setScale(new Vector2(1,1));
        JunkPackage junk = new DyslexiaJunkPackage(transform, context);

        //Apply default actions on the junk
        extractJunk(junk.getJunk());

        //Return junk
        return junk;
    }
}
