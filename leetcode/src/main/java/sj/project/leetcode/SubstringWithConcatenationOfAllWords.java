package sj.project.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SubstringWithConcatenationOfAllWords {
	//O(n^2)
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new LinkedList<>();
		if(s==null || words==null || words.length==0)return result;
		Map<String, Integer> originMap = new HashMap<>();
		for(String word : words){
			originMap.put(word, originMap.containsKey(word)?originMap.get(word)+1 : 1);
		}
		Map<String, Integer> copyMap = new HashMap<>(originMap);
		int wl = words[0].length();
		for(int left=0;left<=s.length()-wl*words.length;left++){
			int right=left;
			String temp;
			boolean modified = false;
			while(right<=left+words.length*wl-wl && copyMap.containsKey(temp=s.substring(right,right+wl))){
				if(copyMap.get(temp)==1){
					copyMap.remove(temp);
					modified = true;
					if(copyMap.isEmpty()){
						result.add(left);
						break;
					}
				}else{
					copyMap.put(temp, copyMap.get(temp)-1);
					modified = true;
				}
				right+=wl;
			}
			if(modified) copyMap = new HashMap<>(originMap);
		}
		return result;
	}

	//干扰word长度与指定word相等时，可用此方法
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new LinkedList<>();
		if(s==null || words==null || words.length==0)return result;
		Map<String, Integer> originMap = new HashMap<>();
		for(String word : words){
			originMap.put(word, originMap.containsKey(word)?originMap.get(word)+1 : 1);
		}
		Map<String, Integer> copyMap = new HashMap<>(originMap);
		int wl = words[0].length();
		for(int left=0,right=0;right<s.length()/wl;){
			String word = s.substring(right*wl, right*wl+wl);
			if(originMap.containsKey(word)){
				if(copyMap.containsKey(word)){
					if(copyMap.get(word)==1){
						copyMap.remove(word);
					}else{
						copyMap.put(word, copyMap.get(word)-1);
					}
				}else{
					String temp;
					while(!(temp=s.substring(left*wl,left*wl+wl)).equals(word)){
						copyMap.put(temp, copyMap.containsKey(temp)?copyMap.get(temp)+1 : 1);
						left++;
					}
					left++;
				}
				if(copyMap.isEmpty())result.add(left*wl);
				right++;
			}else{
				right++;
				left = right;
				copyMap = new HashMap<>(originMap);
			}
		}
		return result;
	}
	
	@Test
	public void test(){
		List<Integer> result = findSubstring2("aaa", new String[]{"aa","aa"});
		System.out.println(result.toString());
	}

}
