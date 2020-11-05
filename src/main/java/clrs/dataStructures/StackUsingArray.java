package clrs.dataStructures;

public class StackUsingArray<T> implements Stack<T>{

	private Object[] items; //can't create generic array in java, push ensure only correct object types are allowed
	private int top;
	
	public StackUsingArray(int size) {
		items = new Object[size];
		top = -1;
	}

	@Override
	public void push(T item) {
		if(top == (items.length - 1))
			throw new OverflowException();
		items[++top] = item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(isEmpty())
			throw new UnderflowException();
		return (T) items[top--];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if(!isEmpty())
			return (T) items[top];
		return null;
	}

	
}
