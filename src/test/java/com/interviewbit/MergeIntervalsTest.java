package com.interviewbit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.interviewbit.MergeIntervals.Interval;

public class MergeIntervalsTest {

	private MergeIntervals solver;

	private static List<Interval> stringToIntervals(String input) {
		String[] split = input.split("\\), \\(");
		return Arrays.stream(split).map(s -> s.replaceAll("[\\(\\)]", "")).map(MergeIntervalsTest::stringToInterval)
				.collect(Collectors.toList());
	}

	private static Interval stringToInterval(String input) {
		String[] split = input.split(", ");
		return new Interval(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
	}

	@Before
	public void setUp() throws Exception {
		solver = new MergeIntervals();
	}

	@Test
	public void givenTest1() {
		List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
		List<Interval> expected = Arrays.asList(new Interval(1, 5), new Interval(6, 9));
		assertThat(solver.insert(intervals, new Interval(2, 5)), is(expected));
	}

	@Test
	public void givenTest2() {
		List<Interval> intervals = Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7),
				new Interval(8, 10), new Interval(12, 16));
		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 10), new Interval(12, 16));
		assertThat(solver.insert(intervals, new Interval(4, 9)), is(expected));
	}

	@Test
	public void givenTest3() {
		List<Interval> intervals = Arrays.asList(new Interval(1, 2), new Interval(3, 6));
		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 6), new Interval(8, 10));
		assertThat(solver.insert(intervals, new Interval(10, 8)), is(expected));
	}

	@Test
	public void givenTest4() {
		List<Interval> intervals = stringToIntervals(
				"(6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999), (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097)");
		List<Interval> expected = stringToIntervals(
				"(6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097)");
		Interval newInterval = stringToInterval("36210193, 61984219");
		assertThat(solver.insert(intervals, newInterval), is(expected));
	}

	@Test
	public void givenTest5() {
		List<Interval> intervals = Arrays.asList(new Interval(3, 6), new Interval(8, 10));
		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 6), new Interval(8, 10));
		assertThat(solver.insert(intervals, new Interval(1, 2)), is(expected));
	}

	@Test
	public void mergeOverlappingListWhenEmpty() {
		List<Interval> overlappingList = Collections.emptyList();
		Interval newInterval = new Interval(2, 4);
		assertThat(solver.mergeOverlappingList(overlappingList, newInterval), is(newInterval));
	}

	@Test
	public void mergeOverlappingListWhenIntervalWithinSingleRange() {
		List<Interval> overlappingList = stringToIntervals("(12, 16)");
		Interval newInterval = new Interval(13, 15);
		Interval expectedInterval = new Interval(12, 16);
		assertThat(solver.mergeOverlappingList(overlappingList, newInterval), is(expectedInterval));
	}

	@Test
	public void mergeOverlappingListWhenIntervalSpanningIntervals1() {
		List<Interval> overlappingList = stringToIntervals("(12, 16), (20, 24)");
		Interval newInterval = new Interval(11, 25);
		Interval expectedInterval = new Interval(11, 25);
		assertThat(solver.mergeOverlappingList(overlappingList, newInterval), is(expectedInterval));
	}

	@Test
	public void mergeOverlappingListWhenIntervalSpanningIntervals2() {
		List<Interval> overlappingList = stringToIntervals("(12, 16), (20, 24)");
		Interval newInterval = new Interval(13, 22);
		Interval expectedInterval = new Interval(12, 24);
		assertThat(solver.mergeOverlappingList(overlappingList, newInterval), is(expectedInterval));
	}

	@Test
	public void mergeOverlappingListWhenIntervalSpanningIntervals3() {
		List<Interval> overlappingList = stringToIntervals("(12, 16), (20, 24)");
		Interval newInterval = new Interval(10, 22);
		Interval expectedInterval = new Interval(10, 24);
		assertThat(solver.mergeOverlappingList(overlappingList, newInterval), is(expectedInterval));
	}

}
