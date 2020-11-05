package clrs.dataStructures;

import java.util.LinkedList;
import java.util.Queue;

/*
 * push is expensive - O(n)
 * pop and peek is O(1)
 */
public class StackUsingQueuesV2<T> {
	
	private Queue<T> activeQueue;
	private Queue<T> inactiveQueue;
	
	public StackUsingQueuesV2() {
		activeQueue = new LinkedList<>();
		inactiveQueue = new LinkedList<>();
	}

	public void push(T item) {
		inactiveQueue.add(item);
		while(!activeQueue.isEmpty())
			inactiveQueue.add(activeQueue.poll());
		swapQueues();
	}
	
	public T pop() {
		if(isEmpty())
			throw new UnderflowException();
		
		return activeQueue.poll();
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
		
		return activeQueue.peek();
	}
}
