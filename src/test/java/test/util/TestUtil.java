package test.util;

public class TestUtil {

	// convert space separated ints to int array
	public static int[] toIntArray(String str) {
		String[] strArr = str.trim().split("\\s");
		int[] result = new int[strArr.length];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}
		
		return result;
	}
}
