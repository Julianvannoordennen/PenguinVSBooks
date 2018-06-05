package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;

public abstract class BaseScene implements Screen {

    protected Main main;
    private SpriteBatch batch;

    public BaseScene(Main main) {

        //Load default scene items
        this.main               = main;
        this.batch              = main.getBatch();
    }

    @Override
    public void show() {
        onShow();
    }

    @Override
    public void render(float delta) {

        //Clear screen
        Gdx.gl.glClearColor(0,0,0,255);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render textures
        batch.begin();

        //Render
        onRender(batch);

        //End
        batch.end();
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

        //Dispose
        batch.dispose();
        onDispose();
    }

    public Main getMain() {
        return main;
    }

    //Abstract methods
    protected abstract void onShow();
    protected abstract void onRender(SpriteBatch batch);
    protected abstract void onDispose();
}
