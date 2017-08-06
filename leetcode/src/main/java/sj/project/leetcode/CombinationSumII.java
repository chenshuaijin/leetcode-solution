package sj.project.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class CombinationSumII {
	
	@Test
	public void test(){
		int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> result = combinationSum2(candidates, target);
		for(List<Integer> x : result){
			System.out.println((ArrayList)x);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(candidates);
		helper(candidates, target, 0, result, new LinkedList<Integer>());
		return result;
	}
	
	private void helper(int[] candidates, int target, int n, List<List<Integer>> result, LinkedList<Integer> list){
		if(n>=candidates.length || target < candidates[n]) return;
		int times = 1;
		while(n+times<candidates.length && candidates[n]==candidates[n+times])times++;
		helper(candidates, target, n+times, result, list);
		for(int i=1;i<=times;i++){
			list.add(candidates[n]);
			if(target == candidates[n]*i){
				result.add(new ArrayList<>(list));
			} else{
				helper(candidates, target-candidates[n]*i, n+times, result, list);
			}
		}
		while(times-- > 0){
			list.removeLast();
		}
	}
}
