package com.stiffiesoft.penguinvsbooks.system.rendering;

import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;

import java.util.Comparator;

public class DepthComparator implements Comparator<GameObject> {

    @Override
    public int compare(GameObject o1, GameObject o2) {
        return o1.getDepth() - o2.getDepth();
    }
}
