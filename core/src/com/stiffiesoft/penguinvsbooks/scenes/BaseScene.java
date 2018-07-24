package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.Border;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;

public abstract class BaseScene implements Screen {

    protected Main main;
    private SpriteBatch batch;
    private Border border;
    protected ScreenFlasher screenFlasher;

    public BaseScene(Main main) {

        //Load default scene items
        this.main               = main;
        this.batch              = main.getBatch();
        this.border             = new Border();
        this.screenFlasher      = new ScreenFlasher();
    }

    @Override
    public void show() {
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
        border.render(batch);
        screenFlasher.render(batch);

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

    public ScreenFlasher getScreenFlasher() {
        return screenFlasher;
    }

    //Abstract methods
    protected abstract void onRender(SpriteBatch batch);
    protected abstract void onDispose();
}
