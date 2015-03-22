package com.test;

public class MultiplesOf3And5 {


	public int countAll(int input){
		int count=0;
		int runningCount = 1;
		while (runningCount<=input){
			if (runningCount%3==0 && runningCount%5==0){
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
