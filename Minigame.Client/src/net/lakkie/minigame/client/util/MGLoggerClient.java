package net.lakkie.minigame.client.util;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MGLoggerClient extends Logger {

	private static final MGLoggerClient instance = new MGLoggerClient();
	
	private MGLoggerClient() {
		super("minigame.client", null);
	}
	
	public void log(LogRecord record) {
		System.out.printf("[CLIENT (%s)]: %s\n", record.getLevel().toString(), record.getMessage());
	}
	
	public static MGLoggerClient getInstance() {
		return instance;
	}

}
