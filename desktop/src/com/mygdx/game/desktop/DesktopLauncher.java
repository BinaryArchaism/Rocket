package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.screens.GameScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		newScene(new GameScreen());
	}
	public static void newScene(ApplicationAdapter screen) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(screen, config);
		config.height = 224;
		config.width = 384;
		config.title = "Story of Knight";
		config.addIcon("icon.png", Files.FileType.Local);
	}
}
