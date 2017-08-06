package sj.project.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if(nums.length<2)return result;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			for(int j=i+1,z=nums.length-1;j<nums.length-1 && z>j;){
				if(nums[i]+nums[j]+nums[z]==0){
					result.add(Arrays.asList(nums[i],nums[j],nums[z]));
					while(z-1>0 && nums[z-1]==nums[z])z--;
					while(j+1<nums.length-1 && nums[j+1]==nums[j])j++;
					j++;z--;
				}else if(nums[i]+nums[j]+nums[z]<0){
					j++;
				}else{
					z--;
				}
			}
			while(i+1<nums.length-2 && nums[i+1]==nums[i])i++;
		}
		return result;
	}

	@Test
	public void test(){
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
}
