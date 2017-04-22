package com.learnbycoding.dynamic;

public class PalindromicPartitioning {
	
	private static int minCutNeeded(String input , int i , int j){
		
		if(i==j)
			return 0;
		
		//If there are only two characters and both are same then return 0;
		if(input.charAt(i)==input.charAt(j) && i+1==j)
			return 0;
		
		//If there are only two characters and both are not same then one partition is needed;
		 if(input.charAt(i)!=input.charAt(j) && i+1==j)
			return 1;
		
		//If char at ends are not equal then we need atleast one cut
		if(input.charAt(i)!=input.charAt(j)){
			return 1+Math.min(minCutNeeded(input, i, j-1), minCutNeeded(input, i+1, j));
		}
		
		return 0;
	}
	
public static void main(String[] args) {
	String input ="ababbbabbababa";
	System.out.println("Min Cut needed " + minCutNeeded(input, 0, input.length()-1));
}
}
