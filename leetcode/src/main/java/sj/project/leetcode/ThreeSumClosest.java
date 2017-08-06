package sj.project.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closestNum=nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length-2;i++){
			for(int left=i+1,right=nums.length-1;left<right;){
				int sum=nums[i]+nums[left]+nums[right];
				if(sum==target){
					return target;
				}else if(sum<target){
					closestNum = Math.abs(sum-target)<Math.abs(closestNum-target)?sum:closestNum;
					while(left+1<nums.length && nums[left]==nums[left+1])left++;
					left++;
				}else{
					closestNum = Math.abs(sum-target)<Math.abs(closestNum-target)?sum:closestNum;
					while(right-1>0 && nums[right]==nums[right-1])right--;
					right--;
				}
			}
			while(i+1<nums.length && nums[i]==nums[i+1])i++;
		}
		return closestNum;
	}
	
	@Test
	public void test(){
		System.out.println(threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
	}

}
