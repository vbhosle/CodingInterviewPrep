package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clrs.dataStructures.DoublyLinkedList.Node;

public class DoublyLinkedListTest {
	
	DoublyLinkedList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new DoublyLinkedList<>();
	}

	@Test
	public void testInsertAtHead() {
		assertTrue(list.isEmpty());
		
		final int SIZE = 3;
		insertAtHeadOneTo(SIZE);  // Nil -> 3 -> 2 -> 1 -> Nil
		
		assertFalse(list.isEmpty());
		
		//iterate right to left
		Node<Integer> current = list.Nil.next;
		for(int i = SIZE; i >= 1; i--) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == list.Nil);
		
		//iterate left to right
		current = list.Nil.prev;
		for(int i = 1; i <= SIZE; i++) {
			assertEquals(new Integer(i), current.data);
			current = current.prev;
		}
		
		assertTrue(current == list.Nil);
	}
	
	@Test
	public void testInsertAtTail() {
		assertTrue(list.isEmpty());
		
		final int SIZE = 3;
		insertAtTailOneTo(SIZE);  // Nil -> 1 -> 2 -> 3 -> Nil
		
		assertFalse(list.isEmpty());
		
		//iterate right to left
		Node<Integer> current = list.Nil.next;
		for(int i = 1; i <= SIZE; i++) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == list.Nil);
		
		//iterate left to right
		current = list.Nil.prev;
		for(int i = SIZE; i >= 1; i--) {
			assertEquals(new Integer(i), current.data);
			current = current.prev;
		}
		
		assertTrue(current == list.Nil);
	}
	
	@Test
	public void testSearchNonExisting() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		Node<Integer> searchedItem = list.search(6);
		assertTrue(searchedItem == list.Nil);
	}
	
	@Test
	public void testSearchExisting() {
		final int SIZE = 5;
		insertAtTailOneTo(SIZE);
		
		Node<Integer> searchedItem = list.search(3);
		assertTrue(searchedItem.data == 3);
		assertTrue(searchedItem.prev.data == 2);
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
		Node<Integer> current = list.Nil.next;
		assertEquals(new Integer(1), current.data);
		
		current = current.next;
		assertEquals(new Integer(3), current.data);
		
		current = current.next;
		assertTrue(current == list.Nil);
		
		//iterate left to right
		current = list.Nil.prev;
		assertEquals(new Integer(3), current.data);
		
		current = current.prev;
		assertEquals(new Integer(1), current.data);
		
		current = current.prev;
		assertTrue(current == list.Nil);
		
	}
	
	@Test
	public void deleteNonExisting() {
		final int SIZE = 3;
		insertAtTailOneTo(SIZE);
		
		assertFalse(list.delete(20));
	}
	
	@Test
	public void testAppend() {
		insertAtTailOneTo(5);
		DoublyLinkedList<Integer> other = new DoublyLinkedList<>();
		for(int i = 6; i <= 10; i++)
			other.insertAtTail(i);
		
		list.append(other);
		
		Node<Integer> current = list.Nil.next;
		for(int i = 1; i <= 10; i++) {
			assertEquals(new Integer(i), current.data);
			current = current.next;
		}
		
		assertTrue(current == list.Nil);
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
