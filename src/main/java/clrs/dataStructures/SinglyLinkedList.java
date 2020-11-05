package clrs.dataStructures;

import java.util.Objects;

public class SinglyLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	public SinglyLinkedList() {
	}

	public void insertAtHead(T data) {
		Node<T> newNode = new Node<>(data);

		if (isEmpty())
			tail = newNode;
		else
			newNode.next = head;

		head = newNode;
	}

	public void insertAtTail(T data) {
		Node<T> newNode = new Node<>(data);

		if (isEmpty())
			head = newNode;
		else
			tail.next = newNode;

		tail = newNode;

	}

	public Node<T> search(T data) {
		Node<T> current = head;
		while (current != null && !Objects.equals(current.data, data)) {
			current = current.next;
		}

		return current;
	}

	public boolean delete(T data) {

		Node<T> prev = null;
		Node<T> current = head;
		while (current != null && !Objects.equals(current.data, data)) {
			prev = current;
			current = current.next;
		}

		if (current == null)
			return false;

		if (current == head && current == tail) {
			head = tail = null;
			return true;
		}
		
		if(current == head) {
			head = current.next;
			return true;
		}

		prev.next = current.next;
		if (current == tail) {
			tail = prev;
		}
		
		return true;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public void reverse() {
		if(isEmpty() || (head == tail))
			return;
		
		Node<T> current = head;
		Node<T> prev = null;
		while(current != null) {
			Node<T> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		tail = head;
		head = prev;
	}

	static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}
}
