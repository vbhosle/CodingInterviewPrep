package com.interviewbit;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class DistinctNumbersInWindowTest {

	@Parameters(name="Expected {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ null, 5, Collections.emptyList()},
			{ Collections.emptyList(), 5, Collections.emptyList()},
			{Arrays.asList(1, 2, 1, 3, 4, 3), 3, Arrays.asList(2, 3, 3, 2)}
		});
	}
	
	private DistinctNumbersInWindow solver = new DistinctNumbersInWindow();
	
	@Test
	public void nullReturnsEmptyList() {
		List<Integer> result = solver.dNums(null, 3);
		assertThat(result.size(), equalTo(0));
	}
	
	@Test
	public void emptyReturnsEmptyList() {
		List<Integer> result = solver.dNums(Collections.emptyList(), 3);
		assertThat(result.size(), equalTo(0));
	}

	@Test
	public void exampleTest() {
		List<Integer> result = solver.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3);
		assertThat(result, contains(2, 3, 3, 2));
	}
	
	@Test
	public void windowSizeOneTest() {
		List<Integer> result = solver.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 1);
		assertThat(result, contains(1, 1, 1, 1, 1, 1));
	}
	
	@Test
	public void windowSizeEqualToLengthTest() {
		List<Integer> result = solver.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 6);
		assertThat(result, contains(4));
	}
	
	@Test
	public void windowSizeGreaterThanLengthTest() {
		List<Integer> result = solver.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 10);
		assertThat(result, contains(4));
	}
	
	@Test
	public void test1() {
		List<Integer> result = solver.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 4);
		assertThat(result, contains(3, 4, 3));
	}
	
	@Test
	public void veryLongListTest() {
		final int windowSize = 4;
		List<Integer> inputList = IntStream.rangeClosed(1, 500000).boxed().collect(Collectors.toList());
		List<Integer> expected = IntStream.generate(() -> windowSize).boxed().limit(inputList.size() - windowSize + 1).collect(Collectors.toList());
		System.out.println("Calculating .. " + LocalDateTime.now());
		List<Integer> result = solver.dNums(inputList, windowSize);
		System.out.println("Done .. " + LocalDateTime.now());
		assertThat(result, contains(expected.toArray(new Integer[0])));
	}
}
