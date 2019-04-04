package com.hackerrank.arrays;

public class LeftRotation {

	public int[] rotateLeft(int[] arr, int rotateBy) {
		if(arr == null || arr.length == 0 || rotateBy%arr.length == 0) return arr;
		int copyIdx = arr.length - rotateBy%arr.length;
		
		int copyArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copyArr[i] = arr[copyIdx];
			copyIdx = (copyIdx+1) % arr.length;
		}
		
		return copyArr;
	}
}
