package com.stiffiesoft.penguinvsbooks.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.stiffiesoft.penguinvsbooks.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {

		//Create configuration
		Lwjgl3ApplicationConfiguration config = new Lwjgl3Factory().create();

		//Launch application
		new Lwjgl3Application(new Main(), config);
	}
}
