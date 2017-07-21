package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.Message;
import common.StatusMessage;

public class ChatClient implements Runnable{
	private ChatFrame frame;
	private Socket socket;
	private ObjectOutputStream streamOut;
	private ClientThread thread;
	public ChatClient(){
		frame = new ChatFrame();
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
		thread = new ClientThread(socket);
		Thread temp = new Thread(this);
		temp.setName("Chat client thread");
		temp.start();
	}
	private void send(Message message) throws IOException{
		streamOut.writeObject(message);
		streamOut.flush();
	}
	@Override
	public void run() {
		while(true){
			if(thread.newInput.get() > 0){
				Message temp = thread.getMessage();
				frame.displayMessage(temp);
			}
			if(frame.newMessage()){
				try {
					send(frame.getMessage());
				} catch (IOException e) {
					System.out.println("Server Closed");
				}
			}
			if(!frame.getRunning()){
				try {
					send(new Message("", "0", frame.getId(), StatusMessage.QUIT));
				} catch (IOException e) {
					System.out.println("Closing client");
				}
			}
			if(!thread.isAlive()){
				try{
					streamOut.close();
					socket.close();
				} catch (IOException e) {
					System.out.println("Closing client");
				}finally{
					System.exit(0);
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
