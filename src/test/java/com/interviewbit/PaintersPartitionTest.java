package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PaintersPartitionTest {

	private PaintersPartition solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new PaintersPartition();
	}

	@Test
	public void test1() {
		int actual = solver.paint(2, 5,Arrays.asList(1,10));
		assertThat(actual, equalTo(50));
	}
	
	@Test
	public void test2() {
		int actual = solver.paint(2, 5,Arrays.asList(10,20,30,40));
		assertThat(actual, equalTo(300));
	}

	@Test
	public void test3() {
		int actual = solver.paint(4, 5,Arrays.asList(10,10,10,10,10,10,10,10));
		assertThat(actual, equalTo(20*5));
	}
	
	@Test
	public void test4() {
		int actual = solver.paint(5, 10,Arrays.asList(658, 786, 531, 47, 169, 397, 914));
		assertThat(actual, equalTo(9140));
	}
	
	@Test
	public void test5() {
		int actual = solver.paint(4, 10,Arrays.asList(884, 228, 442, 889));
		assertThat(actual, equalTo(8890));
	}
	
	@Test
	public void test6() {
		int actual = solver.paint(1, 1000000,Arrays.asList(1000000,1000000));
		assertThat(actual, equalTo(9400003));
	}

}
