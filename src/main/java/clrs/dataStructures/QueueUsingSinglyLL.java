package clrs.dataStructures;

public class QueueUsingSinglyLL<T> {

	Node<T> head;
	Node<T> tail;
	
	public QueueUsingSinglyLL() {
		head = null;
		tail = null;
	}
	
	public void enqueue(T item) {
		Node<T> newNode = new Node<>(item);
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		
	}
	
	public T dequeue() {
		if(isEmpty())
			throw new UnderflowException();
		T item = head.data;
		head = head.next;
		
		if(isEmpty())
			tail = null;
		
		return item;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private static class Node<T> {
		private T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
		}
	}
}
