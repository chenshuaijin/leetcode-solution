package sj.project.leetcode;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int result = 0;
		if (head.next == null) {
			result = 1;
		} else {
			result = indexFromTheEndAndRemove(head, n) + 1;
		}

		if (result == n)
			return head.next;
		return head;
	}

	private int indexFromTheEndAndRemove(ListNode parent, int index) {
		ListNode current = parent.next;
		int currentIndex = 0;
		if (current.next == null) {
			currentIndex = 1;
		} else {
			currentIndex = indexFromTheEndAndRemove(current, index) + 1;
		}
		if (currentIndex == index) {
			parent.next = current.next;
		}
		return currentIndex;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
