package clrs.dp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

public class RodCutProblemTest {

	public void testBruteForceRodCut(BiFunction<Integer, List<Integer>, Long> rodCutMethod, List<Triple<Integer, List<Integer>, Long>> testParams) {
		for(Triple<Integer, List<Integer>, Long> testParam: testParams) {
			int length = testParam.getLeft();
			List<Integer> prices = testParam.getMiddle();
			long expectedMaxRevenue = testParam.getRight();
			
			assertThat(String.format("Max revenue by cutting rod of length %d and with prices %s is %d", length, prices.toString(), expectedMaxRevenue)
						, rodCutMethod.apply(length, prices)
						, equalTo(expectedMaxRevenue));
		}
	}
	
	@Test
	public void bruteForceRodCut() {
		List<Integer> prices = Arrays.asList(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30);
		
		List<Triple<Integer, List<Integer>, Long>> testParams = Arrays.asList(
																	Triple.of(1, prices, 1L)
																	, Triple.of(2, prices, 5L)
																	, Triple.of(3, prices, 8L)
																	, Triple.of(4, prices, 10L)
																	, Triple.of(5, prices, 13L)
																	, Triple.of(6, prices, 17L)
																	, Triple.of(7, prices, 18L)
																	, Triple.of(8, prices, 22L)
																	, Triple.of(9, prices, 25L)
																	, Triple.of(10, prices, 30L)
																);
		testBruteForceRodCut(RodCutProblem::bruteForceRodCut, testParams);
	}
	
	@Test
	public void recursiveMemoizedRodCut() {
		List<Integer> prices = Arrays.asList(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30);
		
		List<Triple<Integer, List<Integer>, Long>> testParams = Arrays.asList(
																	Triple.of(1, prices, 1L)
																	, Triple.of(2, prices, 5L)
																	, Triple.of(3, prices, 8L)
																	, Triple.of(4, prices, 10L)
																	, Triple.of(5, prices, 13L)
																	, Triple.of(6, prices, 17L)
																	, Triple.of(7, prices, 18L)
																	, Triple.of(8, prices, 22L)
																	, Triple.of(9, prices, 25L)
																	, Triple.of(10, prices, 30L)
																);
		testBruteForceRodCut(RodCutProblem::recursiveMemoizedRodCut, testParams);
	}

	@Test
	public void interativeDpRodCut() {
		List<Integer> prices = Arrays.asList(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30);
		
		List<Triple<Integer, List<Integer>, Long>> testParams = Arrays.asList(
																	Triple.of(1, prices, 1L)
																	, Triple.of(2, prices, 5L)
																	, Triple.of(3, prices, 8L)
																	, Triple.of(4, prices, 10L)
																	, Triple.of(5, prices, 13L)
																	, Triple.of(6, prices, 17L)
																	, Triple.of(7, prices, 18L)
																	, Triple.of(8, prices, 22L)
																	, Triple.of(9, prices, 25L)
																	, Triple.of(10, prices, 30L)
																);
		testBruteForceRodCut(RodCutProblem::interativeDpRodCut, testParams);
	}

	@Test
	public void interativeDpRodCutWithReconstructedSolution() {
		List<Integer> prices = Arrays.asList(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30);
		
		List<Triple<Integer, List<Integer>, Pair<Long, List<Integer>>>> testParams = Arrays.asList(
																	Triple.of(1, prices, Pair.of(1L, Arrays.asList(1)))
																	, Triple.of(2, prices, Pair.of(5L, Arrays.asList(2)))
																	, Triple.of(3, prices, Pair.of(8L, Arrays.asList(3)))
																	, Triple.of(4, prices, Pair.of(10L, Arrays.asList(2, 2)))
																	, Triple.of(5, prices, Pair.of(13L, Arrays.asList(2, 3)))
																	, Triple.of(6, prices, Pair.of(17L, Arrays.asList(6)))
																	, Triple.of(7, prices, Pair.of(18L, Arrays.asList(1, 6)))
																	, Triple.of(8, prices, Pair.of(22L, Arrays.asList(2, 6)))
																	, Triple.of(9, prices, Pair.of(25L, Arrays.asList(3, 6)))
																	, Triple.of(10, prices, Pair.of(30L, Arrays.asList(10)))
																);
		
		for(Triple<Integer, List<Integer>, Pair<Long, List<Integer>>> testParam: testParams) {
			int length = testParam.getLeft();
			List<Integer> priceList = testParam.getMiddle();
			long expectedMaxRevenue = testParam.getRight().getLeft();
			List<Integer> expectedCuts = testParam.getRight().getRight();
			
			Pair<Long, List<Integer>> result = RodCutProblem.interativeDpRodCutWithReconstructedSolution(length, priceList);
			assertThat(String.format("Max revenue by cutting rod of length %d and with prices %s is %d", length, priceList.toString(), expectedMaxRevenue)
						, result.getLeft()
						, equalTo(expectedMaxRevenue));
			assertThat(String.format("Optimal cuts for rod of length %d and with prices %s are %s", length, priceList.toString(), expectedCuts.toString())
					, result.getRight()
					, equalTo(expectedCuts));
		}
	}
	
	@Test
	public void interativeDpRodCutWithCost() {
		List<Integer> prices = Arrays.asList(0, 1, 5, 8, 9, 10, 17, 17, 19, 24, 30);
		
		List<Triple<Integer, List<Integer>, Pair<Long, List<Integer>>>> testParams = Arrays.asList(
																	Triple.of(1, prices, Pair.of(1L, Arrays.asList(1)))
																	, Triple.of(2, prices, Pair.of(5L, Arrays.asList(2)))
																	, Triple.of(3, prices, Pair.of(8L, Arrays.asList(3)))
																	, Triple.of(4, prices, Pair.of(9L, Arrays.asList(4)))
																	, Triple.of(5, prices, Pair.of(11L, Arrays.asList(2, 3)))
																	, Triple.of(6, prices, Pair.of(17L, Arrays.asList(6)))
																	, Triple.of(7, prices, Pair.of(17L, Arrays.asList(7)))
																	, Triple.of(8, prices, Pair.of(20L, Arrays.asList(2, 6)))
																	, Triple.of(9, prices, Pair.of(24L, Arrays.asList(9)))
																	, Triple.of(10, prices, Pair.of(30L, Arrays.asList(10)))
																);
		
		for(Triple<Integer, List<Integer>, Pair<Long, List<Integer>>> testParam: testParams) {
			int length = testParam.getLeft();
			List<Integer> priceList = testParam.getMiddle();
			long expectedMaxRevenue = testParam.getRight().getLeft();
			List<Integer> expectedCuts = testParam.getRight().getRight();
			
			Pair<Long, List<Integer>> result = RodCutProblem.interativeDpRodCutWithCost(length, priceList, 2);
			assertThat(String.format("Max revenue by cutting rod of length %d and with prices %s is %d", length, priceList.toString(), expectedMaxRevenue)
						, result.getLeft()
						, equalTo(expectedMaxRevenue));
			assertThat(String.format("Optimal cuts for rod of length %d and with prices %s are %s", length, priceList.toString(), expectedCuts.toString())
					, result.getRight()
					, equalTo(expectedCuts));
		}
	}
}
