package com.spoj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class STparTest {

	private STpar solver;

	@Before
	public void setUp() throws Exception {
		solver = new STpar();
	}

	@Test
	public void NullReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(null), equalTo("no"));
	}

	@Test
	public void emptyReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] {}), equalTo("no"));
	}

	@Test
	public void _51243ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 5, 1, 2, 4, 3 }), equalTo("yes"));
	}
	
	@Test
	public void _41532ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 1, 5, 3, 2 }), equalTo("no"));
	}
	
	@Test
	public void _31254ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 1, 2, 5, 4 }), equalTo("yes"));
	}
	
	@Test
	public void _53214ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 5, 3, 2, 1, 4 }), equalTo("yes"));
	}
	
	@Test
	public void _1_2_10_5_4_3_7_6_8_9ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 2, 10, 5, 4, 3, 7, 6, 8, 9 }), equalTo("yes"));
	}
	
	@Test
	public void _1_2_10_5_4_3_9_8_7_6ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 2, 10, 5, 4, 3, 9, 8, 7, 6 }), equalTo("yes"));
	}
	
	@Test
	public void _35241ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 5, 2, 4, 1 }), equalTo("no"));
	}
	
	@Test
	public void _12435ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 2, 4, 3, 5 }), equalTo("yes"));
	}

	@Test
	public void _1234ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 2, 3, 4 }), equalTo("yes"));
	}

	@Test
	public void _1243ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 2, 4, 3 }), equalTo("yes"));
	}

	@Test
	public void _1324ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 3, 2, 4 }), equalTo("yes"));
	}

	@Test
	public void _1342ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 3, 4, 2 }), equalTo("no"));
	}

	@Test
	public void _1423ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 4, 2, 3 }), equalTo("yes"));
	}

	@Test
	public void _1432ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 1, 4, 3, 2 }), equalTo("yes"));
	}

	@Test
	public void _2134ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 1, 3, 4 }), equalTo("yes"));
	}

	@Test
	public void _2143ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 1, 4, 3 }), equalTo("yes"));
	}

	@Test
	public void _2314ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 3, 1, 4 }), equalTo("no"));
	}

	@Test
	public void _2341ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 3, 4, 1 }), equalTo("no"));
	}

	@Test
	public void _2413ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 4, 1, 3 }), equalTo("no"));
	}

	@Test
	public void _2431ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 2, 4, 3, 1 }), equalTo("no"));
	}

	@Test
	public void _3124ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 1, 2, 4 }), equalTo("yes"));
	}

	@Test
	public void _3142ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 1, 4, 2 }), equalTo("no"));
	}

	@Test
	public void _3214ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 2, 1, 4 }), equalTo("yes"));
	}

	@Test
	public void _3241ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 2, 4, 1 }), equalTo("no"));
	}

	@Test
	public void _3412ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 4, 1, 2 }), equalTo("no"));
	}

	@Test
	public void _3421ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 3, 4, 2, 1 }), equalTo("no"));
	}

	@Test
	public void _4123ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 1, 2, 3 }), equalTo("yes"));
	}

	@Test
	public void _4132ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 1, 3, 2 }), equalTo("yes"));
	}

	@Test
	public void _4213ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 2, 1, 3 }), equalTo("yes"));
	}

	@Test
	public void _4231ReturnsNo() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 2, 3, 1 }), equalTo("no"));
	}

	@Test
	public void _4312ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 3, 1, 2 }), equalTo("yes"));
	}

	@Test
	public void _4321ReturnsYes() {
		assertThat(solver.canReorderTrucksWithSideStreet(new int[] { 4, 3, 2, 1 }), equalTo("yes"));
	}

}
