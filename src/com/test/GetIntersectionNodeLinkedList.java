package com.test;
/*
 * 
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 -> a2
					\
                     c1 -> c2 -> c3
                    /
B:     b1 -> b2 -> b3
begin to intersect at node c1.*/
public class GetIntersectionNodeLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) 
			return null;
		int lenA = length(headA), lenB = length(headB);
		// move headA and headB to the same start point

		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		// find the intersection until end
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
