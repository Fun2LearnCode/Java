package client;


public class Node<E> {
	private Node<E> next;
	private E data;
	public Node(E data){
		this.data = data;
		this.next = null;
	}
	public Node(E data, Node<E> next){
		this.data = data;
		this.next = next;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}
}
