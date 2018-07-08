package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class DynamicRenderingList {

    private ArrayList<Renderable> renderables;

    public DynamicRenderingList() {
        renderables = new ArrayList<>();
    }

    public void add(Renderable renderable) {
        renderables.add(renderable);
    }

    public void render(SpriteBatch batch) {
        for(Renderable renderable : renderables)
            renderable.render(batch);
    }
}
