package com.crackingthecodinginterview.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CheckPermutationTest {

	private CheckPermutation solver;
	
	@Before
	public void setup() {
		solver = new CheckPermutation();
	}
	
	@Test
	public void differentLengthStringsReturnFalse() {
		solver.isPermutation("abc", "cbaa");
	}
	
	@Test
	public void stringsArePermutationOfEachOther() {
		solver.isPermutation("zebra", "rabez");
	}
	
	@Test
	public void stringsAreNOTPermutationOfEachOther() {
		solver.isPermutation("fight", "tight");
	}
	
}
