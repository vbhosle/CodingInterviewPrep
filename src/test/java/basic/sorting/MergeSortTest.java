package basic.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MergeSortTest {

	@Parameters(name="Test {index}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ null, null }
			, { new int[] { 1 }, new int[] { 1 } } 
			, { new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4, 5 } }
			, { new int[] { 3, 2, 3, 1, 2, 1 }, new int[] { 1, 1, 2, 2, 3, 3 } }
		});
	}

	private MergeSort sorter;
	
	public int[] expected;
	
	public int[] input;
	
	public MergeSortTest(int[] input, int[] expected) {
		this.input = input;
		this.expected = expected;
	}

	@Before
	public void setUp() throws Exception {
		sorter = new MergeSort();
	}

	@Test
	public void sortTest() {
		assertArrayEquals(expected,sorter.sort(input));
	}

}
