package net.lakkie.minigame.client.display;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class MinigameDisplayManager implements KeyListener {

	public static MinigameDisplayManager instance;

	public MinigameDisplayFrame frame;
	
	public MinigameDisplayManager(MinigameDisplayFrame frame) {
		this.frame = frame;
		this.frame.messageText.addKeyListener(this);
		this.frame.messageInputButton.addActionListener((event) -> {
			this.submitMessage();
		});
		instance = this;
	}

	public void logMessage(String message, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		int len = this.frame.textPane.getDocument().getLength();
		this.frame.textPane.setCaretPosition(len);
		this.frame.textPane.setCharacterAttributes(aset, false);
		this.frame.textPane.replaceSelection(message);
	}

	public void submitMessage() {
		// Temporary
		this.logMessage("You: " + this.frame.messageText.getText() + "\n", Color.green);
		this.frame.messageText.setText("");
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// Appropriate button pressed
			this.submitMessage();
		}
	}

}
