package net.lakkie.minigame.test;

import net.lakkie.minigame.client.MinigameClientBootstrap;
import net.lakkie.minigame.server.MinigameServerBootstrap;

public class MinigameTester {

	public static void main(String[] args) {
		System.out.println("MASTER: Beginning to launch Server boostrap");
		MinigameServerBootstrap.main(new String[0]);
		System.out.println("MASTER: Beginning to launch Client boostrap");
		MinigameClientBootstrap.main(new String[0]);
	}
	
}
