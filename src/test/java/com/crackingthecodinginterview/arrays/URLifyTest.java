package com.crackingthecodinginterview.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class URLifyTest {

	private URLify solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new URLify();
	}

	@Test
	public void singleSpaceEncoded() {
		assertThat(solver.encodeSpaces("   ", 1), equalTo("%20"));
	}
	
	@Test
	public void bookExample() {
		assertThat(solver.encodeSpaces("Mr John Smith    ", 13), equalTo("Mr%20John%20Smith"));
	}

}
