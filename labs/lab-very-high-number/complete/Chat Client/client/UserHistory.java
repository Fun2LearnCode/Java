package client;

import java.util.ArrayList;

import common.Message;

public class UserHistory {
	private CircularList<Message> messages;
	public UserHistory(){
		messages = new CircularList<Message>();
	}
	public UserHistory(int max){
		messages = new CircularList<Message>(max);
	}
	public void add(Message message){
		messages.add(message);
	}
	public ArrayList<Message> getHistory(){
		return messages.getData();
	}
}
