package com.learnbycoding.dynamic;

public class EditDistanceNaive {

	private int editDist(String first, String second, int m, int n) {

		if(m==0){
			return n;
		}
		
		if(n==0){
			return m;
		}
		
	    if(first.charAt(m-1)==second.charAt(n-1)){
	    	return editDist(first, second, m-1, n-1);
	    }
	    else{
	    	return 1+Math.min(Math.min(editDist(first, second, m-1, n), editDist(first, second, m, n-1)), editDist(first, second, m-1, n-1));
	    }
		
	}

	public static void main(String[] args) {

		EditDistanceNaive editDist = new EditDistanceNaive();
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDist.editDist(str1, str2, str1.length(),str2.length()));
	}

}
