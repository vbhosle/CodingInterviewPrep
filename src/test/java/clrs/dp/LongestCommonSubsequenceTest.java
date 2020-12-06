package clrs.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongestCommonSubsequenceTest {

	@Test
	public void recursiveLCSLengthBruteForce() {
		List<Triple<String, String, Integer>> params = Arrays.asList( Triple.of("ABCBDAB", "BDCABA", 4)
																	  , Triple.of("10010101", "010110110", 6)
																	  , Triple.of("ABCDGH", "AEDFHR", 3)
																	  , Triple.of("AGGTAB", "GXTXAYB", 4)
															        );
		
		for(Triple<String, String, Integer> param: params) {
			String seq1 = param.getLeft();
			String seq2 = param.getMiddle();
			int expectedLCSLength = param.getRight();
			int actualLCSLength = LongestCommonSubsequence.recursiveLCSLengthBruteForce(seq1, seq2);
			assertThat(String.format("LCS length of %s and %s is %d", seq1, seq2, expectedLCSLength), actualLCSLength, equalTo(expectedLCSLength));
		}
	}
	
	@Test
	public void lcsV1() {
		List<Triple<String, String, Set<String>>> params = Arrays.asList( Triple.of("ABCBDAB", "BDCABA", SetUtils.hashSet("BDAB", "BCAB", "BCBA"))
																	  ,  Triple.of("10010101", "010110110", SetUtils.hashSet("100110", "101011", "101101", "010101"))
																	  , Triple.of("ABCDGH", "AEDFHR", SetUtils.hashSet("ADH"))
																	  , Triple.of("AGGTAB", "GXTXAYB", SetUtils.hashSet("GTAB"))
																	  , Triple.of("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA", SetUtils.hashSet("GTCGTCGGAAGCCGGCCGAA"))
															        );
		
		for(Triple<String, String, Set<String>> param: params) {
			String seq1 = param.getLeft();
			String seq2 = param.getMiddle();
			Set<String> possibleSequences = param.getRight();
			String actualSequence = LongestCommonSubsequence.lcsV1(seq1, seq2);
			assertThat(String.format("LCS length of %s and %s is one of %s", seq1, seq2, possibleSequences.toString()), actualSequence, isIn(possibleSequences));
		}
	}
	
	@Test
	public void lcsV2() {
		List<Triple<String, String, Set<String>>> params = Arrays.asList( Triple.of("ABCBDAB", "BDCABA", SetUtils.hashSet("BDAB", "BCAB", "BCBA"))
																	  ,  Triple.of("10010101", "010110110", SetUtils.hashSet("100110", "101011", "101101", "010101"))
																	  , Triple.of("ABCDGH", "AEDFHR", SetUtils.hashSet("ADH"))
																	  , Triple.of("AGGTAB", "GXTXAYB", SetUtils.hashSet("GTAB"))
																	  , Triple.of("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA", SetUtils.hashSet("GTCGTCGGAAGCCGGCCGAA"))
															        );
		
		for(Triple<String, String, Set<String>> param: params) {
			String seq1 = param.getLeft();
			String seq2 = param.getMiddle();
			Set<String> possibleSequences = param.getRight();
			String actualSequence = LongestCommonSubsequence.lcsV2(seq1, seq2);
			assertThat(String.format("LCS length of %s and %s is one of %s", seq1, seq2, possibleSequences.toString()), actualSequence, isIn(possibleSequences));
		}
	}

	@Test
	public void lcsLength() {
		List<Triple<String, String, Integer>> params = Arrays.asList( Triple.of("ABCBDAB", "BDCABA", 4)
																	  , Triple.of("10010101", "010110110", 6)
																	  , Triple.of("ABCDGH", "AEDFHR", 3)
																	  , Triple.of("AGGTAB", "GXTXAYB", 4)
																	  , Triple.of("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA", 20)
															        );
		
		for(Triple<String, String, Integer> param: params) {
			String seq1 = param.getLeft();
			String seq2 = param.getMiddle();
			int expectedLCSLength = param.getRight();
			int actualLCSLength = LongestCommonSubsequence.lcsLength(seq1, seq2);
			assertThat(String.format("LCS length of %s and %s is %d", seq1, seq2, expectedLCSLength), actualLCSLength, equalTo(expectedLCSLength));
		}
	}

}
