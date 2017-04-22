package com.learnbycoding.dynamic;

import java.util.Stack;

public class LongestIncreasingSequenceOptimal {

	private int lis(int arr[], int n){
		
	
		int[] lis = new int[n];
		
		for(int i=0;i<n;i++){
			lis[i]=1;
		}
		
		for(int i=0;i<n;i++){
			
			for(int j=0; j<i;j++){
				if(arr[i]>arr[j] && lis[i] < (lis[j]+1)){
					lis[i]= lis[j]+1;
				}
			}
		}
		
		int max=-1;
		int maxIndex=0;
		for(int i=0;i<n;i++){
			if(lis[i]> max)
				{
				max= lis[i];
				maxIndex=i;
				}
		}
		
		System.out.println("LIS array is...");
		for(int i=0;i<n;i++){
			System.out.print(lis[i]+ " ");		}
		System.out.println();
		System.out.println();
		System.out.println("max size of LIS is...");
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int value=max-1;
		int tempMaxIndex = maxIndex;
		System.out.println("value ->"  +value + " tempMaxIndex -> " + tempMaxIndex);
		for(int j=maxIndex;j>=0;j--){
			if(lis[j] == (value) && arr[j]< arr[tempMaxIndex]){
				tempMaxIndex=j;
				value=value-1;
				stack.push(j);
				System.out.println("j is " + j);
			}
		}
		
		System.out.println();
		System.out.println("Longest Increasing Sequence is --->>...");
		System.out.println("stack.size() -> " + stack.size());
		int size= stack.size();
		for(int i=0;i<size;i++){
			System.out.print(arr[(int) stack.pop()]+ " ");
		}
		System.out.print(arr[maxIndex]);
		
		System.out.println();
		return max;
		
	}
	
	public static void main(String[] args) {
		 int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		 LongestIncreasingSequenceOptimal longestIncreasingSubseq = new LongestIncreasingSequenceOptimal();
		
		 System.out.println( longestIncreasingSubseq.lis(arr, arr.length));
	}

}
