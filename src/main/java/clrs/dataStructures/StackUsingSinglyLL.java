package clrs.dataStructures;

public class StackUsingSinglyLL<T> implements Stack<T>{
	
	Node<T> top;

	@Override
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		if(isEmpty())
			top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}
			
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new UnderflowException();
		T item = top.data;
		top = top.next;
		return item;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	private static class Node<T> {
		private T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
		}
	}
}
