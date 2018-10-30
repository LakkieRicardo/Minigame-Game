package net.lakkie.minigame.client;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.lakkie.minigame.client.display.MinigameDisplayFrame;
import net.lakkie.minigame.client.net.MinigameClient;

public class MinigameClientBootstrap {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new MinigameDisplayFrame();
		new MinigameClient("127.0.0.1", 53578);
	}

}
