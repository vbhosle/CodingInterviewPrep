package com.hackerrank.dp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AbbrevationDPTest {

	@Test
	public void test01() {
		String a = "AbcDE";
		String b = "ABDE";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test02() {
		String a = "daBcd";
		String b = "ABC";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test03() {
		String a = "AbcDE";
		String b = "AFDE";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("NO"));
	}
	
	@Test
	public void test04() {
		String a = "dDdFknN";
		String b = "DFN";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("YES"));
	}
	
	@Test
	public void test05() {
		String a = "dDdFknN";
		String b = "DJN";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("NO"));
	}
	
	@Test
	public void test06() {
		String a = "dDdFknN";
		String b = "DF";
		assertThat(AbbrevationDP.abbreviation(a, b), equalTo("NO"));
	}

}
