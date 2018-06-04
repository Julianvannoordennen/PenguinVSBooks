package com.stiffiesoft.penguinvsbooks.system;

import com.badlogic.gdx.Gdx;

//Calc class, minimized because it will get used a lot
public class C {

    //Get whole screen width and height
    public static float sW() {return Gdx.graphics.getWidth(); }     //Screen width
    public static float sH() {return Gdx.graphics.getHeight(); }    //Screen height

    //1% of screen width and height
    public static float pW() {return sW() / 100; }   //Procentual width
    public static float pH() {return sH() / 100; }   //Procentual height

    //Times
    static float gameTime = 1;                                                          //Game time, for when ingame
    static float engineTime = 1;                                                        //Engine time, for when using ingame menu's where the game has to be paused
    public static float dT()                {return Gdx.graphics.getDeltaTime(); }      //Last delta time
    public static float gT()                {return C.gameTime; }                       //Get game time
    public static float cGT()               {return C.gT() * C.cET(); }                 //Get game time with delta time, for in game
    public static void gT(float amount)     {C.gameTime = amount; }                     //Set game time
    public static float eT()                {return C.engineTime; }                     //Get engine time
    public static float cET()               {return C.eT() * C.dT(); }                  //Get engine time with delta time, for menu's in game
    public static void eT(float amount)     {C.engineTime = amount; }                   //Set engine time
}
