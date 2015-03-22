package com.test;
/*
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] != num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -inf.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
We can use Divide and Conquer to find a peak in O(Logn) time. 
The idea is Binary Search based, we compare middle element with its neighbors. 
If middle element is greater than both of its neighbors, then we return it. 
If the middle element is smaller than the its left neighbor, then there is always a peak in left half 
(Why? take few examples). If the middle element is smaller than the its right neighbor, 
then there is always a peak in right half (due to same reason as left half). 
 * Perform a binary search.
 * It can be shown that if binary search works.
 * */
public class FindPeakElement {

	public int findPeakElement(int[] num) {
        if (num.length<2){
            return num.length-1;
        }
        int end = num.length-1;
        int start = 0;
        int mid = (end+start)/2;
        while (end-start>1){
            if (num[mid]>num[mid-1]&&num[mid]>num[mid+1]){
                return mid;
            }
            else if(num[mid]<num[mid-1]){
                end = mid-1;
                mid = (end+start)/2;
            }
            else if(num[mid]<num[mid+1]){
                start = mid+1;
                mid = (end+start)/2;
            }
        }
        if (num[start]>num[end]){
            return start;
        }else{
            return end;
        }
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
