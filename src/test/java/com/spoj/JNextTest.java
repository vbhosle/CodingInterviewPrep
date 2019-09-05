package com.spoj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JNextTest {

	private JNext solver;

	@Before
	public void setUp() throws Exception {
		solver = new JNext();
	}

	@Test
	public void _24Returns42() {
		assertThat(solver.nextNumber(new int[] { 2, 4 }), equalTo(42L));
	}

	@Test
	public void _124Returns142() {
		assertThat(solver.nextNumber(new int[] { 1, 4, 2 }), equalTo(214L));
	}

	@Test
	public void _5142eturns5214() {
		assertThat(solver.nextNumber(new int[] { 5, 1, 4, 2 }), equalTo(5214L));
	}

	@Test
	public void _1554301returns1554310() {
		assertThat(solver.nextNumber(new int[] { 1, 5, 5, 4, 3, 0, 1 }), equalTo(1554310L));
	}

	@Test
	public void _15483Returns15834() {
		assertThat(solver.nextNumber(new int[] { 1, 5, 4, 8, 3 }), equalTo(15834L));
	}

	@Test
	public void _5655555555Returns6555555555() {
		assertThat(solver.nextNumber(new int[] { 5, 6, 5, 5, 5, 5, 5, 5, 5, 5 }), equalTo(6555555555L));
	}

	@Test
	public void _16543Returns31456() {
		assertThat(solver.nextNumber(new int[] { 1, 6, 5, 4, 3 }), equalTo(31456L));
	}

	@Test
	public void _1474584126Returns1474584162() {
		assertThat(solver.nextNumber(new int[] { 1, 4, 7, 4, 5, 8, 4, 1, 2, 6 }), equalTo(1474584162L));
	}

	@Test
	public void _11112222Returns11121222() {
		assertThat(solver.nextNumber(new int[] { 1, 1, 1, 1, 2, 2, 2, 2 }), equalTo(11121222L));
	}

	@Test
	public void _1000001Returns100010() {
		assertThat(solver.nextNumber(new int[] { 1, 0, 0, 0, 0, 0, 1 }), equalTo(1000010L));
	}

	@Test
	public void _1000002Returns100020() {
		assertThat(solver.nextNumber(new int[] { 1, 0, 0, 0, 0, 0, 2 }), equalTo(1000020L));
	}

	@Test
	public void _16875Returns18567() {
		assertThat(solver.nextNumber(new int[] { 1, 6, 8, 7, 5 }), equalTo(17568L));
	}

	@Test
	public void _10876Returns16078() {
		assertThat(solver.nextNumber(new int[] { 1, 0, 8, 7, 6 }), equalTo(16078L));
	}
	
	@Test
	public void _534976Returns16078() {
		assertThat(solver.nextNumber(new int[] { 5, 3, 4, 9, 7, 6 }), equalTo(536479L));
	}
	
	@Test
	public void _218765Returns16078() {
		assertThat(solver.nextNumber(new int[] { 2, 1, 8, 7, 6, 5 }), equalTo(251678L));
	}
	
	@Test
	public void _19170Returns16078() {
		assertThat(solver.nextNumber(new int[] { 1, 9, 1, 7, 0 }), equalTo(19701L));
	}
	
	@Test
	public void _1234567849876554321Returns1234567851234456789() {
		assertThat(solver.nextNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 4, 9, 8, 7, 6,5, 5, 4, 3, 2, 1 }), equalTo(1234567851234456789L));
	}

	@Test
	public void _nullReturnsNegative1() {
		assertThat(solver.nextNumber(null), equalTo(-1L));
	}

	@Test
	public void _emptyReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] {}), equalTo(-1L));
	}

	@Test
	public void _5ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 5 }), equalTo(-1L));
	}

	@Test
	public void _900ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 9, 0, 0 }), equalTo(-1L));
	}
	
	@Test
	public void _999ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 9, 9, 9 }), equalTo(-1L));
	}

	@Test
	public void _741ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 7, 4, 1 }), equalTo(-1L));
	}

	@Test
	public void _54321ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 5, 4, 3, 2, 1 }), equalTo(-1L));
	}

	@Test
	public void _1554301ReturnsNegative1() {
		assertThat(solver.nextNumber(new int[] { 1, 5, 5, 4, 3, 0, 1 }), equalTo(1554310L));
	}

}
