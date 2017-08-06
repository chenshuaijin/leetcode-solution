package sj.project.leetcode;

public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode pointer = new ListNode(0);
		ListNode record = pointer;
		pointer.next = 	head;
		while (pointer.next != null && pointer.next.next != null) {
			ListNode temp = pointer.next.next.next;
			pointer.next.next.next = pointer.next;
			pointer.next = pointer.next.next;
			pointer.next.next.next = temp;
			pointer = pointer.next.next;
		}
		return record.next;
	}

}
