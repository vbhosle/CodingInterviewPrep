package com.codechef.cakewalk;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TrisqTest {

	@Parameters(name="Triangle with base {0} can have max {2} squares of length {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{1, 2, 0},
				{2, 2, 0},
				{3, 2, 0},
				{4, 2, 1},
				{5, 2, 1},
				{6, 2, 3},
				{7, 2, 3},
				{8, 2, 6},
				{9, 2, 6},
				{10, 2, 10},
				{11, 2, 10}
		});
	}

	private Trisq solver = new Trisq();

	public int base;

	public int squareLen;

	public int maxSquares;

	public TrisqTest(int base, int squareLen, int maxSquares) {
		this.base = base;
		this.squareLen = squareLen;
		this.maxSquares = maxSquares;
	}

	@Before
	public void setUp() throws Exception {
		solver = new Trisq();
	}

	@Test
	public void test() {
		assertThat(solver.maxSquaresTriangle(base, squareLen), equalTo(maxSquares));
	}

}
