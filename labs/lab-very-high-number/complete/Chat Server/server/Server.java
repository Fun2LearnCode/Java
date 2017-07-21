package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{
	private ServerSocket serverSocket;
	private ChatServer chatServer;
	public Server(int port){
			chatServer = new ChatServer(port);
		try {
			System.out.println("Binding to port " + port + ", please wait  ...");
			serverSocket = new ServerSocket(port);
			System.out.println("Server started: " + serverSocket);
			Thread thread = new Thread(this);
			thread.setName("Server connection thread");
			thread.start();
		} catch (IOException ioe) {
			System.out.println("Can not bind to port " + port + ": " + ioe.getMessage());
		}
	}
	@Override
	public void run(){
		while(true){
			try {
				System.out.println("Waiting for a client ...");
				chatServer.addThread(serverSocket.accept());
			} catch (IOException ioe) {
				System.out.println("Server accept error: " + ioe);
			}
		}
	}
	public static void main(String args[]) {
		//if (args.length != 1)
		//	System.out.println("Usage: java GameServer port");
		//else
			new Server(7958);
	}
}