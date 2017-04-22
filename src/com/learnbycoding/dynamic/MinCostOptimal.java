package com.learnbycoding.dynamic;

public class MinCostOptimal {


	private int minCost(int[][] cost,int m, int n){
     
		int[][] minCostArr= new int[m+1][n+1];
		
		 /* Initialize first row of tc array */
		for(int i=1;i<=m;i++){
			minCostArr[0][i]=cost[0][i-1]+cost[0][i];
		}
		
		/* Initialize first column of total cost(tc) array */
		for(int j=1;j<=n;j++){
			minCostArr[j][0]=cost[j][0]+cost[j-1][0];
		}
		
		/* Construct rest of the tc array */
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				
				minCostArr[i][j]=Math.min(Math.min(minCostArr[i-1][j], minCostArr[i][j-1]),minCostArr[i-1][j-1])+cost[i][j]; 
			}
		}
		return minCostArr[m][n];  
	}
	
	
	public static void main(String[] args) {
		 int[][] cost = { {1, 2, 3},
	             {4, 8, 2},
	             {1, 5, 3} };
		 int R=3; int C=3;
		 MinCostOptimal minCost = new MinCostOptimal();
		 System.out.println(minCost.minCost(cost, R-1, C-1));
	}
}
