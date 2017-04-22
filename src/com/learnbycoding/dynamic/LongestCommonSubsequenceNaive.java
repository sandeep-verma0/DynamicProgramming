package com.learnbycoding.dynamic;

public class LongestCommonSubsequenceNaive {

	private int longestCommonSubsequce(String first , String second ,int m , int n){
		
		if(m==0 || n==0)
			return 0;
		else if(first.charAt(m-1)==second.charAt(n-1)){
			return 1+ longestCommonSubsequce(first, second, m-1, n-1);
		}
		else {
			return Math.max(longestCommonSubsequce(first, second, m, n-1), longestCommonSubsequce(first, second, m-1, n));
		}
	}
	
	public static void main(String[] args) {

		LongestCommonSubsequenceNaive longestSubseq = new LongestCommonSubsequenceNaive();
		//String first= "ABCDGH";
		//String second = "AEDFHR" ;
		
		String first="AGGTAB";
		String second = "GXTXAYB";
		int m= first.length();
		int n= second.length();
		System.out.println(longestSubseq.longestCommonSubsequce(first, second, m, n));
	}

}
