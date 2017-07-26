package gui;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.LogicHandler;


public class ChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private InputDisplay inputDisplay;
	public ChatFrame(LogicHandler  messageHandler) {
		setTitle("Chat Client");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MessageDisplay chatDisplay = new MessageDisplay();
		inputDisplay = new InputDisplay(messageHandler);
		UsersDisplay usersDisplay = new UsersDisplay(messageHandler);
		contentPane.add(chatDisplay);
		contentPane.add(inputDisplay);
		contentPane.add(usersDisplay);
		messageHandler.loadMessageDisplay(chatDisplay);
		Toolkit.getDefaultToolkit().addAWTEventListener((AWTEventListener) new CustomKeyListener(), AWTEvent.KEY_EVENT_MASK);
	}
	
	class CustomKeyListener implements AWTEventListener {
		@Override
		public void eventDispatched(AWTEvent e) {
			if (((KeyEvent) e).getKeyCode() == KeyEvent.VK_ENTER) {
				inputDisplay.send();
			}
		}
	}
}
