package com.test;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */
public class BestTimeStock {


	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1){
			return 0;
		}
		int min=prices[0];
		int profit=0;
		for(int i=1;i<prices.length;i++){
			min = Math.min(min,prices[i]);
			profit = Math.max(profit, prices[i]-min);
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
