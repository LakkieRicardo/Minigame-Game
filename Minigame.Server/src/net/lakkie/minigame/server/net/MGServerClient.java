package net.lakkie.minigame.server.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import net.lakkie.minigame.server.util.MGLoggerServer;

public class MGServerClient {

	private Socket clientSocket;
	private MinigameServer server;
	private Thread clientListener;

	public MGServerClient(Socket clientSocket, MinigameServer server) {
		this.clientSocket = clientSocket;
		this.server = server;
		this.clientListener = new Thread(this::listen);
		this.clientListener.start();
		this.sendMessage("Test Message");
		this.sendMessage("Test Message 2");
	}
	
	public boolean sendMessage(String message) {
		try {
			this.clientSocket.getOutputStream().write((message + "\n").getBytes());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void listen() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			while (!this.clientSocket.isClosed()) {
				if (reader.ready()) {
					String message = reader.readLine();
					MGLoggerServer.getInstance().info("Received message: \"" + message + "\"");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		MGLoggerServer.getInstance().info("Client " + this.clientSocket.getInetAddress() + " has disconnected");
	}

	public Thread getClientListener() {
		return this.clientListener;
	}

	public Socket getClientSocket() {
		return this.clientSocket;
	}

	public MinigameServer getServer() {
		return this.server;
	}

}
