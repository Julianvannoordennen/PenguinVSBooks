package com.stiffiesoft.penguinvsbooks.gameobjects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.M;

public class MenuButton {

    private Texture texture;
    private float width;
    private float height;
    private float x;
    private float y;
    private MenuButtonListener listener;
    private int id;

    private boolean hovering = false;

    public MenuButton(int id, String image, float width, float height, float x, float y, MenuButtonListener listener) {
        this.texture = new Texture(image);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.listener = listener;
        this.id = id;
    }

    public MenuButton(int id, String image, float size, float x, float y, MenuButtonListener listener) {
        this(id, image,size, size, x, y, listener);
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

    public MenuButtonListener getListener() {
        return listener;
    }

    public void setListener(MenuButtonListener listener) {
        this.hovering = false;
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void draw(SpriteBatch batch) {

        //Check if hovering
        if (M.x() >= x && M.x() <= x + width && M.iY() >= y && M.iY() <= y + height) {

            //Check not null
            if (listener != null) {

                //Check if already hovering
                if (!hovering) {

                    //Event
                    listener.onHoverIn(this);
                    hovering = true;
                }

                //Check if pressing
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) listener.onPress(this);
            }

            //Get default color
            Color color = batch.getColor();

            //Change color
            batch.setColor(Color.RED);


            //Draw image
            batch.draw(texture,x,y,width,height);

            //Change color
            batch.setColor(color);

        } else {

            //Check if we need to hover out
            if (hovering && listener != null) {

                //Event
                listener.onHoverOut(this);
                hovering = false;
            }

            //Draw image
            batch.draw(texture,x,y,width,height);
        }
    }
}
