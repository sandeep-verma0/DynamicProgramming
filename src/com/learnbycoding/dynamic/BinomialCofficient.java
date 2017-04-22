package com.learnbycoding.dynamic;

import java.util.Arrays;

public class BinomialCofficient {

	private static int binCofficientEfficient(int n, int k){
		
		int[] C= new int[k+1];
		
		Arrays.fill(C, 0);
		C[0]=1;
					
		for(int i=1;i<=n;i++){
			
			for(int j=Math.min(i, k);j>0;j--){
				C[j]=C[j]+C[j-1];
			}
		}
		
		return C[k];
	}
	
	private static int binCofficientRecursive(int n, int k){
		
		if(n<0 || k< 0)
			return 0;
		
		if(n==0 || n==k)
			return 1;
		
		return binCofficientRecursive(n-1, k-1)+ binCofficientRecursive(n-1, k);
	}
	
	
	public static void main(String[] args) {

		System.out.println(binCofficientEfficient(55,12));
		System.out.println(binCofficientRecursive(50, 12));
		
	}

}
