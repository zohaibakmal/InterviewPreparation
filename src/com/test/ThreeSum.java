package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
	(-1, -1, 2)
 * 
 * */

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < num.length-2; ++i) {
            if(i > 0 && num[i] == num[i-1])
                continue;

            int j = i + 1, k = num.length-1;

            while(j < k) {
                int candidate = num[i] + num[j] + num[k];
                if(candidate <= 0) {
                    if(candidate == 0)
                        result.add(Arrays.asList(num[i],num[j], num[k]));
                    ++j;
                    while (j < k && num[j] == num[j-1])
                        ++j;
                }
                else if(candidate > 0) {
                    --k;
                    while (k > j && num[k] == num[k+1])
                        --k;
                }
            }
        }

        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
