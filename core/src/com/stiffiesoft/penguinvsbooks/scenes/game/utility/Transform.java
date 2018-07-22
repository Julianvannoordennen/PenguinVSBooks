package com.stiffiesoft.penguinvsbooks.scenes.game.utility;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Transform implements Cloneable {

    private Vector2 position;
    private Vector2 size;
    private Vector2 scale;
    private Vector2 center;
    private float rotation;
    private float movementAngle;

    public Transform(float xPosition, float yPosition, float width, float height, float xScale, float yScale, float rotation, float xCenter, float yCenter) {
        this.position = new Vector2(xPosition, yPosition);
        this.size = new Vector2(width, height);
        this.scale = new Vector2(xScale, yScale);
        this.center = new Vector2(xCenter, yCenter);
        this.rotation = rotation;
        this.movementAngle = 0;
    }

    public Transform(float xPosition, float yPosition, float width, float height, float xScale, float yScale, float rotation) {
        this(xPosition, yPosition, width, height, xScale, yScale, rotation, width / 2, height / 2);
    }

    public float getMovementAngle() {
        return movementAngle;
    }

    public void setMovementAngle(float movementAngle) {
        this.movementAngle = movementAngle;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public Vector2 getCenter() {
        return center;
    }

    public void setCenter(Vector2 center) {
        this.center = center;
    }

    public float getXPosition() {
        return position.x;
    }

    public void setXPosition(float xPosition) {
        this.position.x = xPosition;
    }

    public float getYPosition() {
        return position.y;
    }

    public void setYPosition(float yPosition) {
        this.position.y = yPosition;
    }

    public Vector2 getPositionCenter() {
        return new Vector2(this.getXPosition() + this.getXCenter(), this.getYPosition() + this.getYCenter());
    }

    public void applyPosition(Vector2 position) {

        //Create new vector
        setPosition(new Vector2(
                getXPosition() + position.x,
                getYPosition() + position.y
        ));
    }

    public float getXScale() {
        return scale.x;
    }

    public void setXScale(float xScale) {
        this.scale.x = xScale;
    }

    public float getYScale() {
        return scale.y;
    }

    public void setYScale(float yScale) {
        this.scale.y = yScale;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getXCenter() {
        return center.x;
    }

    public void setXCenter(float xCenter) {
        this.center.x = xCenter;
    }

    public float getYCenter() {
        return center.y;
    }

    public void setyCenter(float yCenter) {
        this.center.y = yCenter;
    }

    public float getWidth() {
        return size.x;
    }

    public void setWidth(float width) {
        this.size.x = width;
    }

    public float getHeight() {
        return size.y;
    }

    public void setHeight(float height) {
        this.size.y = height;
    }

    public void rotate(float degrees) { this.rotation += degrees; }

    public void moveInDirection(float speed) {

        //Apply velocity
        applyPosition(new Vector2(
                (float)(speed * Math.cos(movementAngle)),
                (float)(speed * Math.sin(movementAngle))
        ));
    }

    public static void draw(SpriteBatch batch, TextureRegion texture, Transform transform) {

        //Draw
        batch.draw(texture,
                transform.getXPosition(),
                transform.getYPosition(),
                transform.getXCenter(),
                transform.getYCenter(),
                transform.getWidth(),
                transform.getHeight(),
                transform.getXScale(),
                transform.getYScale(),
                transform.getRotation()
        );
    }

    public static void draw(SpriteBatch batch, Texture texture, Transform transform) {

        //Draw
        draw(batch, new TextureRegion(texture), transform);
    }

    public static void pushInBody(Transform transform, Body body) {

        //Push the transform inside the body
        body.setTransform(transform.getPositionCenter(), 0);
    }

    @Override
    public Transform clone() {

        Transform clone = null;

        try {
            clone = (Transform) super.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        return clone;
    }
}
