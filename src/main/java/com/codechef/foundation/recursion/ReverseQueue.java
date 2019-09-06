package com.codechef.foundation.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>(Arrays.asList(1,2,3));
		System.out.println(reverse(queue));
		
		Queue<String> queue1 = new LinkedList<>(Arrays.asList("red", "green", "blue"));
		System.out.println(reverse(queue1));
	}

	public static <T> Queue<T> reverse(Queue<T> queue){
		if(queue.isEmpty()) return queue;
		
		T item = queue.remove();
		Queue<T> reversed = reverse(queue);
		reversed.add(item);
		return reversed;
	}
}
