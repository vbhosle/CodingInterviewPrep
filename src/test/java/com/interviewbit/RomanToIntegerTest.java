package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanToIntegerTest {

	private RomanToInteger solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new RomanToInteger();
	}

	@Test
	public void one() {
		assertThat(solver.toInt("I"), equalTo(1));
	}
	
	@Test
	public void three() {
		assertThat(solver.toInt("III"), equalTo(3));
	}
	
	@Test
	public void four() {
		assertThat(solver.toInt("IV"), equalTo(4));
	}
	
	@Test
	public void nine() {
		assertThat(solver.toInt("IX"), equalTo(9));
	}
	
	@Test
	public void SevenEightySix() {
		assertThat(solver.toInt("DCCLXXXIX"), equalTo(789));
	}
	
	@Test
	public void ninety() {
		assertThat(solver.toInt("XC"), equalTo(90));
	}
	
	@Test
	public void ThreeNineNineNine() {
		assertThat(solver.toInt("MMMCMXCIX"), equalTo(3999));
	}


}
