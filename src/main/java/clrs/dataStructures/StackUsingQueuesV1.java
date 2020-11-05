package clrs.dataStructures;

import java.util.LinkedList;
import java.util.Queue;

/*
 * pop and peek are expensive - O(n)
 * push is O(1)
 */
public class StackUsingQueuesV1<T> {
	
	private Queue<T> activeQueue;
	private Queue<T> inactiveQueue;
	
	public StackUsingQueuesV1() {
		activeQueue = new LinkedList<>();
		inactiveQueue = new LinkedList<>();
	}

	public void push(T item) {
		activeQueue.add(item);
	}
	
	public T pop() {
		if(isEmpty())
			throw new UnderflowException();
		
		while(activeQueue.size() != 1) {
			inactiveQueue.add(activeQueue.poll());
		}
		
		swapQueues();
		return inactiveQueue.poll();
	}
	
	private void swapQueues() {
		Queue<T> temp = activeQueue;
		activeQueue = inactiveQueue;
		inactiveQueue = temp;
	}

	public boolean isEmpty() {
		return activeQueue.isEmpty();
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		
		while(activeQueue.size() != 1) {
			inactiveQueue.add(activeQueue.poll());
		}
		
		T result = activeQueue.peek();
		
		inactiveQueue.add(activeQueue.poll());
		swapQueues();
		return result;
	}
}
