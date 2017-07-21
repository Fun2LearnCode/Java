package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import common.Message;

public class ClientThread extends Thread{
	private Socket socket;
	private ObjectInputStream streamIn;
	private ArrayList<Message> messages;
	private boolean running;
	private Object dataLock = new Object();
	public AtomicInteger newInput;
	public ClientThread(Socket socket) {
		newInput = new AtomicInteger();
		running = true;
		this.socket = socket;
		messages = new ArrayList<Message>();
		setName("Client Thread");
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
	public Message getMessage(){
		 synchronized(dataLock){
			 newInput.decrementAndGet();
			 return messages.remove(0);
		 }
	}
	public void run() {
		open();
		Message temp;
		while (running) {
			try {
				temp = (Message)streamIn.readObject();
				synchronized(dataLock){
					messages.add(temp);
					newInput.getAndIncrement();
				}
			} catch (IOException | ClassNotFoundException ioe) {
				System.out.println("Disconnected from the server");
				kill();
			}
	
		}
	}
}
