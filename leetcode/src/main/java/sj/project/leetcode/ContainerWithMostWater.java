package sj.project.leetcode;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        int max=0;
        int low=0;
        int high=height.length-1;
        while(low<high){
            int minHeight = height[low]<height[high]?height[low]:height[high];
            int area = (high-low) * minHeight;
            max = area>max?area:max;
            if(height[low]<height[high]){
                low++;
            }else{
                high--;
            }
        }
        return max;
    }

}
