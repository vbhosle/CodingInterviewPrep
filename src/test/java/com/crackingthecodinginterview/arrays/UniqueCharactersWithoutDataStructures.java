package com.crackingthecodinginterview.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharactersWithoutDataStructures {

private UniqueCharacters solver;
	
	@Before
	public void setup() {
		solver = new UniqueCharacters();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullThrowsIllegalArgumentExceptio() {
		solver.hasUniqueCharactersWithoutAdditionalDataStructure(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void emptyStringThrowsIllegalArgumentException() {
		solver.hasUniqueCharactersWithoutAdditionalDataStructure("");
	}
	
	@Test
	public void uniqueCharactersInSmallString() {
		String str = "team";
		assertThat(solver.hasUniqueCharactersWithoutAdditionalDataStructure(str), equalTo(true));
	}
	
	@Test
	public void noUniqueCharactersInSmallString() {
		String str = "pokemon";
		assertThat(solver.hasUniqueCharactersWithoutAdditionalDataStructure(str), equalTo(false));
	}

	@Test
	public void uniqueCharactersInAlphabets() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		assertThat(solver.hasUniqueCharactersWithoutAdditionalDataStructure(str), equalTo(true));
	}
	
	@Test
	public void noUniqueCharactersInAlphabets() {
		String str = "abcdefghijklmnopqrstuvwxyza";
		assertThat(solver.hasUniqueCharactersWithoutAdditionalDataStructure(str), equalTo(false));
	}
}
