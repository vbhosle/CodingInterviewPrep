package com.techgig;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BuyingSweetsTest {

	@Parameters(name="sum={1}")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[]{5},25L},
			{new int[]{1,2,3},53L},
			{new int[]{1000000008,1000000008},4L},
			{IntStream.generate(() -> 9).limit(100000000).toArray(),526500000L},
//			{{},},
//			{{},},
		});
	}
	
	private BuyingSweets solver = new BuyingSweets();
	
	public int[] sweets;
	
	public long sum;
	
	
	public BuyingSweetsTest(int[] sweets, long sum) {
		this.sweets = sweets;
		this.sum = sum;
	}

	@Ignore
	@Test
	public void recursive() {
		assertThat(solver.sumOfPossibleCosts(sweets), equalTo(sum));
	}
	
	@Ignore
	@Test
	public void forLoop() {
		assertThat(solver.sumOfCostBruteForce(sweets), equalTo(sum));
	}
	
	@Test
	public void formula() {
		assertThat(solver.sumOfCostFormula(sweets), equalTo(sum));
	}

}
