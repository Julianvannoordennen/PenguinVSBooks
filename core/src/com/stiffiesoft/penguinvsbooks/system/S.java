package com.stiffiesoft.penguinvsbooks.system;

//Strings class, for getting strings in correct language
public class S {

    public static Language l = Language.ENGLISH;

    public static String pressSpacebarToContinue() {
        if (l == Language.DUTCH) return "Druk op 'spatie' om door te gaan !";
        else return "Press 'spacebar' to continue !";
    }
}
