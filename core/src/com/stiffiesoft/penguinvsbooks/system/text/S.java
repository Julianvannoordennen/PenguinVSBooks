package com.stiffiesoft.penguinvsbooks.system.text;

//Strings class, for getting text in correct language
public class S {

    //Current language
    public static Language l = Language.ENGLISH;

    //Menu strings
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

    //Counter strings
    public static String score() {
        if (l == Language.DUTCH) return "Punten";
        else return "Score";
    }
    public static String lifes() {
        if (l == Language.DUTCH) return "Levens";
        else return "Lifes";
    }

    //Pickup strings
    public static String grenade() {
        if (l == Language.DUTCH) return "Granaat";
        else return "Grenade";
    }
    public static String cookie() {
        if (l == Language.DUTCH) return "Koekje";
        else return "Cookie";
    }
    public static String laser() {
        if (l == Language.DUTCH) return "Laser";
        else return "Laser";
    }
    public static String teleporter() {
        if (l == Language.DUTCH) return "Teleporteerder";
        else return "Teleporter";
    }
    public static String magnet() {
        if (l == Language.DUTCH) return "Magneet";
        else return "Magnet";
    }
    public static String bomb() {
        if (l == Language.DUTCH) return "Bom";
        else return "Bomb";
    }
    public static String katana() {
        if (l == Language.DUTCH) return "Katana";
        else return "Katana";
    }
    public static String extraLife() {
        if (l == Language.DUTCH) return "Extra leven";
        else return "Extra extralife";
    }
    public static String megaLife() {
        if (l == Language.DUTCH) return "Mega leven";
        else return "Mega extralife";
    }
    public static String earthquake() {
        if (l == Language.DUTCH) return "Aardbeving";
        else return "Earthquake";
    }
    public static String nuke() {
        if (l == Language.DUTCH) return "Atoombom";
        else return "Nuke";
    }
    public static String boomerang() {
        if (l == Language.DUTCH) return "Boemerang";
        else return "Boomerang";
    }
    public static String plasmaTurret() {
        if (l == Language.DUTCH) return "Plasma Geschuttoren";
        else return "Plasma Turret";
    }
    public static String hacker() {
        if (l == Language.DUTCH) return "Hacker";
        else return "Hacker";
    }
    public static String dyslexia() {
        if (l == Language.DUTCH) return "Dyslexie";
        else return "Dyslexia";
    }
    public static String flameThrower() {
        if (l == Language.DUTCH) return "Vlammenwerper";
        else return "Flamethrower";
    }
    public static String saw() {
        if (l == Language.DUTCH) return "Zaag";
        else return "Saw";
    }
    public static String wizard() {
        if (l == Language.DUTCH) return "Tovenaar";
        else return "Wizard";
    }
    public static String clover() {
        if (l == Language.DUTCH) return "Klavertje vier";
        else return "Clover";
    }
    public static String bombBook() {
        if (l == Language.DUTCH) return "Bom boek";
        else return "Bomb book";
    }
}
