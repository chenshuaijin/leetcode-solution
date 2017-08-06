package sj.project.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		int left=0;
		int right=0;
		int closed=0;
		List<String> result = new LinkedList<>();
		if(n == 0)return result;
		generate(new char[n*2], left, right, closed, n, result);
		return result;
	}
	
	private void generate(char[] ca, int left, int right, int closed, int n, List<String> result){
		if(closed == n){
			result.add(new String(ca));
			return;
		}
		if(left<n){
			ca[left+right] = '(';
			generate(ca, left+1, right, closed, n, result);
		}
		if(right<n && left>right){
			ca[left+right] = ')';
			generate(ca, left, right+1, closed+1, n, result);
		}
	}
	
	@Test
	public void test(){
		System.out.println(generateParenthesis(3));
	}

}
