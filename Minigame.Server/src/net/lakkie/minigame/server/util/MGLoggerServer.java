package net.lakkie.minigame.server.util;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MGLoggerServer extends Logger {

	private static final MGLoggerServer instance = new MGLoggerServer();
	
	private MGLoggerServer() {
		super("minigame.server", null);
	}
	
	public void log(LogRecord record) {
		System.out.printf("[SERVER (%s)]: %s\n", record.getLevel().toString(), record.getMessage());
	}
	
	public static MGLoggerServer getInstance() {
		return instance;
	}

}
