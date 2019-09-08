package com.codechef.foundation.greedy;

// Wrong Answer :x
public class CakeDoom {

	private static final String NO = "NO";

	public static void main(String[] args) {
		System.out.println(minCherryArrangement("??1?", 2));
	}

	private static String intArrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder(arr.length);
		for (int i : arr) {
			sb.append(i);
		}
		return sb.toString();
	}

	private static int getNextValidChoiceForIndex(int index, int[] arrangement, int maxColor) {
		int leftIndex = index == 0 ? arrangement.length - 1 : index - 1;
		int rightIndex = index == arrangement.length - 1 ? 0 : index + 1;

		if (arrangement[leftIndex] != -1 && arrangement[leftIndex] == arrangement[index])
			return -1;
		if (arrangement[rightIndex] != -1 && arrangement[rightIndex] == arrangement[index])
			return -1;

		int nextColor = arrangement[index] + 1;
		while (nextColor < maxColor) {
			if (nextColor != arrangement[leftIndex] && nextColor != arrangement[rightIndex]) {
				return nextColor;
			}
			nextColor++;
		}

		return -1;
	}

	private static boolean isValidArrangement(int[] arrangement, int maxColor) {
		int leftIndex, rightIndex;
		for (int index = 0; index < arrangement.length; index++) {
			if (arrangement[index] >= maxColor)
				return false;
			leftIndex = index == 0 ? arrangement.length - 1 : index - 1;
			rightIndex = index == arrangement.length - 1 ? 0 : index + 1;
			if (arrangement[leftIndex] != -1 && arrangement[leftIndex] == arrangement[index])
				return false;
			if (arrangement[rightIndex] != -1 && arrangement[rightIndex] == arrangement[index])
				return false;
		}

		return true;
	}

	public static String minCherryArrangement(String existingArrangement, int maxColor) {
		int[] arrangement = new int[existingArrangement.length()];

		for (int i = 0; i < existingArrangement.length(); i++) {
			if (existingArrangement.charAt(i) == '?') {
				arrangement[i] = -1;
			} else {
				arrangement[i] = existingArrangement.charAt(i) - '0';
			}
		}

		if (arrangement.length == 1) {
			if (arrangement[0] == -1) {
				return "0";
			} else {
				if (arrangement[0] > maxColor) {
					return NO;
				}
				return "" + arrangement[0];
			}
		}

		if (maxColor == 2 && arrangement.length % 2 == 1)
			return NO;

		if (!isValidArrangement(arrangement, maxColor)) {
			return NO;
		} else if (!existingArrangement.contains("?")) {
			return existingArrangement;
		}
		return minCherryArrangement(existingArrangement, arrangement, 0, maxColor);
	}

	public static String minCherryArrangement(String existingArrangement, int[] newArrangement, int currentIndex,
			int maxColor) {
		if (currentIndex >= newArrangement.length) {
			return intArrayToString(newArrangement);
		}

		String result = NO;
		if (existingArrangement.charAt(currentIndex) == '?') {
			// try different colors
			int selectedColor;
			do {
				selectedColor = getNextValidChoiceForIndex(currentIndex, newArrangement, maxColor);
				if (selectedColor == -1)
					return NO;
				newArrangement[currentIndex] = selectedColor;

				result = minCherryArrangement(existingArrangement, newArrangement, currentIndex + 1, maxColor);
				if (!result.equals(NO)) {
					return intArrayToString(newArrangement);
				}
			} while (true);
		} else {
			return minCherryArrangement(existingArrangement, newArrangement, currentIndex + 1, maxColor);
		}

	}

}
