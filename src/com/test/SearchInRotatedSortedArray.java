package com.test;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * */
public class SearchInRotatedSortedArray {

    public int searchHelper(int[] A, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(A[mid] == target){
            return mid;
        }

        //Case 1: Left half is sorted
        if(A[mid] >= A[start]){
            if(target >= A[start] && target <= A[mid]){
                return searchHelper(A,target,start,mid-1);    
            }
            else{
                return searchHelper(A,target,mid+1,end);
            }
        }
        //Case 2: Right half is sorted
        if(A[end]>=A[mid]){
            if(target>=A[mid] && target<=A[end]){
                return searchHelper(A,target,mid+1,end);
            }
            else{
                return searchHelper(A,target,start,mid-1);
            }
        }
        return -1;
    }

    public int search(int[] A, int target) {
        return searchHelper(A,target,0,A.length-1);
    }
    
    public int searchItr(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        while (low < high) {
            int mid = (low + high + 1)/2;
            if (A[mid] == target) return mid;
            if (A[mid] > A[low]) {
                if (target < A[low] || target > A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
               if (target < A[mid] || target > A[high]) {
                   high = mid - 1;
               } else {
                   low = mid+1;
               }
            }
        }
        return low < A.length && A[low] == target ? low : -1;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
