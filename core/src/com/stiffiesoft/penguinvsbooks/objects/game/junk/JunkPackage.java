package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

import java.util.ArrayList;

public abstract class JunkPackage {

    protected ArrayList<Junk> junk;
    protected Transform transform;
    protected JunkList junkList;
    protected GameContext context;

    public JunkPackage(Transform transform, GameContext context) {
        this.junk       = new ArrayList<>();
        this.transform  = transform;
        this.junkList   = context.getJunkList();
        this.context    = context;
        loadJunk();
    }

    public ArrayList<Junk> getJunk() {
        return junk;
    }

    protected abstract void loadJunk();
}
