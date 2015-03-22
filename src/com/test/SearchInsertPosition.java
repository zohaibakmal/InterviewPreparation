package com.test;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
 * */

public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < A[mid]) hi = mid - 1;
            else if (target > A[mid]) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
