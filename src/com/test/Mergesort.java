package com.test;

import java.util.Arrays;

public class Mergesort {
/*	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			System.out.println("low: "+ low+ " Middle: " + middle+ " High: " +high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}
		System.out.println("Helper " + Arrays.toString(helper));
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		System.out.println("numbers " + Arrays.toString(numbers));

		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
	
	public static void main(String args []){
		
		Mergesort ms = new Mergesort();
		int [] test = {50, 10, 14, 26, 36, 15, 0, 9};
		ms.sort(test);
	}*/
	
	public int [] mergeSort (int []array, int start, int end){
		
		int length = end -start+1;
		
		if (length<2){
			int arr[]= new int [1]; 
			arr[0] = array[start];
			return arr;
			
		}else{
			int mid = (start+end)/2;
			int left [] = mergeSort(array, start, mid);
			int right [] = mergeSort(array, mid+1, end);
			return merge(left,right);
		}
	}
	
	public int [] merge(int []arr1, int []arr2){
		int l1 = arr1.length;
		int l2 = arr2.length;
		int i=0,j=0;
		int [] result = new int[l1+l2];
		while (i<l1 && j<l2){
			if (arr1[i] < arr2[j]){
				result [i+j] = arr1[i++];
			}else{
				result [i+j] = arr2[j++];
			}
		}
		
		if (j >= l2){
			while (i < l1){
				result[i+j]=arr1[i++];
			}
		}
		else if (i>=l1){
			while (j < l2){
				result[i+j]=arr2[j++];
			}
		}
		return result;
	}
//	
//	public static void main(String[] args ){
//		Mergesort m = new Mergesort();
//		int [] arr1 = {1,1,1,1,1,1,-1};
//		System.out.println(Arrays.toString(m.mergeSort(arr1, 0, arr1.length-1)));
//	}
} 
