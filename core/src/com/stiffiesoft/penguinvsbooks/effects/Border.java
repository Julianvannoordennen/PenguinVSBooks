package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.C;

public class Border {

    private Sprite sideTop;
    private Sprite sideLeft;
    private Sprite sideBottom;
    private Sprite sideRight;

    public Border() {

        //Create textures
        Texture screen = new Texture("effects/border_screen.png");

        //Define size
        float size = C.pH() * 10;

        //Create sides
        sideTop = new Sprite(screen);
        sideLeft = new Sprite(screen);
        sideBottom = new Sprite(screen);
        sideRight = new Sprite(screen);

        //Transform sides
        sideBottom.setSize(C.sW(), size);
        sideBottom.setOrigin(sideBottom.getWidth() / 2, sideBottom.getHeight() / 2);

        sideTop.setSize(C.sW(), size);
        sideTop.setOrigin(sideTop.getWidth() / 2, sideTop.getHeight() / 2);
        sideTop.setRotation(180);
        sideTop.setPosition(0, C.sH() - size);

        sideLeft.setSize(C.sH(), size);
        sideLeft.setOrigin(sideLeft.getWidth() / 2, sideLeft.getHeight() / 2);
        sideLeft.setRotation(270);
        sideLeft.setPosition((-sideLeft.getWidth() / 2) + (size / 2),(C.sH() / 2) - (size / 2));

        sideRight.setSize(C.sH(), size);
        sideRight.setOrigin(sideRight.getWidth() / 2, sideRight.getHeight() / 2);
        sideRight.setRotation(90);
        sideRight.setPosition(C.sW() - ((sideRight.getWidth() / 2) + (size / 2)),(C.sH() / 2) - (size / 2));
    }

    public void render(SpriteBatch batch) {

        //Draw
        sideTop.draw(batch);
        sideBottom.draw(batch);
        sideLeft.draw(batch);
        sideRight.draw(batch);
    }
}
