package sj.project.leetcode;

import org.junit.Test;

public class TrappingRainWater {
	
	@Test
	public void test(){
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap2(height));
	}
	
	public int trap(int[] height) {
		int l=0,r=height.length-1;
		int count = 0;
		int currentHeight = 0;
		//略过两端高度为0的部分
		while(l<r && height[l]==0) l++;
		while(l<r && height[r]==0) r--;
		while(l<r){
			if(height[l]<=height[r]){
				currentHeight = height[l++];
				while(l<r && height[l]<= currentHeight){
					count += currentHeight - height[l];
					l++;
				}
			}else{
				currentHeight = height[r--];
				while(l<r && height[r]<= currentHeight){
					count += currentHeight - height[r];
					r--;
				}
			}
		}
		return count;
	}
	
	public int trap2(int[] height) {
		int leftWall=0,rightWall=0,l=0,r=height.length-1,res=0;
		while(l<r){
			if(height[l]<=height[r]){
				leftWall = Math.max(height[l], leftWall);
				res += leftWall - height[l];
				l++;
			} else {
				rightWall = Math.max(height[r], rightWall);
				res += rightWall - height[r];
				r--;
			}
		}
		return res;
	}
}
