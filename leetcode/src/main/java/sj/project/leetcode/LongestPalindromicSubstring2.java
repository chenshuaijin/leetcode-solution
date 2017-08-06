package sj.project.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class LongestPalindromicSubstring2 {

	//动态规划
	public String longestPalindrome2(String s) {
		int[] dp = new int[s.length()];
		dp[0]=1;
		dp[1]=2;
		return null;
	}
	
	
	
	
	@Test
	public void test() {
		System.out.println(longestPalindrome2("ccc"));
	}

}
