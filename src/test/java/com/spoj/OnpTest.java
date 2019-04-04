package com.spoj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OnpTest {

	private Onp solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new Onp();
	}

	@Test
	public void test1() {
		assertThat(solver.infixTopostfix("a+(b*c)"), equalTo("abc*+"));
	}
	
	@Test
	public void test2() {
		assertThat(solver.infixTopostfix("(a+(b*c))"), equalTo("abc*+"));
	}
	
	@Test
	public void test3() {
		assertThat(solver.infixTopostfix("((a+b)*(z+x))"), equalTo("ab+zx+*"));
	}
	
	@Test
	public void test4() {
		assertThat(solver.infixTopostfix("((a+t)*((b+(a+c))^(c+d)))"), equalTo("at+bac++cd+^*"));
	}
	
	@Test
	public void test5() {
		assertThat(solver.infixTopostfix("a+(b*c-(d/e-f)*g)*h"), equalTo("abc*de/f-g*-h*+"));
	}

}
