package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.system.A;
import com.stiffiesoft.penguinvsbooks.system.C;

public class Game extends BaseScene {

    private SpriteAnimation bookEnemy;

    public Game(Main main) {
        super(main);

        bookEnemy = new SpriteAnimation(A.manager.get(A.defaultBookEnemyAtlas, TextureAtlas.class),30, C.pH() * 5, C.pH() * 5);

    }

    @Override
    protected void onRender(SpriteBatch batch) {
        //for (int x = 0; x <= C.sW(); x += C.pH() * 5) {
            //for (int y = 0; y <= C.sH(); y += C.pH() * 5) {
                bookEnemy.render(batch, 16, 16);
            //}
        //}
    }

    @Override
    protected void onDispose() {
    }
}
