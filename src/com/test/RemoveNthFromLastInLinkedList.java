package com.test;

public class RemoveNthFromLastInLinkedList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode (0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		//move fast n places ahead of slow
		for (int i = 0; i<n;i++){
			fast = fast.next;
		}

		while (fast!=null&&fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;

		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
