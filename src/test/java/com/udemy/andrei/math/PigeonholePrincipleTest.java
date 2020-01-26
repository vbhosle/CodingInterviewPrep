package com.udemy.andrei.math;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PigeonholePrincipleTest {

	private int n;
	
	public PigeonholePrincipleTest(int n) {
		this.n = n;
	}
	
	@Parameters(name="test {0}")
	public static Collection<Object[]> testData(){
		return Arrays.asList(
					new Object[][] {
							{2},
							{5},
							{25},
//							{Integer.MAX_VALUE/2000},
							{Integer.MAX_VALUE/1000},
							{Integer.MAX_VALUE/10},
							{Integer.MAX_VALUE},
					}
				);
	}
	
	@Test
	public void test() {
		String result = PigeonholePrinciple.findMultipleWithOnlyZeroAndOneDigits(n);
		assertThat(result, is(isDivisibleBy(n)));
		assertThat(result, hasZeroOrOne);
	}
	
	public static Matcher<String> isDivisibleBy(int n){
		return new DivisibilityMather(n);
	}
	
	public static class DivisibilityMather extends BaseMatcher<String>{
		private final BigInteger divisor;
		
		public DivisibilityMather(int divisor) {
			this.divisor = new BigInteger(Integer.toString(divisor));
		}
		
		public DivisibilityMather(Long expectedValue) {
			this.divisor = new BigInteger(Long.toString(expectedValue));
		}

		@Override
		public boolean matches(Object item) {
			BigInteger dividend = new BigInteger(item.toString());
			return dividend.mod(divisor) == BigInteger.ZERO;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("divisibility test");
		}
		
		@Override
		public void describeMismatch(Object item, Description description) {
			description.appendValue(item).appendText(" is not divisible by ").appendValue(divisor);
		}
		
	}
	
	public static final Matcher<String> hasZeroOrOne = new StringOfZeroOrOne();
	
	public static class StringOfZeroOrOne extends BaseMatcher<String>{

		@Override
		public boolean matches(Object item) {
			char[] chars = item.toString().toCharArray();
			for(char c: chars) {
				if(c != '0' && c != '1') return false;
			}
			return true;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("String of only zero or one");
		}
		
		@Override
		public void describeMismatch(Object item, Description description) {
			description.appendValue(item).appendText(" has digits other than 0 or 1");
		}
		
	}

}
