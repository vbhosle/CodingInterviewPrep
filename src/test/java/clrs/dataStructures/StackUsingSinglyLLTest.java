package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingSinglyLLTest {


	public static Stack<Integer> newStack() {
		return new StackUsingSinglyLL<>(); 
	}
	
	@Test
	public void stackIsEmptyWhenCreated() {
		Stack<Integer> stack = newStack();
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected = UnderflowException.class)
	public void testPoppedWhenEmptyException() {
		Stack<Integer> stack = newStack();
		stack.pop();
	}

	@Test
	public void testCoreStackOperations() {
		Stack<Integer> stack = newStack();
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
