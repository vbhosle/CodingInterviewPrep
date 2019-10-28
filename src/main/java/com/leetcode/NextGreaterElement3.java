package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextGreaterElement3 {

	public static void main(String[] args) {
		int number = 230241;
		System.out.println("Next greater number of " + number + " is " + nextGreaterElement(number));
	}

	 public static int nextGreaterElement(int n) {
		 if(n == 0) return -1;
         Integer[] digits = toDigits(n).toArray(new Integer[0]);
         int decreasingIndex = getDecreasingIndex(digits);
         if(decreasingIndex == -1) return -1;
         
         int smallestNumberIndex = getIndexOfNearestGreaterNumberAfter(digits, decreasingIndex);
         
         //swap 
         int temp = digits[decreasingIndex];
         digits[decreasingIndex] = digits[smallestNumberIndex];
         digits[smallestNumberIndex] = temp;
        
         //sort the rest
         Arrays.sort(digits, decreasingIndex + 1, digits.length);
         
         long result = Long.valueOf(Arrays.stream(digits).map(num -> num.toString()).collect(Collectors.joining("")));
         return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
    
    public static int getDecreasingIndex(Integer[] digits){
        int decreasingIndex = -1;
        int currentIndex = digits.length - 1;
        int nextNumber = digits[currentIndex--];
        
        while(currentIndex >= 0){
            if(digits[currentIndex] < nextNumber){
            	decreasingIndex = currentIndex;
                break;
            }
            
            nextNumber = digits[currentIndex];
            currentIndex --;
        }
        
        return decreasingIndex;
    }
    
    public static int getIndexOfNearestGreaterNumberAfter(Integer[] digits, int index){
    	int smallestIndex = index + 1;
        if(smallestIndex >= digits.length) return -1;
        int min = digits[smallestIndex];
        int i = smallestIndex + 1;
        while(i < digits.length){
            if(digits[i] > digits[index] && digits[i] < min){
                min = digits[i];
                smallestIndex = i;
            }
            i++;
        }
        
        return smallestIndex;
    }
    
    public static List<Integer> toDigits(int n){
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(n%10);
            n/=10;    
        }
        Collections.reverse(list);
        return list;
    }
    
}
