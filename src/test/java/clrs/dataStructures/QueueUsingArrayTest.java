package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueUsingArrayTest {

	static final int SIZE = 5;
	QueueUsingArray queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new QueueUsingArray(SIZE);
	}

	@Test
	public void testCircularQueue() {
		
		for(int cycle = 1; cycle <= 2; cycle++) {
			assertTrue(queue.isEmpty());
			assertFalse(queue.isFull());
			
			for(int i = 1; i < SIZE; i++)
				queue.enqueue(i);
			
			assertFalse(queue.isEmpty());
			assertTrue(queue.isFull());
			
			for(int i = 1; i < SIZE; i++)
				assertEquals(i, queue.dequeue());
		}
		
		assertTrue(queue.isEmpty());
	}
}
