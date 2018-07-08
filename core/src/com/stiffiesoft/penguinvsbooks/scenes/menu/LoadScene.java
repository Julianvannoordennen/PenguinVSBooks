package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class LoadScene implements Screen {

    private Main main;
    private BitmapFont font;

    public LoadScene(Main main) {

        //Save main
        this.main = main;

        //Load font manually
        font = new BitmapFont(Gdx.files.internal("fonts/default.fnt"));
        font.getData().setScale(0.75f,0.75f);
    }

    @Override
    public void show() {

        //Load assets
        A.load();
    }

    @Override
    public void render(float delta) {

        //Clear screen
        Gdx.gl.glClearColor(0,0,0,255);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render textures
        main.getBatch().begin();

        //Show loading percentage
        GlyphLayout layout = new GlyphLayout(font,Math.round(A.m.getProgress() * 100) + "%",new Color(0.82f, 0, 0, 1),C.sW(),Align.center,true);
        font.draw(main.getBatch(), layout, 0, (C.sH() / 2) + (layout.height / 2));

        //Done loading?
        if (A.m.update()) {

            //Load other stuff
            main.createAfterAssetLoading();
        }

        //End
        main.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
