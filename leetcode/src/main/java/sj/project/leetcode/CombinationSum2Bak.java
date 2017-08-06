package sj.project.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class CombinationSum2Bak {
	
	@Test
	public void test(){
		int[] candidates = new int[]{8,7,4,3};
		int target = 11;
		LinkedList<LinkedList<Integer>> result = (LinkedList)combinationSum(candidates, target);
		for(LinkedList<Integer> x : result){
			System.out.println(x.toString());
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>>[][] dp = new List[target][candidates.length];
		Arrays.sort(candidates);
		List<List<Integer>> result = combinationSum(candidates, target, candidates.length-1, dp);
		return result==null ? new LinkedList<List<Integer>>() : result;
	}
	
	private List<List<Integer>> combinationSum(int[] candidates, int target, int maxNumIndex, List<List<Integer>>[][] dp){
		System.out.println("start recursion --> target: "+target+" maxNum: "+candidates[maxNumIndex]);
		if(maxNumIndex < 0 || target < candidates[0]) {
			System.out.println("recursion return null target: "+(target)+" maxNum: "+candidates[maxNumIndex]);
			return null;
		}
		if(maxNumIndex == 0){
			if(target%candidates[0] != 0) {
				System.out.println("recursion return null target: "+(target)+" maxNum: "+ candidates[0]);
				return null;
			}
			int times = target/candidates[0];
			List<Integer> list = new LinkedList<>();
			while(times>0){
				list.add(candidates[0]);
				times--;
			}
			List<List<Integer>> result = new LinkedList<>();
			result.add(list);
			dp[target-1][0] = result;
			System.out.println("add dp target: "+(target)+" maxNum: "+ candidates[0]);
			for(List<Integer> x : result){
				System.out.println(((LinkedList)x).toString());
			}
			System.out.println("recursion return target: "+(target)+" maxNum: "+ candidates[0]);
			return result;
		}
		int n = target;
		List<List<Integer>> result = new LinkedList();
		List<Integer> current = new LinkedList<>();
		while(n >= candidates[0]){
			if(dp[n-1][maxNumIndex-1] != null){
				System.out.println("get dp target: "+n+" maxNum: "+candidates[maxNumIndex-1]);
				for(List<Integer> x : dp[n-1][maxNumIndex-1]){
					System.out.println(((LinkedList)x).toString());
				}
			}
			List<List<Integer>> temp = dp[n-1][maxNumIndex-1] == null ? combinationSum(candidates, n, maxNumIndex-1, dp) : dp[n-1][maxNumIndex-1];
			if(temp != null && !temp.isEmpty()){
				List<List<Integer>> x = new LinkedList<List<Integer>>();
				for(List<Integer> y: temp){
					x.add(new LinkedList<>(y));
				}
				for(List<Integer> a : x){
					a.addAll(current);
				}
				result.addAll(x);
			}
			current.add(candidates[maxNumIndex]);
			n-=candidates[maxNumIndex];
		}
		if(n==0){
			result.add(current);
		}
		if(!result.isEmpty()){
			dp[target-1][maxNumIndex] = result;
			System.out.println("add dp target: "+(target)+" maxNum: "+candidates[maxNumIndex]);
			for(List<Integer> x : result){
				System.out.println(((LinkedList)x).toString());
			}
			System.out.println("recursion return target: "+(target)+" maxNum: "+candidates[maxNumIndex]);
			return result;
		}
		System.out.println("recursion return null target: "+(target)+" maxNum: "+candidates[maxNumIndex]);
		return null;
	}
}
