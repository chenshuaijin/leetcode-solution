package sj.project.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutation {
	
	@Test
	public void test(){
		int[] nums = new int[]{3,2,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<2)return;
		int x=-1;
		for(int i=nums.length-1;i>0;i--){
			if(nums[i]>nums[i-1]){
				x=i-1;
				break;
			}
		}
		if(x>-1){
			for(int i=x+1;i<nums.length;i++){
				if(nums[i] <= nums[x] || i==nums.length-1){
					if(i==nums.length-1 && nums[i]>nums[x]){
						i++;
					}
					int temp = nums[i-1];
					nums[i-1] = nums[x];
					nums[x] = temp;
					break;
				}
			}
		}
		for(int i=x+1,j=nums.length-1;i<j;i++,j--){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
	}

}
