package com.learnbycoding.dynamic;

public class MinCostNaive {
	
	private int minCost(int[][] cost,int m, int n){
		if(m < 0 || n < 0)
			return Integer.MAX_VALUE;
		else if(m==0 && n==0)
		return cost[m][n];
		else {
			return cost[m][n]+ Math.min(Math.min(minCost(cost, m-1, n),minCost(cost, m, n-1)),
					minCost(cost, m-1, n-1));
		}
	}
	
public static void main(String[] args) {
	 int[][] cost = { {1, 2, 3},
             {4, 8, 2},
             {1, 5, 3} };
	 int R=3; int C=3;
	 MinCostNaive minCost = new MinCostNaive();
	 System.out.println(minCost.minCost(cost, R-1, C-1));
//printf(" %d ", minCost(cost, 2, 2));
}
}
