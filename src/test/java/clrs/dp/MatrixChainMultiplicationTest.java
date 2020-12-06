package clrs.dp;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatrixChainMultiplicationTest {
	
	@Test
	public void recursiveMatrixChain() {
		List<Pair<int[], Long>> params = Arrays.asList(
														Pair.of(new int[] {10, 100, 5, 50}, 7500L)
														, Pair.of(new int[] {30, 35, 15, 5, 10, 20, 25	}, 15125L)
														, Pair.of(new int[] {5,10,3,12,5,50,6}, 2010L)
														, Pair.of(new int[] {1000, 100, 20, 10, 1000}, 11020000L)
				 										); 
		
		for(Pair<int[], Long> param: params) {
			int[] dimensions = param.getLeft();
			long expected = param.getRight();
			
			assertThat(String.format("Optimal multiplications for matrix dimensions %s are %d", Arrays.toString(dimensions), expected)
					, MatrixChainMultiplication.recursiveMatrixChain(dimensions)
					, equalTo(expected));
		}
	}	
	
	@Test
	public void recursiveMatrixChainMemoized() {
		List<Pair<int[], Long>> params = Arrays.asList(
														Pair.of(new int[] {10, 100, 5, 50}, 7500L)
														, Pair.of(new int[] {30, 35, 15, 5, 10, 20, 25	}, 15125L)
														, Pair.of(new int[] {5,10,3,12,5,50,6}, 2010L)
														, Pair.of(new int[] {1000, 100, 20, 10, 1000}, 11020000L)
				 										); 
		
		for(Pair<int[], Long> param: params) {
			int[] dimensions = param.getLeft();
			long expected = param.getRight();
			
			assertThat(String.format("Optimal multiplications for matrix dimensions %s are %d", Arrays.toString(dimensions), expected)
					, MatrixChainMultiplication.recursiveMatrixChainMemoized(dimensions)
					, equalTo(expected));
		}
	}	
	
	@Test
	public void matrixChainMemoized() {
		List<Pair<int[], String>> params = Arrays.asList(
														Pair.of(new int[] {10, 100, 5, 50}, "((A1A2)A3)")
														, Pair.of(new int[] {30, 35, 15, 5, 10, 20, 25	}, "((A1(A2A3))((A4A5)A6))")
														, Pair.of(new int[] {5,10,3,12,5,50,6}, "((A1A2)((A3A4)(A5A6)))")
														, Pair.of(new int[] {1000, 100, 20, 10, 1000}, "((A1(A2A3))A4)")
				 										); 
		
		for(Pair<int[], String> param: params) {
			int[] dimensions = param.getLeft();
			String expected = param.getRight();
			
			assertThat(String.format("Optimal paranthesization for matrix dimensions %s is %s", Arrays.toString(dimensions), expected)
					, MatrixChainMultiplication.matrixChainMemoized(dimensions)
					, equalTo(expected));
		}
	}

}
