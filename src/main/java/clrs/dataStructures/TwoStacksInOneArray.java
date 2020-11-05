package clrs.dataStructures;

public class TwoStacksInOneArray {

	private int[] items;
	private int top1;
	private int top2;
	
	public TwoStacksInOneArray(int size) {
		items = new int[size];
		top1 = -1;
		top2 = size;
	}
	
	public void pushStack1(int item) {
		if((top1 + 1) == top2)
			throw new OverflowException();
		
		items[++top1] = item;
	}

	public void pushStack2(int item) {
		if((top2 - 1) == top1)
			throw new OverflowException();
		
		items[--top2] = item;
	}
	
	public int popStack1() {
		if(top1 == -1)
			throw new UnderflowException();
		
		return items[top1--];
	}
	
	public int popStack2() {
		if(top2 == items.length)
			throw new UnderflowException();
		
		return items[top2++];
	}
}
