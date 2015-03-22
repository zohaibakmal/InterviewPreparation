package com.test;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * */
public class DeleteDuplicatesLinkedList {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			while(temp.next != null && temp.next.val == temp.val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
