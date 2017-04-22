package com.learnbycoding.dynamic;

public class LongestCommonSubsequenceOptimal {

	private int longestCommonSubsequce(String first, String second, int m, int n) {

		int[][] lcs= new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					lcs[i][j]=0;
				
				else if(first.charAt(i-1)==second.charAt(j-1)){
					lcs[i][j]=lcs[i-1][j-1]+1;
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		return lcs[m][n];
	}

	public static void main(String[] args) {

		LongestCommonSubsequenceOptimal longestSubseq = new LongestCommonSubsequenceOptimal();
		// String first= "ABCDGH";
		// String second = "AEDFHR" ;

		String first = "AGGTAB";
		String second = "GXTXAYB";
		int m = first.length();
		int n = second.length();
		System.out.println(longestSubseq.longestCommonSubsequce(first, second,
				m, n));
	}

}
