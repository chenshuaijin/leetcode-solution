package sj.project.leetcode;

public class MedianOfTwoSortedArrays {
	
	public static void main(String args[]){
		MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
		double result = motsa.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
		System.out.println(result);
		
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int[] nums3 = new int[nums1.length+nums2.length];
		int i = 0;
		int j = 0;
		for(int x = 0;x<nums3.length;x++){
			if(i == nums1.length){
				for(;x<nums3.length;x++){
					nums3[x] = nums2[j++];
				}
			} else if (j == nums2.length){
				for(;x<nums3.length;x++){
					nums3[x] = nums1[i++];
				}
			}else{
				nums3[x] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
			}
			
		}
		return nums3.length%2==0?((nums3[nums3.length/2]+nums3[nums3.length/2 -1])/2.0):(nums3[(nums3.length-1)/2]);
	}

	
}
