package net.lakkie.minigame.server.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import net.lakkie.minigame.server.util.MGLoggerServer;

public class MinigameServer {

	private ServerSocket socket;
	private Thread listener;
	private final List<Socket> clients = new ArrayList<Socket>();
	private boolean running;

	public MinigameServer(int port) {
		try {
			MGLoggerServer.getInstance().info("Starting server on port " + port);
			this.socket = new ServerSocket(port);
			MGLoggerServer.getInstance().info("Successfully started server on port " + port);
			this.running = true;
			this.listener = new Thread(this::listen);
			this.listener.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listen() {
		try {
			while (this.running) {
				Socket acceptee = this.socket.accept();
				this.clients.add(acceptee);
				MGLoggerServer.getInstance().info("Sending message...");
				acceptee.getOutputStream().write("Test message\n".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
