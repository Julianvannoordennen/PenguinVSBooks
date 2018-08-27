package com.stiffiesoft.penguinvsbooks.system.calculations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

//Calc class, minimized because it will getArray used a lot
public class C {

    //Get whole screen width and height
    public static float sW() {return Gdx.graphics.getWidth(); }     //Screen width
    public static float sH() {return Gdx.graphics.getHeight(); }    //Screen height

    //1% of screen width and height
    public static float pW() {return sW() / 100; }   //Procentual width
    public static float pH() {return sH() / 100; }   //Procentual height

    //Times
    static float gameTime = 1;                                                          //Game time, for when ingame
    static float engineTime = 1;                                                        //Engine time, for when using ingame menu's where the Game has to be paused
    public static float dT()                {return Gdx.graphics.getDeltaTime(); }      //Last delta time
    public static float gT()                {return C.gameTime; }                       //Get Game time
    public static float cGT()               {return C.gT() * C.cET(); }                 //Get Game time with delta time, for in Game
    public static void gT(float amount)     {C.gameTime = amount; }                     //Set Game time
    public static float eT()                {return C.engineTime; }                     //Get engine time
    public static float cET()               {return C.eT() * C.dT(); }                  //Get engine time with delta time, for menu's in Game
    public static void eT(float amount)     {C.engineTime = amount; }                   //Set engine time

    //Calculating angles
    public static float getAngleInRadians(Vector2 p1, Vector2 p2) {
        return (float)Math.atan2(p2.y - p1.y, p2.x - p1.x);
    }

    public static float getAngleInDegrees(Vector2 p1, Vector2 p2) {
        return (float)(getAngleInRadians(p1, p2) * 180 / Math.PI);
    }

    public static float degreesToRadians(float value) {
        return value  / 57.295779513f;
    }

    //Check if vector is outside screen
    public static boolean oS(Vector2 position) {
        return oS(position,0);
    }

    public static boolean oS(Vector2 position, float correction) {
        return (position.x < correction || position.x > sW() - (correction * 2) || position.y < correction || position.y > sH() - (correction * 2));
    }

    //Get position outside screen
    public static Vector2 pOS(int edgeCorrection) {
        Vector2 position;
        switch (MathUtils.random(3)) {
            case 0:
                position = new Vector2(
                        MathUtils.random(-edgeCorrection, C.sW() + edgeCorrection),
                        (int)C.sH() + edgeCorrection
                );
                break;

            case 1:
                position = new Vector2(
                        MathUtils.random(-edgeCorrection, C.sW() + edgeCorrection),
                        -edgeCorrection
                );
                break;

            case 2:
                position = new Vector2(
                        -edgeCorrection,
                        MathUtils.random(-edgeCorrection, C.sH() + edgeCorrection)
                );
                break;

            default:
                position = new Vector2(
                        (int)C.sW() + edgeCorrection,
                        MathUtils.random(-edgeCorrection, C.sH() + edgeCorrection)
                );
                break;
        }
        return position;
    }
}
