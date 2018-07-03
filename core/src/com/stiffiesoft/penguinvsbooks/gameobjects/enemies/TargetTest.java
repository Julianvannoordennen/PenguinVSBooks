package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.*;

public class TargetTest implements Transformable, Renderable {

    private Texture texture;

    public TargetTest() {
        texture = A.m.get(A.playButton);
        EnemyTargetSystem.registerTarget(this);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture,M.x(), M.iY(), 25f, 25f);
    }

    @Override
    public Transform getTransform() {
        return new Transform(M.x(), M.iY(),1,1,0.2f,0.2f,0);
    }
}
