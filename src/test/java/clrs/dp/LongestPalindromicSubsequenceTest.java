package clrs.dp;

import org.junit.Test;

import com.google.common.base.Strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import static clrs.dp.LongestPalindromicSubsequence.lpsLengthBruteForce;
import static clrs.dp.LongestPalindromicSubsequence.lpsLengthMemoized;

public class LongestPalindromicSubsequenceTest {

	@Test
	public void lpsLengthBruteForceTest() {
		List<Pair<String, Integer>> params = Arrays.asList(
													  Pair.of("character", 5)
													  , Pair.of("abbdcacb", 5)
													  , Pair.of("bottomtomato", 7)
													  , Pair.of("racecar", 7)
													  , Pair.of("longest", 1)
													  , Pair.of(Strings.repeat("racecar", 10), 70)
													  , Pair.of("abcdefghijklmnopqrstuvwxyz", 1)
														);
		
		for (Pair<String, Integer> param : params) {
			assertThat(String.format("Longest palindromic subsequence for %s has length %d", param.getLeft(), param.getRight()), lpsLengthBruteForce(param.getLeft()), equalTo(param.getRight()));
		}
	}
	
	@Test
	public void lpsLengthMemoizedTest() {
		List<Pair<String, Integer>> params = Arrays.asList(
													  Pair.of("character", 5)
													  , Pair.of("abbdcacb", 5)
													  , Pair.of("bottomtomato", 7)
													  , Pair.of("racecar", 7)
													  , Pair.of("longest", 1)
													  , Pair.of(Strings.repeat("racecar", 10), 70)
													  , Pair.of("abcdefghijklmnopqrstuvwxyz", 1)
														);
		
		for (Pair<String, Integer> param : params) {
			assertThat(String.format("Longest palindromic subsequence for %s has length %d", param.getLeft(), param.getRight()), lpsLengthMemoized(param.getLeft()), equalTo(param.getRight()));
		}
	}

}
