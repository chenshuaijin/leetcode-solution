package sj.project.leetcode;

import org.junit.Test;

public class JumpGameII {
	
	@Test
	public void test(){
		int[] nums = {2,3,1,1,4};
		System.out.println(jump(nums));
	}
	
	
	public int jump(int[] nums) {
		if(nums.length<=1)return 0;
		int[] minJumps = new int[nums.length-1];
		for(int i=minJumps.length-1;i>=0;i--){
			if(i+nums[i]>=minJumps.length){
				minJumps[i] = 1;
			}else{
				int min=Integer.MAX_VALUE;
				for(int j=i+nums[i];j>i;j--){
					if(minJumps[j]==1){
						min=1;
						break;
					}else if(minJumps[j]==0){
						continue;
					}else{
						min = Math.min(min, minJumps[j]);
					}
				}
				if(min != Integer.MAX_VALUE){
					minJumps[i] = min + 1;
				}
				
			}
		}
		return minJumps[0];
	}
}
