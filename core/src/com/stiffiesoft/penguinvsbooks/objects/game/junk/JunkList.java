package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObjectList;

import java.util.ArrayList;
import java.util.Iterator;

public class JunkList {

    private GameObjectList gameObjectList;
    private ArrayList<Junk> junkList;
    private ArrayList<Junk> disposableJunkList;

    public JunkList(GameContext context) {
        gameObjectList      = context.getGameObjectList();
        junkList            = new ArrayList<>();
        disposableJunkList  = new ArrayList<>();
    }

    public void add(Junk junk) {
        junkList.add(junk);
        gameObjectList.add(junk);
    }

    public ArrayList<Junk> get() {
        return junkList;
    }

    public void destroy(Junk junk) {

        //Place item in special dispose list
        disposableJunkList.add(junk);
    }

    public void dispose() {

        //Check each junk in the disposable list
        Iterator iterator = disposableJunkList.iterator();
        while(iterator.hasNext()) {

            //Get body
            Junk junk = (Junk)iterator.next();

            //Destroy object
            junkList.remove(junk);
            gameObjectList.remove(junk);
            iterator.remove();
        }
    }
}
