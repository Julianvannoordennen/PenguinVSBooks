package com.stiffiesoft.penguinvsbooks.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import sun.rmi.runtime.Log;

public class Lwjgl3Factory {

    public Lwjgl3ApplicationConfiguration create() {

        //Create config variable
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        //Set fullscreen with correct resolution and monitor
        Graphics.Monitor monitor = Lwjgl3ApplicationConfiguration.getPrimaryMonitor();
        Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);
        config.setFullscreenMode(displayMode);

        //Return
        return config;
    }
}
