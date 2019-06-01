package com.interviewbit;

import java.util.Collections;
import java.util.List;

public class CityTour {
	long comb[][] = new long[11][11];
	long exp[] = new long[11];

	public CityTour() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j)
					comb[i][j] = 1;
				else {
					comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % 1000000007;
				}
			}
		}
		exp[0] = 1;
		for (int i = 1; i < 11; i++) {
			exp[i] = (exp[i - 1] * 2) % 1000000007;
		}
	}

	public int solve(int A, List<Integer> B) {
		Collections.sort(B);
		long ans = 1;
		int cnt = B.get(0) - 1;
		for (int i = 1; i < B.size(); i++) {
			int t = B.get(i) - B.get(i - 1) - 1;
			if (t > 0) {
				ans = ((ans * exp[t - 1]) % 1000000007 * comb[cnt + t][t]) % 1000000007;
				cnt += t;
			}
			// System.out.print(i+" "+t+" ")
		}
		int t = A - B.get(B.size() - 1);
		ans = (ans * comb[cnt + t][t]) % 1000000007;
		return (int) ans;
	}
}
