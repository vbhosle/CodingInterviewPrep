package clrs.dataStructures;

import java.util.Stack;

public class QueueUsingTwoStacks<T> {

	private Stack<T> outStack;
	private Stack<T> inStack;
	
	public QueueUsingTwoStacks() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}
	
	public void enqueue(T item) {
		inStack.push(item);
	}
	
	public T dequeue() {
		if(isEmpty())
			throw new UnderflowException();
		
		if(outStack.isEmpty())
			while(!inStack.isEmpty())
				outStack.push(inStack.pop());
		
		return outStack.pop();
	}
	
	public boolean isEmpty() {
		return this.outStack.isEmpty() && this.inStack.isEmpty();
	}
}
