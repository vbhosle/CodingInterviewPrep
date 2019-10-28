package com.dream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FinalDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
	}

	public static void finalPrice(List<Integer> prices) {
		if (prices == null || prices.isEmpty()) {
			System.out.println(0);
		}

		Deque<Integer> increasingStack = new LinkedList<>();
		List<Integer> fullPricedItems = new ArrayList<>();

		int i = 0;
		int topIndex;
		int poppedIndex;

		while (i < prices.size()) {
			if (increasingStack.isEmpty()) {
				increasingStack.push(i);
				i++;
			} else {
				topIndex = increasingStack.peek();
				if (prices.get(i) <= prices.get(topIndex)) {
					poppedIndex = increasingStack.pop();
					prices.set(poppedIndex, prices.get(poppedIndex) - prices.get(i));
				} else {
					increasingStack.push(i);
					i++;
				}
			}

		}

		while (!increasingStack.isEmpty()) {
			fullPricedItems.add(increasingStack.pop());
		}

		Collections.reverse(fullPricedItems);

		long sum = prices.stream().mapToLong(Integer::longValue).sum();
		System.out.println(sum);
		System.out.println(fullPricedItems.stream().map(item -> item.toString()).collect(Collectors.joining(" ")));
	}

}
