package com.test;

public class MajorityElement {
/*
 * Basic idea of the algorithm is if we cancel out each occurrence of an element e 
 * with all the other elements that are different from e then e will exist till end 
 * if it is a majority element.
 * */
	public int majorityElement(int[] num) {
		int n = num.length;
		int count = 0;
		int maj = 0;
		for (int i=0; i<n;i++){
			if (count==0){
				maj=num[i];
				count++;
			}
			else if(maj == num[i]){
				count++;
			}else{
				count--;
			}
		}
		return maj;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
