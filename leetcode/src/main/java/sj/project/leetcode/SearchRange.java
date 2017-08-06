package sj.project.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class SearchRange {
	
	@Test
	public void test(){
		int[] params = new int[]{2,2};
		int[] res = searchRange(params, 2);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[]{-1,-1};
		if(nums==null || nums.length==0) return result;
		int start = findFirstGreatOrEquals(nums, target);
		if(start == nums.length || nums[start] > target) return result;
		return new int[]{start,findFirstGreatOrEquals(nums, target+1)-1};
	}
	
	private int findFirstGreatOrEquals(int[] nums, int target){
		int start=0,end=nums.length;
		while(start<end){
			int mid = (start + end) >> 1;
			if(nums[mid]<target){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return start;
	}
	
	
}
