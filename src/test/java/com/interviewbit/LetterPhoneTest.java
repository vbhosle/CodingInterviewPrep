package com.interviewbit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LetterPhoneTest {

	private LetterPhone solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new LetterPhone();
	}

	@Test
	public void test01() {
		String input = "2";
		List<String> expected = Arrays.asList("a", "b", "c");
		List<String> actual = solver.letterCombinations(input);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test02() {
		String input = "23";
		List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
		List<String> actual = solver.letterCombinations(input);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test03() {
		String input = "2468";
		List<String> expected = Arrays.asList("agmt", "agmu", "agmv", "agnt", "agnu", "agnv", "agot", "agou", "agov", "ahmt", "ahmu", "ahmv", "ahnt", "ahnu", "ahnv", "ahot", "ahou", "ahov", "aimt", "aimu", "aimv", "aint", "ainu", "ainv", "aiot", "aiou", "aiov", "bgmt", "bgmu", "bgmv", "bgnt", "bgnu", "bgnv", "bgot", "bgou", "bgov", "bhmt", "bhmu", "bhmv", "bhnt", "bhnu", "bhnv", "bhot", "bhou", "bhov", "bimt", "bimu", "bimv", "bint", "binu", "binv", "biot", "biou", "biov", "cgmt", "cgmu", "cgmv", "cgnt", "cgnu", "cgnv", "cgot", "cgou", "cgov", "chmt", "chmu", "chmv", "chnt", "chnu", "chnv", "chot", "chou", "chov", "cimt", "cimu", "cimv", "cint", "cinu", "cinv", "ciot", "ciou", "ciov");
		List<String> actual = solver.letterCombinations(input);
		assertThat(actual, is(expected));
	}
	
	@Test(timeout=500)
	public void performance01() {
		String input = "0123456789";
		solver.letterCombinations(input);
	}

}
