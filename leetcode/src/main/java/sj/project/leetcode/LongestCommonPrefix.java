package sj.project.leetcode;

import org.junit.Test;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0)return "";
        int minLength = Integer.MAX_VALUE;
        for(String s : strs){
        	minLength = Math.min(minLength, s.length());
        }
        for(int i=0;i<minLength;i++){
        	char temp = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++){
        		if(strs[j].charAt(i)!=temp){
        			return strs[0].substring(0, i);
        		}
        	}
        }
        return strs[0].substring(0, minLength);
    }

	@Test
	public void test(){
		System.out.println(longestCommonPrefix(new String[]{""}));
	}
}
