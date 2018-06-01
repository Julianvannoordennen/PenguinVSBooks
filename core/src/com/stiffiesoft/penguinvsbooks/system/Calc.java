package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.Gdx;

public class Calc {

    //Get whole screen width and height
    public static float sW() {return Gdx.graphics.getWidth(); }     //Screen width
    public static float sH() {return Gdx.graphics.getHeight(); }    //Screen height

    //1% of screen width and height
    public static float pW() {return sW() / 100; }   //Procentual width
    public static float pH() {return sH() / 100; }   //Procentual height
}
