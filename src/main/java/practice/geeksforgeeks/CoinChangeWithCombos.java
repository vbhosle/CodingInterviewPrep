package practice.geeksforgeeks;

import java.util.*;
import java.io.*;
//Expected Time Limit < 2.3568sec
//Faster solution at https://www.techiedelight.com/coin-change-problem-find-total-number-ways-get-denomination-coins/
public class CoinChangeWithCombos {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] coins = null;
		int target = 0;
		for (int i = 1; i <= T; i++) {
			br.readLine();
			coins = getArray(br.readLine());
			target = Integer.parseInt(br.readLine());
			List<List<Integer>> combos = waysToChange(target, coins, new HashMap<Integer, List<List<Integer>>>());
//			combos.forEach(System.out::println);
			combos.forEach(Collections::sort);
			Set<List<Integer>> unorderedCombos = new HashSet<List<Integer>>(combos);
			System.out.println(unorderedCombos.size());
		}
	}

	public static List<List<Integer>> waysToChange(int target, int[] coins, Map<Integer, List<List<Integer>>> cache) {
		if (target == 0) {
			List<List<Integer>> list = new ArrayList<>();
			list.add(new ArrayList<Integer>());
			return list;
		}
		
		if (cache.containsKey(target)) {
			System.out.println("Cache hit for " + target);
			return cache.get(target);
		}
		
		List<List<Integer>> ways = new ArrayList<>();
		for (int coin : coins) {
			if (coin <= target) {
				List<List<Integer>> paths = waysToChange(target - coin, coins, cache);
				for(List<Integer> p: paths) {
					List<Integer> newPath = new ArrayList<Integer>(p);
					newPath.add(coin);
					ways.add(newPath);
				}
				cache.putIfAbsent(target-coin, ways);
			}
			cache.put(target, ways);
		}

		return cache.get(target);
	}

	public static int[] getArray(String str) {
		String[] strArr = str.split("\\s");
		int[] result = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}

		return result;
	}
}
