package client;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Message;
import common.StatusMessage;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int MAX_HISTORY = 100;
	private JPanel contentPane;
	private final ChatDisplay chatDisplay;
	private final InputDisplay inputDisplay;
	private final UsersDisplay usersDisplay;
	private boolean running;
	private String id;
	private HashMap<String, CircularList> history;

	public ChatFrame() {
		history = new HashMap<String, CircularList>(49);
		history.put("0", new CircularList(MAX_HISTORY));
		running = true;
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				running = false;
			}
		};
		setTitle("Chat Client");
		addWindowListener(exitListener);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		chatDisplay = new ChatDisplay();
		inputDisplay = new InputDisplay();
		usersDisplay = new UsersDisplay();
		contentPane.add(chatDisplay);
		contentPane.add(inputDisplay);
		contentPane.add(usersDisplay);
		Toolkit.getDefaultToolkit().addAWTEventListener((AWTEventListener) new CustomKeyListener(), AWTEvent.KEY_EVENT_MASK);
	}

	public boolean newMessage() {
		if (usersDisplay.newUser()) {
			chatDisplay.loadNewUser(usersDisplay.getCurrentUser(),
					history.get(usersDisplay.getCurrentUser()).getMessages());
		}
		return inputDisplay.newMessage();
	}

	public Message getMessage() {
		Message temp = new Message(inputDisplay.getMessage(), usersDisplay.getCurrentUser(), id, StatusMessage.MESSAGE);
		chatDisplay.displayMessage(temp);
		history.get(temp.getTo()).add(temp);
		return temp;
	}

	public void displayMessage(Message message) { // this is our message handler
		switch (message.getStatus()) {
		case MESSAGE:
			if (usersDisplay.getCurrentUser().equals(message.getFrom())) {
				chatDisplay.displayMessage(message);
			}
			history.get(message.getFrom()).add(message);
			break;
		case ADDUSER:
			usersDisplay.addUser(message.getFrom());
			history.put(message.getFrom(), new CircularList(MAX_HISTORY));
			break;
		case REMOVEUSER:
			usersDisplay.removeUser(message.getFrom());
			history.remove(message.getFrom());
			break;
		case LOADONLINE:
			for (String foo : message.getMessage().split(":")) {
				usersDisplay.addUser(foo);
				history.put(foo, new CircularList(MAX_HISTORY));
			}
			break;
		case NEWUSER:
			id = message.getTo();
			break;
		default:
			break;
		}
	}

	public boolean getRunning() {
		return running;
	}

	
	public String getId() {
		return id;
	}
	
	class CustomKeyListener implements AWTEventListener {
		@Override
		public void eventDispatched(AWTEvent e) {
			if (((KeyEvent) e).getKeyCode() == KeyEvent.VK_ENTER) {
				inputDisplay.sendMessage();
			}
			
		}
	}
}
