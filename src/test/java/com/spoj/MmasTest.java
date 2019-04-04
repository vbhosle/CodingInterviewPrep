package com.spoj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MmasTest {

	private Mmas solver;

	@Before
	public void setUp() throws Exception {
		solver = new Mmas();
	}
	

	@Test
	public void edgeTest1() {
		assertThat(solver.getMolecularMassOf("(())5"), equalTo(0));
	}

	@Test
	public void simpleTest1() {
		assertThat(solver.getMolecularMassOf("COOH"), equalTo(45));
	}

	@Test
	public void simpleTest2() {
		assertThat(solver.getMolecularMassOf("CO2H2"), equalTo(46));
	}

	@Test
	public void simpleTest3() {
		assertThat(solver.getMolecularMassOf("C"), equalTo(12));
	}

	@Test
	public void groupTest1() {
		assertThat(solver.getMolecularMassOf("CO(OH)"), equalTo(45));
	}

	@Test
	public void groupTest2() {
		assertThat(solver.getMolecularMassOf("CH(CO2H)3"), equalTo(148));
	}

	@Test
	public void groupTest3() {
		assertThat(solver.getMolecularMassOf("((CH)2(OH2H)(C(H))O)3"), equalTo(222));
	}

	@Test
	public void groupTest4() {
		assertThat(solver.getMolecularMassOf("((((C))))"), equalTo(12));
	}

	@Test
	public void groupTest5() {
		assertThat(solver.getMolecularMassOf("((((C2))))"), equalTo(12 * 2));
	}

	@Test
	public void groupTest6() {
		assertThat(solver.getMolecularMassOf("((((C))2))"), equalTo(12 * 2));
	}

	@Test
	public void groupTest7() {
		assertThat(solver.getMolecularMassOf("((((C))(O)2))2"), equalTo(88));
	}

}
