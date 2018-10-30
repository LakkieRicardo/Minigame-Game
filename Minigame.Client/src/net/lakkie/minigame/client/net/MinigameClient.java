package net.lakkie.minigame.client.net;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import net.lakkie.minigame.client.display.MinigameDisplayManager;
import net.lakkie.minigame.client.util.MGLoggerClient;

public class MinigameClient {

	private Thread listener;
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private boolean runningClient;

	public MinigameClient(String address, int port) {
		try {
			MGLoggerClient.getInstance().info("Generating Connection...");
			this.socket = new Socket(address, port);
			MGLoggerClient.getInstance().info("Successfully connected to " + address + ":" + port);
			this.runningClient = true;
			this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			this.listener = new Thread(this::listen);
			this.listener.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listen() {
		try {
			while (this.runningClient) {
				String liner = this.reader.readLine();
				MGLoggerClient.getInstance().info("Received \"" + liner + "\"\n");
				MinigameDisplayManager.instance.logMessage(liner + "\n", Color.red);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendData(String data) {

	}

	public BufferedReader getReader() {
		return this.reader;
	}

	public BufferedWriter getWriter() {
		return this.writer;
	}

}
