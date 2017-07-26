package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import common.Message;
import interfaces.MessageHandler;

public class ClientThread extends Thread{
	private Socket socket;
	private ObjectInputStream streamIn;
	private boolean running;
	private MessageHandler messageHandler;
	public ClientThread(Socket socket, MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
		this.socket = socket;
		running = true;
		start();
	}
	private void open() {
		try {
			streamIn = new ObjectInputStream(socket.getInputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public void kill() {
		running = false;
		try {
			streamIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		open();
		while (running) {
			try {
				messageHandler.handleIncomingMessage((Message)streamIn.readObject());
			} catch (IOException | ClassNotFoundException ioe) {
				System.out.println("Disconnected from the server");
				kill();
				System.exit(0);
			}
	
		}
	}
}
