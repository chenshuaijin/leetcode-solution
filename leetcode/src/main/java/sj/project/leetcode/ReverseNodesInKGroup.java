package sj.project.leetcode;


public class ReverseNodesInKGroup {

        
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)return null;
		ListNode previous = null;
		ListNode pointer = head;
		ListNode end = head;
		int length = 0;
		while(pointer!=null && length<k ){
			length++;
			pointer = pointer.next;
		}
		if(length<k)return head;
		pointer = head;
		for(int i=0;i<k && pointer!=null;i++){
			ListNode temp = pointer.next;
			pointer.next = previous;
			previous = pointer;
			pointer = temp;
		}
		if(pointer!=null && pointer.next!=null){
			end.next = reverseKGroup(pointer, k);
		}else{
			end.next = pointer;
		}
		return previous;
	}

}
