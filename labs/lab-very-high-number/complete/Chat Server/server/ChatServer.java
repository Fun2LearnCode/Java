package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import common.Message;
import common.StatusMessage;

public class ChatServer implements Runnable {
	private ServerThread[] users;
	private final int MAX_USERS = 50;
	private int currentUser;
	private boolean running;
	private JPanel panel;
	private JScrollPane scrollPane;
	public ChatServer(int port) {
		users = new ServerThread[MAX_USERS];
		for(int x = 0; x  < users.length; x++){
			users[x] = null;
		}
		running = true;
		Thread thread = new Thread(this);
		thread.setName("Chat server thread");
		thread.start();
	}
	private void init(){
		JFrame frame = new JFrame();
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	running = false;
		    }
		};
		frame.setTitle("Chat server");
		frame.setResizable(false);
		frame.addWindowListener(exitListener);
		frame.setBounds(100, 100, 650, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 10, 101, 339);
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 455, 295);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 455, 295);
		textArea.setEditable(false);
		panel_2.add(textArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 317, 455, 33);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton endServer = new JButton("End Server");
		endServer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				running = false;
			}
		});
		endServer.setBounds(10, 0, 125, 23);
		panel_3.add(endServer);
		
		JButton resetConnection = new JButton("Reset Connection");
		resetConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetConnection();
			}
		});
		resetConnection.setBounds(303, 0, 125, 23);
		panel_3.add(resetConnection);
		frame.setVisible(true);
	}
	private void resetConnection() {
		for (int y = 0; y < users.length; y++) {
			if (users[y] != null){
				users[y].kill();
				users[y] = null;
			}
		}	
		resetButtons();
	}
	private void resetButtons(){
		JButton temp;
		panel.removeAll();
		for(int x = 0; x < users.length; x++){
			if(users[x] != null){
				temp = new JButton(users[x].getID());
				temp.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						removeUser(((JButton) e.getSource()).getText());
					}
				});
				panel.add(temp);
			}
		}
		scrollPane.validate();
		scrollPane.repaint();
		panel.validate();
		panel.repaint();
	}
	private void removeUser(String id){
		users[Integer.parseInt(id.substring(0,2))].kill();
		users[Integer.parseInt(id.substring(0,2))] = null;
		for (int y = 0; y < users.length; y++) {
			if (users[y] != null){
				users[y].send(new Message("", users[y].getID(), id, StatusMessage.REMOVEUSER));
			}
		}
		resetButtons();
	}
	public void addThread(Socket socket) { // a new user connects
		if (currentUser < MAX_USERS) {
			int x = getOpenSpot();
			String s = "";
			users[x] = new ServerThread(socket, x);
			users[x].start();
			for (int y = 0; y < users.length; y++) {
				if (users[y] != null && x != y){
					s += users[y].getID() + ":";
					System.out.println(s);
					users[y].send(new Message("", users[y].getID(), users[x].getID(), StatusMessage.ADDUSER));
				}
			}
			users[x].send(new Message("", users[x].getID(), "0", StatusMessage.NEWUSER));
			if(!s.equals("")){
				s = s.substring(0, s.length() -1);
				users[x].send(new Message(s, users[x].getID(), "0", StatusMessage.LOADONLINE));
			}
			resetButtons();
		}
	}
	private void closeServer(){
		for (int y = 0; y < users.length; y++) {
			if (users[y] != null){
				users[y].send(new Message("", users[y].getID(), "0", StatusMessage.QUIT));
				users[y].kill();
			}
		}
		System.exit(0);
	}
	private int getOpenSpot(){
		for(int x = 0; x < users.length; x++){
			if(users[x] == null){
				return x;
			}
		}
		return -1;
	}
	@Override
	public void run() {
		Message temp;
		init();
		while (running) {
			for (int x = 0; x < users.length; x++) {
				if (users[x] != null && users[x].newInput.get() > 0) {
					temp = users[x].getMessage();
					if(!temp.getTo().equals("0")){ // 0 is the server id
						users[temp.getToIndex()].send(temp);
					}else{
						if(temp.getStatus() == StatusMessage.QUIT){
							removeUser(temp.getFrom());
						}
					}
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		closeServer();
	}
}
