package com.learnbycoding.dynamic;

public class LongestPalindromicSequence {

	private static int longestPalindromicSequenceNaive(String value, int i,
			int j) {

		if (i == j)
			return 1;

		else if (value.charAt(i) == value.charAt(j) && i + 1 == j)
			return 2;

		else if (value.charAt(i) == value.charAt(j) && i + 1 != j) {
			return 2 + longestPalindromicSequenceNaive(value, i + 1, j - 1);
		} else {
			return Math.max(longestPalindromicSequenceNaive(value, i, j - 1),
					longestPalindromicSequenceNaive(value, i + 1, j));
		}
	}

	private static int longestPalindromicSequenceEfficient(char[] str, int n) {

		int[][] L = new int[n][n];

		for (int i = 0; i < n; i++) {
			L[i][i] = 1;
		}
		int i, j, cl;
		for (cl = 2; cl <= n; cl++) {

			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (str[i] == str[j] && cl == 2)
					L[i][j] = 2;
				else if (str[i] == str[j])
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}
		return L[0][n - 1];
	}

	public static void main(String[] args) {

		String input = "BBABCBCAB";
		System.out
				.println("Longest palidromic sequence is "
						+ longestPalindromicSequenceNaive(input, 0,
								input.length() - 1));

	}

}
