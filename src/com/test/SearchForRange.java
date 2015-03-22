package com.test;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * */
public class SearchForRange {

	public int[] searchRange(int[] A, int target) {
	    int index = binarySearch(A, 0, A.length-1, target);
	    int[] result = {-1, -1};
	    if (index != -1) {
	        int left  = index;
	        int right = index;
	        result[0] = left;
	        result[1] = right;
	        while ((left  = binarySearch(A, 0, left-1, target)) != -1)           result[0] = left;
	        while ((right = binarySearch(A, right+1, A.length-1, target)) != -1) result[1] = right;
	    }
	    return result;
	}

	private int binarySearch(int[] A, int lo, int hi, int target) {
	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        if      (A[mid] < target) lo = mid + 1;
	        else if (A[mid] > target) hi = mid - 1;
	        else return mid;            
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
