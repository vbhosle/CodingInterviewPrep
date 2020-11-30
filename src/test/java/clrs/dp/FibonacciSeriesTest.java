package clrs.dp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Ignore;
import org.junit.Test;

public class FibonacciSeriesTest {

	public void testFibonacci(Function<Integer, Long> fibonacciFunction, List<Pair<Integer, Long>> params) {
		for(Pair<Integer, Long> param: params) {
			int n = param.getLeft();
			long expected = param.getRight();
			assertThat(String.format("fib(%d) = %d", n, expected), fibonacciFunction.apply(n), equalTo(expected));
		}
	}
	
	@Test
	public void fibonacciRecursive() {
		List<Pair<Integer, Long>> params = Arrays.asList(Pair.of(14, 377L)
														 , Pair.of(21, 10946L)
														 , Pair.of(44, 701408733L));
		
		testFibonacci(FibonacciSeries::fibonacciRecursive, params);
	}
	
	@Ignore("Takes long to execute")
	@Test
	public void fibonacci() {
		List<Pair<Integer, Long>> params = Arrays.asList(Pair.of(14, 377L)
														 , Pair.of(21, 10946L)
														 , Pair.of(44, 701408733L));
		
		testFibonacci(FibonacciSeries::fibonacciBruteForce, params);
	}
	
	@Test
	public void fibonacciIterativeV1() {
		List<Pair<Integer, Long>> params = Arrays.asList(Pair.of(14, 377L)
														 , Pair.of(21, 10946L)
														 , Pair.of(44, 701408733L));
		
		testFibonacci(FibonacciSeries::fibonacciIterativeV1, params);
	}
	
	@Test
	public void fibonacciIterativeV2() {
		List<Pair<Integer, Long>> params = Arrays.asList(Pair.of(14, 377L)
														 , Pair.of(21, 10946L)
														 , Pair.of(44, 701408733L));
		
		testFibonacci(FibonacciSeries::fibonacciIterativeV2, params);
	}
}
