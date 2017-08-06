package sj.project.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
	
    public int longestValidParentheses(String s) {
    	if(s==null || s.length()<2) return 0;
    	Deque<Integer> stack = new ArrayDeque<>(s.length());
    	int left = -1;
    	int max = 0;
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='('){
    			stack.push(i);
    		}else{
    			if(stack.isEmpty())left = i;
    			else {
    				stack.remove();
    				if(stack.isEmpty())max = Math.max(max, i-left);
    				else max = Math.max(max, i-stack.peek());
    			}
    		}
    	}
    	return max;
    }

}
