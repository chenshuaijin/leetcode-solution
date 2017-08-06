package sj.project.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	
	    public int lengthOfLongestSubstring(String s) {
	    	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	    	char[] ca = s.toCharArray();
	    	int max = 0;
	    	int lowerBound = 0;
	    	for(int i=0;i<s.length();i++){
	    		if(charMap.containsKey(ca[i]) && charMap.get(ca[i]) >= lowerBound ){
	    			lowerBound = charMap.get(ca[i]) + 1;
	    			max = ((i - charMap.get(ca[i])) > max) ?(i - charMap.get(ca[i])):max;
	    		} else if(i-lowerBound + 1 > max){
	    			max = i-lowerBound + 1;
	    		}
	    		charMap.put(ca[i], i);
	    	}
	    	return max;
	    }
	    //leetcode 测试最快 38ms
	    public int lengthOfLongestSubstring2(String s) {
	    	int[] array = new int[128];
	    	char[] ca = s.toCharArray();
	    	int max = 0;
	    	int lowerBound = 1;
	    	int temp;
	    	for(int i=0;i<s.length();i++){
	    		int x = array[ca[i]];
	    		if(x >= lowerBound ){
	    			lowerBound = x + 1;
	    			max = (i+1 - x > max) ?(i+1 - x): max;
	    		} else{
	    			temp =  i-lowerBound + 2;
	    			max = temp > max ? temp : max;
	    		}
	    		array[ca[i]] = i+1;
	    	}
	    	return max;
	    }
	    
	    public int lengthOfLongestSubstring3(String s) {
	    	int[] array = new int[128];
	    	int max = 0;
	    	int lowerBound = 1;
	    	int temp;
	    	for(int i=0;i<s.length();i++){
	    		int x = array[s.charAt(i)];
	    		if(x >= lowerBound ){
	    			lowerBound = x + 1;
	    			max = (i+1 - x > max) ?(i+1 - x): max;
	    		} else{
	    			temp =  i-lowerBound + 2;
	    			max = temp > max ? temp : max;
	    		}
	    		array[s.charAt(i)] = i+1;
	    	}
	    	return max;
	    }
	    
	    @Test
	    public void test(){
	    	System.out.println(lengthOfLongestSubstring2("abcabcbb"));
	    }
	    

}
