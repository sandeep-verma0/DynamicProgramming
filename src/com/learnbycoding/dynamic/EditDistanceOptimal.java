package com.learnbycoding.dynamic;

public class EditDistanceOptimal {

	
	private int editDist(String first, String second, int m, int n) {

		int[][] editDist=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				
				if(j==0)
					editDist[i][j]=i;
				
				else if(i==0)
					editDist[i][j]=j;
				
				else if(first.charAt(i-1)==second.charAt(j-1)){
					editDist[i][j]=editDist[i-1][j-1];
				}else{
					editDist[i][j]=Math.min(Math.min(editDist[i-1][j], editDist[i][j-1]), editDist[i-1][j-1])+1;
				}
			}
		}
		
		return editDist[m][n];
	     
	}
	public static void main(String[] args) {
		EditDistanceOptimal editDist = new EditDistanceOptimal();
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDist.editDist(str1, str2, str1.length(),str2.length()));
	}

}
