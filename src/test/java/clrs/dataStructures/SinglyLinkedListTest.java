package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clrs.dataStructures.SinglyLinkedList.Node;

public class SinglyLinkedListTest {
	
	SinglyLinkedList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new SinglyLinkedList<>();
	}

	@Test
	public void testInsertAtHead() {
		assertTrue(list.isEmpty());
		
		final int SIZE = 3;
		insertAtHeadOneTo(SIZE);  // Nil -> 3 -> 2 -> 1 -> Nil
		
		assertFalse(list.isEmpty());
		
		//iterate right to left
		Node<Integer> current = list.head;
		for(int i = SIZE; i >= 1; i--) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == null);
	}
	
	@Test
	public void testInsertAtTail() {
		assertTrue(list.isEmpty());
		
		final int SIZE = 3;
		insertAtTailOneTo(SIZE);  // Nil -> 1 -> 2 -> 3 -> Nil
		
		assertFalse(list.isEmpty());
		
		//iterate right to left
		Node<Integer> current = list.head;
		for(int i = 1; i <= SIZE; i++) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == null);
	}
	
	@Test
	public void testSearchNonExisting() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		Node<Integer> searchedItem = list.search(6);
		assertTrue(searchedItem == null);
	}
	
	@Test
	public void testSearchExisting() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		Node<Integer> searchedItem = list.search(3);
		assertTrue(searchedItem.data == 3);
		assertTrue(searchedItem.next.data == 4);
	}
	
	@Test
	public void testDeleteNodesFromLeftToRight() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		for(int i = 1; i <= SIZE; i++) {
			assertTrue(list.delete(i));
		}
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testDeleteNodesFromRightToLeft() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		for(int i = SIZE; i >= 1; i--) {
			assertTrue(list.delete(i));
		}
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testDeleteMiddleItem() {
		final int SIZE = 3;
		insertAtTailOneTo(SIZE);
		
		assertTrue(list.delete(2));
		
		//iterate right to left
		Node<Integer> current = list.head;
		assertEquals(new Integer(1), current.data);
		
		current = current.next;
		assertEquals(new Integer(3), current.data);
		
		current = current.next;
		assertTrue(current == null);
		
	}
	
	@Test
	public void testReverse() {
		insertAtTailOneTo(5);
		list.reverse();
		
		Node<Integer> current = list.head;
		for(int i = 5; i >= 1; i--) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == null);
		
		list.reverse();
		current = list.head;
		for(int i = 1; i <= 5; i++) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == null);
		
	}
	
	private void insertAtTailOneTo(int n) {
		for(int i = 1; i <= n; i++)
			list.insertAtTail(i);
	}
	
	private void insertAtHeadOneTo(int n) {
		for(int i = 1; i <= n; i++)
			list.insertAtHead(i);
	}

}
