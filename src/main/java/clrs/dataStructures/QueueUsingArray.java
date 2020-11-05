package clrs.dataStructures;

public class QueueUsingArray {

	private int[] items;
	private int head;
	private int tail;
	
	public QueueUsingArray(int size) {
		items = new int[size];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(int item) {
		if(isFull())
			throw new OverflowException();
		items[tail] = item;
		tail = (tail + 1) % items.length;
	}
	
	public int dequeue() {
		if(isEmpty())
			throw new UnderflowException();
		int item = items[head];
		head = (head + 1) % items.length;
		return item;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		return ((tail + 1) % items.length) == head;
	}
}
