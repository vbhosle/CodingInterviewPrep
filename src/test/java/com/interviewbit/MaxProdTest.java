package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxProdTest {

	@Parameters(name="Expected {1}")
	public static Collection<Object[]> data() {
		ArrayList<Integer> bigList = IntStream.generate(()-> 10).limit(100000).boxed().collect(Collectors.toCollection(ArrayList::new));
		bigList.set(bigList.size()-3, 11);
		bigList.set(bigList.size()-1, 11);
		return Arrays.asList(new Object[][] { 
				{Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9), 80},
				{Arrays.asList(6, 7, 9, 5, 5, 8), 10},
				{Arrays.asList(10,10,10,10), 0},
				{bigList, 999599940}
		});
	}
	
	private MaxProd solver = new MaxProd();
	
	public List<Integer> input;
	
	public int expected;
	
	public MaxProdTest(List<Integer> input, int expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test() {
		assertThat(solver.maxSpecialProduct(input), equalTo(expected));
	}

}
