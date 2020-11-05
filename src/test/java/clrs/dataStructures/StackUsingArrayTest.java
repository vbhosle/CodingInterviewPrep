package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingArrayTest {


	public static Stack<Integer> newStack(int size) {
		return new StackUsingArray<>(size); //plug your implementation to test
	}
	
	@Test
	public void stackIsEmptyWhenCreated() {
		Stack<Integer> stack = newStack(5);
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected = UnderflowException.class)
	public void testPoppedWhenEmptyException() {
		Stack<Integer> stack = newStack(5);
		stack.pop();
	}
	
//	@Ignore // ignore for stack implementation without the size limit
	@Test(expected = OverflowException.class)
	public void pushToAFullStackThrowsStackOverflowException() {
		Stack<Integer> stack = newStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
	}
	
	@Test
	public void testCoreStackOperations() {
		Stack<Integer> stack = newStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		assertFalse(stack.isEmpty());
		assertThat(stack.peek(), equalTo(5));
		assertThat(stack.pop(), equalTo(5));
		
		assertThat(stack.peek(), equalTo(4));
		assertThat(stack.pop(), equalTo(4));
		
		assertThat(stack.peek(), equalTo(3));
		assertThat(stack.pop(), equalTo(3));
		
		assertThat(stack.peek(), equalTo(2));
		assertThat(stack.pop(), equalTo(2));
		
		assertThat(stack.peek(), equalTo(1));
		assertThat(stack.pop(), equalTo(1));
		
		assertThat(stack.peek(), nullValue());
		assertTrue(stack.isEmpty());
	}

}
