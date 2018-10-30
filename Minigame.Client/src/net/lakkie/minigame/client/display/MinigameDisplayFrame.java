package net.lakkie.minigame.client.display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MinigameDisplayFrame extends JFrame {

	private static final long serialVersionUID = 6217207166879976302L;
	public JPanel contentPane;
	public JTextField messageText;
	public JButton messageInputButton;
	public JButton exitServerButton;
	public JTextPane textPane;

	public MinigameDisplayFrame() {
		this.setTitle("Minigame Display");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 722, 458);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 30, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		this.contentPane.setLayout(gbl_contentPane);

		this.exitServerButton = new JButton("Exit Server");
		GridBagConstraints gbc_exitServerButton = new GridBagConstraints();
		gbc_exitServerButton.insets = new Insets(0, 0, 5, 0);
		gbc_exitServerButton.gridx = 1;
		gbc_exitServerButton.gridy = 0;
		this.contentPane.add(this.exitServerButton, gbc_exitServerButton);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.contentPane.add(scrollPane, gbc_scrollPane);
		
		this.textPane = new JTextPane();
		scrollPane.setViewportView(this.textPane);

		this.messageText = new JTextField();
		GridBagConstraints gbc_messageText = new GridBagConstraints();
		gbc_messageText.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_messageText.insets = new Insets(0, 0, 0, 5);
		gbc_messageText.fill = GridBagConstraints.BOTH;
		gbc_messageText.gridx = 0;
		gbc_messageText.gridy = 2;
		this.contentPane.add(this.messageText, gbc_messageText);
		this.messageText.setColumns(10);

		this.messageInputButton = new JButton("Send Input");
		GridBagConstraints gbc_messageInputButton = new GridBagConstraints();
		gbc_messageInputButton.fill = GridBagConstraints.BOTH;
		gbc_messageInputButton.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_messageInputButton.gridx = 1;
		gbc_messageInputButton.gridy = 2;
		this.contentPane.add(this.messageInputButton, gbc_messageInputButton);
//		this.textPane.setEditable(false);
		setVisible(true);
		new MinigameDisplayManager(this);
	}

}
