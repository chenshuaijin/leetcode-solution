package sj.project.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		if (nums.length < 4)
			return list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				for (int x = j + 1, y = nums.length - 1; x < y;) {
					int sum = nums[i] + nums[j] + nums[x] + nums[y];
					if (sum == target) {
						list.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
						while (x + 1 < j - 1 && nums[x] == nums[x + 1])
							x++;
						x++;
						while (y - 1 > i + 1 && nums[y] == nums[y - 1])
							y--;
						y--;
					} else if (sum < target) {
						x++;
					} else {
						y--;
					}
				}
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					j++;
			}
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++;
		}
		return list;
	}

	@Test
	public void test() {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
	}

}
