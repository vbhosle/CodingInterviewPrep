package clrs.dp;

import static clrs.dp.EditDistance.minDistance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

import clrs.dp.EditDistance.EditOperation;


public class EditDistanceTest {

	@Test
	public void minDistanceTest() {
		final Map<EditOperation, Integer> operationCost = ImmutableMap.of(EditOperation.ADD, 1,
																		  EditOperation.DELETE, 1,
																		  EditOperation.REPLACE, 1);
		List<Triple<String, String, Integer>> params = Arrays.asList(
																		Triple.of("horse", "ros", 3),
																		Triple.of("intention", "execution", 5),
																		Triple.of("abcdxabcde", "abcdeabcdx", 2));

		for (Triple<String, String, Integer> param : params) {
			assertThat(String.format("Minimum edit distance between %s and %s is %d", param.getLeft(), param.getMiddle(), param.getRight())
						, minDistance(param.getLeft(), param.getMiddle(), operationCost)
						, equalTo(param.getRight()));
		}
	}

}
