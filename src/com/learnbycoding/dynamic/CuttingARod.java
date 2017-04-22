package com.learnbycoding.dynamic;

public class CuttingARod {
	
	private static int  maxValueOfRodCutNaive(int[] price , int n){
		
		if(n<=0)
			return 0;
		
		int max_value= Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			max_value = Math.max(max_value, price[i]+ maxValueOfRodCutNaive(price, n-i-1));
		}
		
		return max_value;
	}
	

	private static int  maxValueOfRodCutEfficient(int[] price , int n){
		
		int[] value = new int [n+1];
		
		value[0]=0;
	
		for(int i=1;i<=n;i++){
			int max_value=Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				//max_Value is max of selecting rod of length 4 is length 1(price[1]) and selecting value (max) of 3 
				max_value= Math.max(max_value, price[j]+ value[i-1-j]);
			}	
			value[i]=max_value;
		}
		
		return value[n];
	}
	
	
	public static void main(String[] args) {
		 int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	      int size = arr.length;
	        System.out.println("Maximum Obtainable Value is " +
	        		maxValueOfRodCutEfficient(arr, size));
	}
}
