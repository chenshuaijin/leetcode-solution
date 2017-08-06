package sj.project.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class MergeKSortedLists {

	//O(n^2)时间复杂度
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode point = head;
		for(ListNode node : lists){
			point = head;
			while(node != null){
				if(point.next==null || node.val<= point.next.val){
					ListNode temp = point.next;
					point.next = node;
					node = node.next;
					point.next.next = temp;
				}else{
					point = point.next;
				}
			}
		}
		head = head.next;
		return head;
	}
	
	//
	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode point = head;
		boolean isEnd = false;
		while(!isEnd){
			isEnd = true;
			ListNode min = null;
			int minIndex = 0;
			for(int i=0;i<lists.length;i++){
				if(lists[i]!=null){
					isEnd = false;
					if(min==null){
						min = lists[i];
						minIndex = i;
					}else if(min.val > lists[i].val){
						min = lists[i];
						minIndex = i;
					}
				}
			}
			if(min != null){
				point.next = min;
				lists[minIndex] = lists[minIndex].next;
				if(point.next != null)point.next.next = null;
				point = point.next;
			}
		}
		
		head = head.next;
		return head;
	}
	
	//二叉堆实现
	public ListNode mergeKLists4(ListNode[] lists) {
		PriorityQueue<ListNode> prioQueue = new PriorityQueue<>(11, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val < o2.val)return -1;
				if(o1.val > o2.val)return 1;
				return 0;
			}
		});
		for(ListNode node : lists){
			while(node != null){
				prioQueue.add(node);
				node = node.next;
			}
		}
		ListNode result = prioQueue.poll();
		if(result==null)return null;
		ListNode head = result;
		while((result.next = prioQueue.poll())!=null){
			result = result.next;
		}
		return head;
	}
	
	/**
	 * <p>
	 * 	红黑树实现
	 * </p>
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists3(ListNode[] lists){
		return null;
	}
	
	public static class RBTreeNode{
		public int value;
		public int color;//0 red,1 black
		public RBTreeNode parent;
		public RBTreeNode left;
		public RBTreeNode right;
		
		public static RBTreeNode insert(RBTreeNode root, RBTreeNode node){
			
			return null;
		}
		//前驱
		public static RBTreeNode predecessor(RBTreeNode node){
			if(node.left==null){
				return null;
			}else if(node.left.right==null){
				return node.left;
			}else{
				RBTreeNode temp = node.left.right;
				while(temp != null){
					temp = temp.right;
				}
				return temp;
			}
		}
		//后继
		public static RBTreeNode successor(RBTreeNode node){
			RBTreeNode temp = node;
			if(node.right == null){
				if(node.parent == null)return null;
				while(temp.parent.left != temp){
					temp = temp.parent;
					if(temp.parent == null)return null;
				}
				return temp;
			}else{
				if(node.right.left==null)return node.right;
				while(temp.left!=null){
					temp = temp.left;
				}
				return temp;
			}
		}
	}
	
	@Test
	public void test(){
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		printListNode(mergeKLists2(new ListNode[]{l1,l2}));
	}
	private void printListNode(ListNode node){
		if(node != null){
			System.out.println(node.val+"  ");
			printListNode(node.next);
		}else{
			return;
		}
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
