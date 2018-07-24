package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;

import java.util.ArrayList;
import java.util.Iterator;

public class JunkList implements Renderable {

    private ArrayList<Junk> junkList;
    private ArrayList<Junk> disposableJunkList;

    public JunkList() {
        junkList = new ArrayList<>();
        disposableJunkList = new ArrayList<>();
    }

    public void add(Junk junk) {
        junkList.add(junk);
    }

    public void render(SpriteBatch batch) {
        for(Junk junk : junkList)
            junk.render(batch);
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
            iterator.remove();
        }
    }
}
