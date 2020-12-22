package clrs.greedy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MaxProfitInJobSchedulingTest {

	@Test
	public void jobSchedulingTest1() {
		assertThat(MaxProfitInJobScheduling.jobScheduling(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70}), equalTo(120));
	}
	
	@Test
	public void jobSchedulingTest2() {
		assertThat(MaxProfitInJobScheduling.jobScheduling(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}), equalTo(150));
	}
	
	@Test
	public void jobSchedulingTest3() {
		assertThat(MaxProfitInJobScheduling.jobScheduling(new int[] {1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}), equalTo(6));
	}
	
	@Test
	public void jobSchedulingOptimizedTest1() {
		assertThat(MaxProfitInJobScheduling.jobSchedulingOptimized(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70}), equalTo(120));
	}
	
	@Test
	public void jobSchedulingOptimizedTest2() {
		assertThat(MaxProfitInJobScheduling.jobSchedulingOptimized(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}), equalTo(150));
	}
	
	@Test
	public void jobSchedulingOptimizedTest3() {
		assertThat(MaxProfitInJobScheduling.jobSchedulingOptimized(new int[] {1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}), equalTo(6));
	}

}
