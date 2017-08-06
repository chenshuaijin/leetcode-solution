package sj.project.leetcode;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			return executePlus(l1, l2, 0);
		}
		private ListNode executePlus(ListNode l1, ListNode l2,int addCarry){
			if (l1==null && l2 == null && addCarry == 0) return null;
			int num1;
			int num2;
			num1 = l1==null ? 0 :l1.val;
			num2 = l2==null ? 0 :l2.val;
			ListNode thisNode = new ListNode((num1+num2+addCarry) % 10);
			thisNode.next = executePlus(l1==null?null:l1.next, l2==null?null:l2.next, (num1+num2+addCarry)/10);
			return thisNode;
		}
	}
	
}
