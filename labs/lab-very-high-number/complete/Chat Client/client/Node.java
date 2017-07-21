package client;

import common.Message;

public class Node {
	private Node next;
	private Message data;
	public Node(Message data){
		this.data = data;
		this.next = null;
	}
	public Node(Message data, Node next){
		this.data = data;
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	public Message getData() {
		return data;
	}
}
