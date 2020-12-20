package clrs.dp;

import static clrs.dp.BreakingAString.breakStringBruteForce;
import static clrs.dp.BreakingAString.breakStringMemoized;
import static clrs.dp.BreakingAString.breakString;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BreakingAStringTest {

	@Test
	public void breakStringBruteForceTest() {
		List<Triple<Integer, Set<Integer>, Integer>> params = Arrays.asList(
																  Triple.of(20, ImmutableSet.of(2, 8, 10), 38)
																  //,Triple.of(16, IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toSet()), 64) // too slow
																	);
		
		for(Triple<Integer, Set<Integer>, Integer> param: params) {
			int stringLength = param.getLeft();
			Set<Integer> breakPoints = param.getMiddle();
			int expectedMinCost = param.getRight();
			assertThat(String.format("Min cost of breaking %s at breakpoints %s is %d", stringLength, breakPoints, expectedMinCost), 
						breakStringBruteForce(stringLength, breakPoints), equalTo(expectedMinCost));
		}
	}
	
	@Test
	public void breakStringMemoizedTest() {
		List<Triple<Integer, Set<Integer>, Integer>> params = Arrays.asList(
																  	Triple.of(20, ImmutableSet.of(2, 8, 10), 38),
																  	Triple.of(16, IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toSet()), 64)
																	);
		
		for(Triple<Integer, Set<Integer>, Integer> param: params) {
			int stringLength = param.getLeft();
			Set<Integer> breakPoints = param.getMiddle();
			int expectedMinCost = param.getRight();
			assertThat(String.format("Min cost of breaking %s at breakpoints %s is %d", stringLength, breakPoints, expectedMinCost), 
					breakStringMemoized(stringLength, breakPoints), equalTo(expectedMinCost));
		}
	}
	
	@Test
	public void breakStringTest() {
		List<Triple<Integer, Set<Integer>, Pair<Integer, List<Integer>>>> params = Arrays.asList(
																  	Triple.of(20, ImmutableSet.of(2, 8, 10), Pair.of(38, Arrays.asList(10, 2, 8))),
																  	Triple.of(16, IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toSet()), Pair.of(64, Arrays.asList(8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15)))
																	);
		
		for(Triple<Integer, Set<Integer>, Pair<Integer, List<Integer>>> param: params) {
			int stringLength = param.getLeft();
			Set<Integer> breakPoints = param.getMiddle();
			int expectedMinCost = param.getRight().getKey();
			List<Integer> expectedCuts = param.getRight().getValue();
			
			Pair<Integer, List<Integer>> actualResult = breakString(stringLength, breakPoints);
			int actualCost = actualResult.getKey();
			List<Integer> actualCuts = actualResult.getValue();
			
			assertThat(String.format("Min cost of breaking a string of length %d at breakpoints %s is %d", stringLength, breakPoints, expectedMinCost), 
					actualCost, equalTo(expectedMinCost));
			
			assertThat(String.format("Min cost cuts for breaking a string of length %d at breakpoints %s are %s", stringLength, breakPoints, expectedCuts),
						actualCuts, equalTo(expectedCuts));
		}
	}

}
