package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class GameObjectList {

    //Added queue to prevent ConcurrentModificationException
    private ArrayList<GameObject> queuedGameObjects;
    private ArrayList<GameObject> gameObjects;

    public GameObjectList() {
        gameObjects = new ArrayList<>();
        queuedGameObjects = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        queuedGameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public void update() {
        for(GameObject gameObject : gameObjects)
            gameObject.update();
    }

    public void render(SpriteBatch batch) {
        for(GameObject gameObject : gameObjects)
            gameObject.render(batch);

        processQueue();
    }

    private void processQueue() {

        //Insert all the gameobjects inside the queue to the normal list
        gameObjects.addAll(queuedGameObjects);
        queuedGameObjects.clear();
    }
}
