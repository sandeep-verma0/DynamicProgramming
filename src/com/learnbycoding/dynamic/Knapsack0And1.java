package com.learnbycoding.dynamic;

public class Knapsack0And1 {
	
	
	private static int knapSackEfficient(int[] val, int wt[] , int W , int n){
		
		
		int[][] K= new int[n+1][W+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=W;j++){
				if(i==0 || W==0)
					K[i][j]=0;
				
				else if(wt[i-1]>W)
					K[i][j]=K[i-1][j];
				else if(wt[i-1]<=j)
					K[i][j]=Math.max(val[i-1]+ K[i-1][j-wt[i-1]], K[i-1][j]);
			}
		}
		
		return K[n][W];
				
				}
	
	private static int maxValue(int[] val, int wt[] , int W , int n){
		
		if(W==0 || n==0){
			return 0;
		}
		
		if(wt[n-1]> W)
			return maxValue(val, wt, W, n-1);
		
		else {
			return Math.max(val[n-1]+ maxValue(val, wt, W-wt[n-1], n-1), maxValue(val, wt, W, n-1));
		}
	}
	
	
	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		
		System.out.println("Max Value is -> " + maxValue(val, wt, W, val.length));
		System.out.println("Max Value is -> " + knapSackEfficient(val, wt, W, val.length));
		
	}
}
