package com.stiffiesoft.penguinvsbooks.gameobjects.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuButton {

    private Texture texture;
    private float width;
    private float height;
    private float x;
    private float y;

    public MenuButton(String image, float width, float height, float x, float y) {
        this.texture = new Texture(image);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public MenuButton(String image, float size, float x, float y) {
        this(image,size, size, x, y);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }
}
