package com.stiffiesoft.penguinvsbooks.system.text;

//Strings class, for getting text in correct language
public class S {

    public static Language l = Language.ENGLISH;

    public static String pressSpacebarToContinue() {
        if (l == Language.DUTCH) return "Druk op 'spatie' om door te gaan !";
        else return "Press 'spacebar' to continue !";
    }

    public static String startTheGame() {
        if (l == Language.DUTCH) return "Start het spel";
        else return "Start the Game";
    }

    public static String showIngameArchievements() {
        if (l == Language.DUTCH) return "Bekijk de spelprestaties";
        else return "Show ingame archievements";
    }

    public static String quitTheGame() {
        if (l == Language.DUTCH) return "Verlaat het spel";
        else return "Quit the Game";
    }

    public static String showConfigurableSettings() {
        if (l == Language.DUTCH) return "Geef aanpasbare spelopties weer";
        else return "Show configurable settings";
    }

    public static String showIngameStatistics() {
        if (l == Language.DUTCH) return "Bekijk de spelstatistieken";
        else return "Show ingame statistics";
    }

    public static String showIngameUpgrades() {
        if (l == Language.DUTCH) return "Bekijk de spelupgrades";
        else return "Show ingame upgrades";
    }

    public static String score() {
        if (l == Language.DUTCH) return "Punten";
        else return "Score";
    }
}
