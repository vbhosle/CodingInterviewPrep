package com.leetcode.easy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.UniqueEmailAddresses;

public class UniqueEmailAddressesTest {

	private UniqueEmailAddresses solver;
	
	@Before
	public void setup() {
		solver = new UniqueEmailAddresses();
	}
	
	@Test
	public void nullOrEmptyReturnsZero() {
		assertThat(solver.numUniqueEmails(null), equalTo(0));
		assertThat(solver.numUniqueEmails(new String[0]), equalTo(0));
	}
	
	@Test
	public void leetCodeInputTest_1() {
		String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		assertThat(solver.numUniqueEmails(input), equalTo(2));
	}
	
	@Test
	public void leetCodeInputTest_2() {
		String[] input = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		assertThat(solver.numUniqueEmails(input), equalTo(3));
	}

}
