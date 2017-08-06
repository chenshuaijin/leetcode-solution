package sj.project.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class FirstMissingPositive {
	
	@Test
	public void test(){
		int nums[] = new int[]{1,1};
		System.out.println(firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length==0)return 1;
		for(int i=0;i<nums.length;){
			if(nums[i]<=0 || nums[i]==i+1 || nums[i]+1>nums.length || nums[nums[i]-1]==nums[i]) {
				i++;
				continue;
			}
			else {
				int temp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[temp-1] = temp;
			}
		}
		int i=0;
		while(i<nums.length && i+1==nums[i])i++;
		return i+1;
	}
	
//	public int firstMissingPositive(int[] nums) {
//		if(nums==null || nums.length==0)return 1;
//		Arrays.sort(nums);
//		if(nums[nums.length-1]<=0)return 1;
//		int i=0;
//		while(nums[i]<=0)i++;
//		if(nums[i]!=1) return 1;
//		i++;
//		for(;i<nums.length;i++){
//			if(nums[i]-nums[i-1]>1){
//				return nums[i-1]+1;
//			}
//		}
//		return nums[nums.length-1]+1;
//	}
}
