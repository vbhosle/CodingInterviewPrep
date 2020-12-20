package clrs.dp;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Ordering;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lislengthBruteForce;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lislengthBruteForceMemoized;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lisUsingLCSAlgorithm;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lisUsingPatienceSortStrictlyIncreasing;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.ceilIndex;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lisPatienceSortModifiedForNonDecreasing;
import static clrs.dp.LongestMonotonicallyIncreasingSubsequence.lisV1;

public class LongestMonotonicallyIncreasingSubsequenceTest {
	
	@Test
	public void lisLengthBruteForceTest() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 8)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			int actualLength = lislengthBruteForce(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), actualLength, equalTo(expectedLength));
		}	
	}
	
	@Test
	public void lisLengthBruteForceMemoizedTest() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 8)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			int actualLength = lislengthBruteForceMemoized(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), actualLength, equalTo(expectedLength));
		}	
	}
	
	@Test
	public void lisUsingLCSAlgorithmTest() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 8)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			List<Integer> outputIndexList = lisUsingLCSAlgorithm(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), outputIndexList.size(), equalTo(expectedLength));
			assertTrue(String.format("Output index list for %s is strictly increasing", inputList), Ordering.natural().isStrictlyOrdered(outputIndexList));
			assertTrue(String.format("Output sequence values for %s are monotonically increasing i.e non decreasing", inputList), Ordering.natural().onResultOf(inputList::get).isOrdered(outputIndexList));
		}	
	}
	

	@Test
	public void lisUsingPatienceSortStrictlyIncreasingTest() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 3)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			List<Integer> outputIndexList = lisUsingPatienceSortStrictlyIncreasing(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), outputIndexList.size(), equalTo(expectedLength));
			assertTrue(String.format("Output index list for %s is strictly increasing", inputList), Ordering.natural().isStrictlyOrdered(outputIndexList));
			assertTrue(String.format("Output sequence values for %s are strictly increasing", inputList), Ordering.natural().onResultOf(inputList::get).isStrictlyOrdered(outputIndexList));
		}	
	}

	@Test
	public void lisPatienceSortModifiedForNonDecreasingTest() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 8)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			List<Integer> outputIndexList = lisPatienceSortModifiedForNonDecreasing(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), outputIndexList.size(), equalTo(expectedLength));
			assertTrue(String.format("Output index list for %s is strictly increasing", inputList), Ordering.natural().isStrictlyOrdered(outputIndexList));
			assertTrue(String.format("Output sequence values for %s are monotonically increasing ie non decreasing", inputList), Ordering.natural().onResultOf(inputList::get).isOrdered(outputIndexList));
		}	
	}

	@Test
	public void lisV1Test() {
		List<Pair<List<Integer>, Integer>> params = Arrays.asList(
																	Pair.of(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
																			, 6)
																	, Pair.of(Arrays.asList(2, 6, 3, 4, 1, 2, 9, 5, 8)
																			, 5)
																	, Pair.of(Arrays.asList(2, 2, 2, 10, 10, 3, 3, 3, 4, 4)
																			, 8)
																	, Pair.of(ContiguousSet.closed(1, 20).asList()
																			, 20)
																); 
		for(Pair<List<Integer>, Integer> param: params) {
			List<Integer> inputList = param.getLeft();
			Integer expectedLength = param.getRight();
			List<Integer> outputIndexList = lisV1(inputList);
			assertThat(String.format("Longest increasing subsequece of %s has length %d", inputList, expectedLength), outputIndexList.size(), equalTo(expectedLength));
			assertTrue(String.format("Output index list for %s is strictly increasing", inputList), Ordering.natural().isStrictlyOrdered(outputIndexList));
			assertTrue(String.format("Output sequence values for %s are monotonically increasing i.e non decreasing", inputList), Ordering.natural().onResultOf(inputList::get).isOrdered(outputIndexList));
		}	
	}
	
	@Test
	public void ceilIndexTest() {
		List<Integer> values = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
		List<Integer> sortedIndexList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		
		for(int i = 0; i < values.size(); i++) {
			assertThat(String.format("Ceil of %d is %d", values.get(i), values.get(i)), ceilIndex(values, sortedIndexList, values.get(i)), equalTo(i));
		}
		
		for(int i = 0; i < values.size(); i++) {
			int searchValue = values.get(i) - 1;
			assertThat(String.format("Ceil of %d is %d", searchValue, values.get(i)), ceilIndex(values, sortedIndexList, searchValue), equalTo(i));
		}
		
		assertThat(ceilIndex(values, sortedIndexList, 91), equalTo(-1));
		
	}

}
