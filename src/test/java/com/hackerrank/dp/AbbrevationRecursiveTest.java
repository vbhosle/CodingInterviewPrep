package com.hackerrank.dp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AbbrevationRecursiveTest {

	@Test
	public void test01() {
		String a = "AbcDE";
		String b = "ABDE";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test02() {
		String a = "daBcd";
		String b = "ABC";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test03() {
		String a = "AbcDE";
		String b = "AFDE";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("NO"));
	}
	
	@Test
	public void test04() {
		String a = "dDdFknN";
		String b = "DFN";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test05() {
		String a = "dDdFknN";
		String b = "DJN";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("NO"));
	}
	
	@Test
	public void test06() {
		String a = "dDdFknN";
		String b = "DF";
		assertThat(AbbrevationRecursive.abbreviation(a, b), equalTo("NO"));
	}

}
