package com.learnbycoding.dynamic;

import java.util.Arrays;

public class LongestPalidromicSubstring {
	
	private int getLongestPalindromicString(String input){
		
		int n= input.length();
		
		boolean table[][]= new boolean[n][n];
		//Arrays.fill(table[n], false);
		
		int maxLength = 1;
	    for (int i = 0; i < n; ++i)
	        table[i][i] = true;
	    
	    int start = 0;
	    for (int i = 0; i < n-1; ++i)
	    {
	    	if(input.charAt(i)==input.charAt(i+1))
	    	{
	    		table[i][i+1] = true;
	    		start =i;
		    	maxLength=2;
	    	}
	    }
	    
	    // of substring
	    for (int k = 3; k <= n; ++k)
	    {
	        // Fix the starting index
	        for (int i = 0; i < n-k+1 ; ++i)
	        {
	            // Get the ending index of substring from
	            // starting index i and length k
	            int j = i+k-1 ;
	 
	            // checking for sub-string from ith index to
	            // jth index iff str[i+1] to str[j-1] is a
	            // palindrome
	            if (table[i+1][j-1] && input.charAt(i) == input.charAt(j))
	            {
	                table[i][j] = true;
	 
	                if (k > maxLength)
	                {
	                    start = i;
	                    maxLength = k;
	                }
	            }
	        }
	    }
	    System.out.print("Longest palindrome substring is: ");
	    printSubStr(input, start, start + maxLength - 1 );
	 
	    return maxLength;
	    
	}
	
	// A utility function to print a substring str[low..high]
	void printSubStr( String str, int low, int high )
	{
	    for( int i = low; i <= high; ++i )
	        System.out.printf("%c", str.charAt(i));
	}
	
	public static void main(String[] args) {

		String input = "forgeeksskeegfor";
       LongestPalidromicSubstring  lps = new LongestPalidromicSubstring();
       lps.getLongestPalindromicString(input);
	}
}
