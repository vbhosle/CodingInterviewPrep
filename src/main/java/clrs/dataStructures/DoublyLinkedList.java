package clrs.dataStructures;

import java.util.Objects;

/*
 * To keep things simple, minimal and as close to the method implementations in the CLRS book 
 * members are accessible from out of class 
 * no tracking of list size
 */
public class DoublyLinkedList<T> {

	Node<T> Nil;
	
	public DoublyLinkedList() {
		Nil = new Node<>(null);
		Nil.next = Nil;
		Nil.prev = Nil;
	}
	
	public void insertAtHead(T data) {
		Node<T> newNode = new Node<>(data);
		
		newNode.next = Nil.next;
		Nil.next.prev = newNode;
		
		Nil.next = newNode;
		newNode.prev = Nil;
		
	}
	
	public void insertAtTail(T data) {
		Node<T> newNode = new Node<>(data);
		
		Nil.prev.next = newNode;
		newNode.prev = Nil.prev;
		
		Nil.prev = newNode;
		newNode.next = Nil;
	}
	
	public Node<T> search(T data) {
		Node<T> current = Nil.next;
		while(current != Nil && !Objects.equals(current.data, data)) {
			current = current.next;
		}
		
		return current;
	}
	
	public boolean delete(T data) {
		Node<T> targetNode = search(data);
		if(targetNode == Nil)
			return false;
		
		targetNode.next.prev = targetNode.prev;
		targetNode.prev.next = targetNode.next;
		
		return true;
	}
	
	//union
	public void append(DoublyLinkedList<T> other) {
		this.last().next = other.first();
		other.first().prev = this.last();
		
		other.last().next = this.Nil;
		this.Nil.prev = other.last();
	}
	
	public boolean isEmpty() {
		return Nil.next == Nil;
	}
	
	private Node<T> first() {
		return this.Nil.next;
	}
	
	private Node<T> last() {
		return this.Nil.prev;
	}

	static class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
		}
		
		public String toString() {
			return "Node " + this.data;
		}
	}

}
