package com.learnbycoding.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChangeNaive {

	static long countWays(int S[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		
		for (int a = 0; a <= n; a++) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {

			System.out.println("Before...");
			for (int a = 0; a <= n; a++) {
				System.out.print(table[a] + " ");
			}
			System.out.println();
			System.out.println("j is " + S[i]);
			for (int j = S[i]; j <= n; j++) {
				table[j] =table[j]+ table[j - S[i]];
			}

			System.out.println("After...");
			for (int a = 0; a <= n; a++) {
				System.out.print(table[a] + " ");
			}
			System.out.println();
			System.out.println();

		}
		return table[n];
	}

	private static int getCoinChangeCount(int[] S, int m, int sum) {

		if (sum == 0)
			return 1;

		if (sum < 0)
			return 0;

		if (m <= 0 && sum >= 1)
			return 0;

		return getCoinChangeCount(S, m - 1, sum)
				+ getCoinChangeCount(S, m, sum - S[m - 1]);

	}

	public static void main(String[] args) {

		int sum = 10;
		int[] S = { 2, 3, 5, 6 };
		//ArrayList<ArrayList<Integer>> arryList = new ArrayList<ArrayList<Integer>>();

		// System.out.println("Total number of Coin Changes are -> " +
		// getCoinChangeCount(S, S.length , sum));
		System.out.println("Total number of Coin Changes are -> "
				+ countWays(S, S.length, sum));

	}

}
