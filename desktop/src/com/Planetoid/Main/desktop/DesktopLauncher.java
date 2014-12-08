package com.Planetoid.Main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.Planetoid.Main.Planetoid;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Planetiod";
		config.height = 700;
		config.width = 700;
		new LwjglApplication(new Planetoid(), config);
	}
}
