package clrs.dataStructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwoStacksInOneArrayTest {
	
	private TwoStacksInOneArray twoStacks;
	private static final int SIZE = 6;

	@Before
	public void setUp() throws Exception {
		twoStacks = new TwoStacksInOneArray(SIZE);
	}

	@Test
	public void testCoreOperations() {
		twoStacks.pushStack1(1);
		twoStacks.pushStack1(2);
		twoStacks.pushStack1(3);
		
		twoStacks.pushStack2(10);
		twoStacks.pushStack2(20);
		twoStacks.pushStack2(30);
		
		assertEquals(30, twoStacks.popStack2());
		assertEquals(20, twoStacks.popStack2());
		
		twoStacks.pushStack1(4);
		twoStacks.pushStack1(5);
		
		assertEquals(10, twoStacks.popStack2());
		
		assertEquals(5, twoStacks.popStack1());
		assertEquals(4, twoStacks.popStack1());
		assertEquals(3, twoStacks.popStack1());
		assertEquals(2, twoStacks.popStack1());
		assertEquals(1, twoStacks.popStack1());
		
	}

}
