package com.hkhamm.rpg;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        cfg.width = (int) screenDimension.getWidth();
        cfg.height = (int) screenDimension.getHeight();

		cfg.title = "RPG";
		cfg.useGL20 = true;
        cfg.fullscreen = true;
        cfg.vSyncEnabled = true;
		
		new LwjglApplication(new Game(), cfg);
	}
}
