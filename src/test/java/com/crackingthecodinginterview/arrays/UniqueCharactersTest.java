package com.crackingthecodinginterview.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueCharactersTest {

	private UniqueCharacters solver;
	
	@Before
	public void setup() {
		solver = new UniqueCharacters();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullThrowsIllegalArgumentExceptio() {
		solver.hasUniqueCharacters(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void emptyStringThrowsIllegalArgumentException() {
		solver.hasUniqueCharacters("");
	}
	
	@Test
	public void uniqueCharactersInSmallString() {
		String str = "team";
		assertThat(solver.hasUniqueCharacters(str), equalTo(true));
		assertThat(solver.hasUniqueCharactersAtoZ(str), equalTo(true));
	}
	
	@Test
	public void noUniqueCharactersInSmallString() {
		String str = "pokemon";
		assertThat(solver.hasUniqueCharacters(str), equalTo(false));
		assertThat(solver.hasUniqueCharactersAtoZ(str), equalTo(false));
	}

	@Test
	public void uniqueCharactersInAlphabets() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		assertThat(solver.hasUniqueCharacters(str), equalTo(true));
		assertThat(solver.hasUniqueCharactersAtoZ(str), equalTo(true));
	}
	
	@Test
	public void noUniqueCharactersInAlphabets() {
		String str = "abcdefghijklmnopqrstuvwxyza";
		assertThat(solver.hasUniqueCharacters(str), equalTo(false));
		assertThat(solver.hasUniqueCharactersAtoZ(str), equalTo(false));
	}

}
