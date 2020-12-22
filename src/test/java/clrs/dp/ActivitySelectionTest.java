package clrs.dp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

public class ActivitySelectionTest {

	@Test
	public void maxCompatibleActivitiesTest() {
		List<Pair<int[][], Integer>> params = Arrays.asList(
																Pair.of(new int[][] {{1, 2}}, 1),
																Pair.of(new int[][] {{1,2},{2,3},{3,4},{1,3}}, 3),
																Pair.of(new int[][] {{1, 2}, {1, 2}, {1, 2}}, 1),
																Pair.of(new int[][] {{1, 100}, {11, 22}, {1, 11} , {2, 12}}, 2)
																);

		for(Pair<int[][], Integer> param: params) {
			int[][] intervals = param.getKey();
			int expectedCount = param.getValue();
			assertThat(ActivitySelection.maxCompatibleActivities(intervals), equalTo(expectedCount));
		}
		
	}
	
	@Test
	public void maxCompatibleActivitiesTestForLargeInput1() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 4;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime += 2;
			endTime += 2;
		}

		assertThat(ActivitySelection.maxCompatibleActivities(intervals), equalTo(50));
	}

	@Test
	public void maxCompatibleActivitiesTestForLargeInput2() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 5;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime = endTime;
			endTime += 5;
		}

		assertThat(ActivitySelection.maxCompatibleActivities(intervals), equalTo(100));
	}
	
	@Test
	public void maxCompatibleActivitiesIterativeTest() {
		List<Pair<int[][], Integer>> params = Arrays.asList(
																Pair.of(new int[][] {{1, 2}}, 1),
																Pair.of(new int[][] {{1,2},{2,3},{3,4},{1,3}}, 3),
																Pair.of(new int[][] {{1, 2}, {1, 2}, {1, 2}}, 1),
																Pair.of(new int[][] {{1, 100}, {11, 22}, {1, 11} , {2, 12}}, 2)
																);

		for(Pair<int[][], Integer> param: params) {
			int[][] intervals = param.getKey();
			int expectedCount = param.getValue();
			assertThat(ActivitySelection.maxCompatibleActivitiesIterative(intervals), equalTo(expectedCount));
		}
		
	}
	
	@Test
	public void maxCompatibleActivitiesIterativeTestForLargeInput1() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 4;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime += 2;
			endTime += 2;
		}

		assertThat(ActivitySelection.maxCompatibleActivitiesIterative(intervals), equalTo(50));
	}

	@Test
	public void maxCompatibleActivitiesIterativeTestForLargeInput2() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 5;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime = endTime;
			endTime += 5;
		}

		assertThat(ActivitySelection.maxCompatibleActivitiesIterative(intervals), equalTo(100));
	}
	
	@Test
	public void maxCompatibleActivitiesV1Test() {
		List<Pair<int[][], Integer>> params = Arrays.asList(
																Pair.of(new int[][] {{1, 2}}, 1),
																Pair.of(new int[][] {{1,2},{2,3},{3,4},{1,3}}, 3),
																Pair.of(new int[][] {{1, 2}, {1, 2}, {1, 2}}, 1),
																Pair.of(new int[][] {{1, 100}, {11, 22}, {1, 11} , {2, 12}}, 2)
																);

		for(Pair<int[][], Integer> param: params) {
			int[][] intervals = param.getKey();
			int expectedCount = param.getValue();
			assertThat(ActivitySelection.maxCompatibleActivitiesV1(intervals), equalTo(expectedCount));
		}
		
	}
	
	@Test
	public void maxCompatibleActivitiesV1TestForLargeInput1() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 4;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime += 2;
			endTime += 2;
		}

		assertThat(ActivitySelection.maxCompatibleActivitiesV1(intervals), equalTo(50));
	}

	@Test
	public void maxCompatibleActivitiesV1TestForLargeInput2() {
		int[][] intervals = new int[100][100];
		int startTime = 1;
		int endTime = 5;
		for(int i = 0; i < intervals.length; i++) {
			intervals[i] = new int[] {startTime, endTime};
			startTime = endTime;
			endTime += 5;
		}

		assertThat(ActivitySelection.maxCompatibleActivitiesV1(intervals), equalTo(100));
	}
}
