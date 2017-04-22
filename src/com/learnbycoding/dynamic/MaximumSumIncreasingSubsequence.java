package com.learnbycoding.dynamic;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSumIncreasingSubsequence {

	private static int getMaximumSumIncreasingSubsequence(Integer[] arr){
		
		Integer result[] = new Integer[arr.length];
		
		result  =Arrays.copyOfRange(arr, 0, arr.length);
		//result[0]=arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			for(int j=i-1;j>=0;j--){
				
				if(arr[i]> arr[j]){
					result[i]=result[i]+arr[j];
				}
			}
		}
		
		Arrays.asList(result).forEach((x)-> System.out.print(x+ " "));
		System.out.println();
		return Collections.max(Arrays.asList(result));
	}
	
	
	public static void main(String[] args) {

		Integer[] arr={1, 101, 2, 3, 100, 4, 5};
		//Integer[] arr= {10, 5, 4, 3};
		System.out.println("Maximum sum increasing subsequence : " + getMaximumSumIncreasingSubsequence(arr));
	}

}
