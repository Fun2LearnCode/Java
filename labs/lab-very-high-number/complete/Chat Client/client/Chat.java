package client;

import java.awt.EventQueue;

public class Chat {
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ChatClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
