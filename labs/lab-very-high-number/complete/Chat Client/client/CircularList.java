package client;

import java.util.ArrayList;

public class CircularList<E> {
	private Node<E> current;
	private int size;
	private Node<E> head;
	private final int MAX_MESSAGES;
	public CircularList(){
		MAX_MESSAGES = 50;
		current = null;
		size = 0;
	}
	public CircularList(int max){
		MAX_MESSAGES = max;
		current = null;
		size = 0;
	}
	public void add(E data){
		if(size == 0){
			head = new Node<E>(data);
			head.setNext(head);
			current = head;
			size++;
		}else if (size == MAX_MESSAGES){
			current.setNext(new Node<E>(data, current.getNext().getNext()));
			current = current.getNext();
		}else{
			current.setNext(new Node<E>(data, head));
			current = current.getNext();
			size++;
		}
	}
	public ArrayList<E> getData(){
		ArrayList<E> messages = new ArrayList<E>();
		if(current == null){
			return messages;
		}
		Node<E> temp = current.getNext();
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
