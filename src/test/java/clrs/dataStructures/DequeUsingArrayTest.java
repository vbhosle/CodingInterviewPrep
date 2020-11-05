package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DequeUsingArrayTest {

	private DequeUsingArray deque;
	private static final int SIZE = 6;
	
	@Before
	public void setUp() throws Exception {
		deque = new DequeUsingArray(SIZE);
	}

	@Test
	public void testNewInstance() {
		assertTrue(deque.isEmpty());
		assertFalse(deque.isFull());
	}
	
	@Test
	public void addingAllFromHeadAndRemovingAllFromTail() {
		
		for(int cycle = 1; cycle <= 5; cycle++) {
			
			for(int i = 1; i < SIZE; i++) {
				deque.enqueueAtHead(i);
			}
			
			assertFalse(deque.isEmpty());
			assertTrue(deque.isFull());
			
			for(int i = 1; i < SIZE; i++) {
				assertEquals(i, deque.dequeAtTail());
			}
			
			assertTrue(deque.isEmpty());
			assertFalse(deque.isFull());
		}
		
	}
	
	@Test
	public void addingAllFromTailAndRemovingAllFromHead() {
		
		for(int cycle = 1; cycle <= 5; cycle++) {
			for(int i = 1; i < SIZE; i++) {
				deque.enqueueAtTail(i);
			}
			
			assertFalse(deque.isEmpty());
			assertTrue(deque.isFull());
			
			for(int i = 1; i < SIZE; i++) {
				assertEquals(i, deque.dequeAtHead());
			}
			
			assertTrue(deque.isEmpty());
			assertFalse(deque.isFull());
		}
	}
	
}
