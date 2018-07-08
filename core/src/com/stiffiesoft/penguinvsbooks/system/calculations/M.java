package com.stiffiesoft.penguinvsbooks.system.calculations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

//Mouse class
public class M {

    public static int x() { return Gdx.input.getX(); }
    public static int y() { return Gdx.input.getY(); }
    public static int iY() { return (int)C.sH() - y(); }
    public static Vector2 p() { return new Vector2(x(), y()); }
}
