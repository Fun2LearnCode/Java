package client;

import java.util.ArrayList;

import common.Message;

public class CircularList {
	private Node current;
	private int size;
	private Node head;
	private final int MAX_MESSAGES;
	public CircularList(int max){
		MAX_MESSAGES = max;
		current = null;
		size = 0;
	}
	public void add(Message message){
		if(size == 0){
			head = new Node(message);
			head.setNext(head);
			current = head;
			size++;
		}else if (size == MAX_MESSAGES){
			current.setNext(new Node(message, current.getNext().getNext()));
			current = current.getNext();
		}else{
			current.setNext(new Node(message, head));
			current = current.getNext();
			size++;
		}
	}
	public ArrayList<Message> getMessages(){
		ArrayList<Message> messages = new ArrayList<Message>();
		if(current == null){
			return messages;
		}
		Node temp = current.getNext();
		while(true){
			messages.add(temp.getData());
			if(temp.equals(current)){
				break;
			}
			temp = temp.getNext();
		}
		return messages;
	}
}
