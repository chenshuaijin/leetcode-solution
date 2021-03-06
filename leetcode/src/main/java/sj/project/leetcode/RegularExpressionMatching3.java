package sj.project.leetcode;

import org.junit.Test;
/**
 * 动态规划方法
 * @author chens
 *
 */
public class RegularExpressionMatching3 {
	
	public boolean isMatch(String s, String p) {
		if( s==null || p==null )return false;
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		int i = 0;
		int j = 0;
		dp[0][0] = true;
		for(;j<p.length();j++){
			if(p.charAt(j)=='*'){
				dp[0][j+1] = dp[0][j-1];
			}
		}
		for(;i<s.length();i++){
			for(j=0;j<p.length();j++){
				if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
					dp[i+1][j+1]=dp[i][j];
				}else if(p.charAt(j)=='*'){
					if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.'){
						dp[i+1][j+1] =	dp[i+1][j-1];
					}else{
						dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	

	
	@Test
	public void test(){
		System.out.println(isMatch("aa", ".*"));
	}

}
