package com.test;

public class ReverseListBetween {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode tail = null;
		ListNode beforeHead = start;
		for (int i = 1; i <= n; i++) {
			if (i < m) {
				beforeHead = head;
				head = head.next;
			} else if (i == m) {
				tail = head;
			} else {
				beforeHead.next = tail.next;
				tail.next = tail.next.next;
				beforeHead.next.next = head;
				head = beforeHead.next;
			}
		}
		return start.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
