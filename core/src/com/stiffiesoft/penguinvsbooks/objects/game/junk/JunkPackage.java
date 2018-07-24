package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public abstract class JunkPackage {

    protected ArrayList<Junk> junk;
    protected Transform transform;
    protected JunkList junkList;

    public JunkPackage(Transform transform, JunkList junkList) {
        junk = new ArrayList<>();
        this.transform = transform;
        this.junkList = junkList;
        loadJunk();
    }

    public ArrayList<Junk> getJunk() {
        return junk;
    }

    protected abstract void loadJunk();
}
