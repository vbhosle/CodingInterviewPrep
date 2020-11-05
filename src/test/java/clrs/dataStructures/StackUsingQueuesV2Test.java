package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingQueuesV2Test {

	public static StackUsingQueuesV2<Integer> newStack() {
		return new StackUsingQueuesV2<>();
	}
	
	@Test
	public void stackIsEmptyWhenCreated() {
		StackUsingQueuesV2<Integer> stack = newStack();
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected = UnderflowException.class)
	public void testPoppedWhenEmptyException() {
		StackUsingQueuesV2<Integer> stack = newStack();
		stack.pop();
	}
	
	@Test
	public void testCoreStackOperations() {
		StackUsingQueuesV2<Integer> stack = newStack();
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
