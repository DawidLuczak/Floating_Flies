package com.dawidluczak.floatingFlies.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dawidluczak.floatingFlies.FloatingFlies;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		resizeScreen(config);
		config.pauseWhenMinimized = true;
		new LwjglApplication(new FloatingFlies(), config);
	}
	
	private static void resizeScreen(LwjglApplicationConfiguration config){
		config.height = 4 * Toolkit.getDefaultToolkit().getScreenSize().height / 5;
		config.width = 4 * Toolkit.getDefaultToolkit().getScreenSize().width / 5;
	}
}
