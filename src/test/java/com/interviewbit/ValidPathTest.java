package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ValidPathTest {

	private ValidPath solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new ValidPath();
	}

	@Test
	public void test01() {
		String result = solver.solve(2, 3, 1, 1, Arrays.asList(2), Arrays.asList(3));
		assertThat(result, equalTo("NO"));
	}

	@Test
	public void test02() {
		String result = solver.solve(41, 67, 5, 0, Arrays.asList(5, 17, 16, 12, 0, 40), Arrays.asList(5, 52, 61, 61, 25, 31));
		assertThat(result, equalTo("YES"));
	}
	
	@Test
	public void test03() {
		String result = solver.solve(5, 5, 2, 0, Arrays.asList(3,3), Arrays.asList(1,3));
		assertThat(result, equalTo("YES"));
	}
	

	@Test
	public void test04() {
		String result = solver.solve(41, 67, 1, 35, Arrays.asList(20), Arrays.asList(35));
		assertThat(result, equalTo("NO"));
	}

}
