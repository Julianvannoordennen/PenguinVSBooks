package com.stiffiesoft.penguinvsbooks.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;

public class Lwjgl3Factory {

    public Lwjgl3ApplicationConfiguration create() {

        //Create config variable
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        //Set fullscreen with correct resolution and monitor
        Graphics.Monitor monitor = Lwjgl3ApplicationConfiguration.getMonitors()[0];
        Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);
        config.setFullscreenMode(displayMode);
        config.setResizable(false);

        //Set game title
        config.setTitle("Penguin VS Books");

        //Return
        return config;
    }
}