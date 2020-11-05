package clrs.dataStructures;

public class DequeUsingArray {

	private int[] items;
	private int head;
	private int tail;
	
	DequeUsingArray(int size) {
		items = new int[size];
		head = 0;
		tail = 0;
	}
	
	public void enqueueAtHead(int item) {
		if(isFull())
			throw new OverflowException();
		if(head == 0) 
			head = items.length - 1;
		else
			head = head - 1;
		items[head] = item;
	}
	
	public void enqueueAtTail(int item) {
		if(isFull())
			throw new OverflowException();
		items[tail] = item;
		tail = (tail + 1) % items.length;
	}
	
	public int dequeAtHead() {
		if(isEmpty())
			throw new UnderflowException();
		int item = items[head];
		head = (head + 1) % items.length;
		return item;
	}
	
	public int dequeAtTail() {
		if(isEmpty())
			throw new UnderflowException();
		if(tail == 0)
			tail = items.length - 1;
		else
			tail = tail - 1;
		return items[tail];
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		return (tail + 1) % items.length == head;
	}
}
