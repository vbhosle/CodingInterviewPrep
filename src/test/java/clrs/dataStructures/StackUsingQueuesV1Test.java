package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingQueuesV1Test {

	public static StackUsingQueuesV1<Integer> newStack() {
		return new StackUsingQueuesV1<>();
	}
	
	@Test
	public void stackIsEmptyWhenCreated() {
		StackUsingQueuesV1<Integer> stack = newStack();
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected = UnderflowException.class)
	public void testPoppedWhenEmptyException() {
		StackUsingQueuesV1<Integer> stack = newStack();
		stack.pop();
	}
	
	@Test
	public void testCoreStackOperations() {
		StackUsingQueuesV1<Integer> stack = newStack();
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
		
		assertTrue(stack.isEmpty());
	}

}
