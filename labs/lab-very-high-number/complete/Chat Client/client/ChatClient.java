package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.Message;
import gui.ChatFrame;
import interfaces.OutputStream;


public class ChatClient implements OutputStream{
	private Socket socket;
	private ObjectOutputStream streamOut;
	
	public ChatClient(){
		LogicHandler  displayLogic = new LogicHandler (this);
		new ChatFrame(displayLogic);
		while(true){
			try {
				socket = new Socket("192.168.0.15", 7958);
				streamOut = new ObjectOutputStream(socket.getOutputStream());
				break;
			} catch (IOException e) {
				try {
					System.out.println("Trying to connect");
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					
				}
			}
		}
		new ClientThread(socket, displayLogic);
	}
	
	@Override
	public void send(Message message) {
		try {
			streamOut.writeObject(message);
			streamOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
