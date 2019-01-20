package com.mariaiva.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mariaiva.game.Ex1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Ex1.WIDTH;
		config.height = Ex1.HEIGHT;
		config.title = Ex1.TITLE;
		new LwjglApplication(new Ex1(), config);
	}
}
