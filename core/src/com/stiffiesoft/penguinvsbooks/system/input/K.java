package com.stiffiesoft.penguinvsbooks.system.input;

//Key class
public class K {

    //This class holds the key numbers that are used
    static int up = 51;
    static int down = 47;
    static int left = 29;
    static int right = 32;
    static int attack = 0;

    //Get methods
    public static int up       ()              { return up;            }
    public static int down     ()              { return down;          }
    public static int left     ()              { return left;          }
    public static int right    ()              { return right;         }
    public static int attack   ()              { return attack;        }

    //Set methods
    public static void up      (int value)     { up        = value;    }
    public static void down    (int value)     { down      = value;    }
    public static void left    (int value)     { left      = value;    }
    public static void right   (int value)     { right     = value;    }
    public static void attack  (int value)     { attack    = value;    }
}
