package com.learnbycoding.dynamic;

public class LongestIncreasingSequenceNaive {

	int max_increasing_length;
	private int lis(int arr[], int n){
		
		if(n==1)
			return 1;
		
		int current_increasing_length =1;
		
		for(int i=0;i<n-1;i++){
			
			// Recursively calculate the length of the LIS
	        // ending at arr[i]
			int sub_increasing_length= lis(arr, i);
			
			// Check if appending arr[n-1] to the LIS
	        // ending at arr[i] gives us an LIS ending at
	        // arr[n-1] which is longer than the previously
	        // calculated LIS ending at arr[n-1]
			if(arr[i]< arr[n-1]  && current_increasing_length <(sub_increasing_length+1))
				 current_increasing_length = 1+sub_increasing_length;
			
		}
		
		
		 // Check if currently calculated LIS ending at
	    // arr[n-1] is longer than the previously calculated
	    // LIS and update max_lis_length accordingly
	    if (max_increasing_length < current_increasing_length)
	        max_increasing_length = current_increasing_length;
	 
	    return current_increasing_length;
	}
	

	
	public static void main(String[] args) {

		 int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		 LongestIncreasingSequenceNaive longestIncreasingSubseq = new LongestIncreasingSequenceNaive();
		 longestIncreasingSubseq.lis(arr, arr.length);
		 System.out.println(longestIncreasingSubseq.max_increasing_length);
	}

}
