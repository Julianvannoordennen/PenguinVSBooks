package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class GameObjectList {

    private ArrayList<GameObject> gameObjects;

    public GameObjectList() {
        gameObjects = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void update() {
        for(GameObject gameObject : gameObjects)
            gameObject.update();
    }

    public void render(SpriteBatch batch) {
        for(GameObject gameObject : gameObjects)
            gameObject.render(batch);
    }
}
