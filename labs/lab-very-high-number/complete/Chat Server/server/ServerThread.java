package server;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import common.Message;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
	private ObjectInputStream streamIn;
	private ObjectOutputStream streamOut;
	private Socket socket;
	private ArrayList<Message> messages;
	private final String id;
	private boolean running;
	private Object dataLock = new Object();
	public AtomicInteger newInput;
	public ServerThread(Socket socket, int id) {
		super();
		newInput = new AtomicInteger();
		this.socket = socket;
		this.id = ((id < 10)? "0": "")+ id  + socket.getPort();
		messages = new ArrayList<Message>();
		setName("Server Thread thread");
	}
	public Message getMessage(){
		synchronized(dataLock){
			newInput.decrementAndGet();
			return messages.remove(0);
		}
	}
	public void kill(){
		running = false;
		try {
			streamOut.close();
			streamIn.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void send(Message msg) {
		try {
			streamOut.writeObject(msg);
			streamOut.flush();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	public String getID(){
		return id;
	}
	public void open() {
		try {
			streamIn = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			streamOut = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void start(){
		running = true;
		open();
		super.start();
	}
	public int getIndex(){
		return Integer.parseInt(id.substring(0,1));
	}
	public void run() {
		Message temp;
		while (running) {
			try {
				temp = (Message) streamIn.readObject();
				synchronized(dataLock){
					messages.add(temp);
					newInput.getAndIncrement();
				}
			} catch (IOException ioe) {
				System.out.println("User Disconnected");
				kill();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}