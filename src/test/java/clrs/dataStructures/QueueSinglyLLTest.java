package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueSinglyLLTest {

	private static final int CYCLES = 2;
	private static final int ITEMS = 5;
	
	private QueueUsingSinglyLL<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new QueueUsingSinglyLL<>();
	}

	@Test
	public void testQueueOperations() {
		
		for(int cycle = 1; cycle <= CYCLES; cycle++) {
			assertTrue(queue.isEmpty());
			
			for(int i = 1; i <= ITEMS; i++)
				queue.enqueue(i);
			
			assertFalse(queue.isEmpty());
			
			for(int i = 1; i <= ITEMS; i++)
				assertEquals(new Integer(i), queue.dequeue());
		}
		
		assertTrue(queue.isEmpty());
	}

}
