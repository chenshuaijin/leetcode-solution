package sj.project.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LetterCombinationsOfAPhoneNumber {
	
	private char[][] mapper = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<>();
		if(digits == null || digits.equals(""))return list;
		char[] ca = digits.toCharArray();
		char[] result = new char[ca.length];
		parseDigits(list, ca, result, 0);
		return list;
	}

	private void parseDigits(List<String> list, char[] ca, char[] result, int offset) {
		int loops = 0;
		if (ca[offset] == '9' || ca[offset] == '7') {
			loops = 4;
		} else {
			loops = 3;
		}
		for (int i = 0; i < loops; i++) {
			result[offset] = mapper[ca[offset]-'2'][i];
			if (offset == ca.length - 1) {
				list.add(new String(result));
			}else{
				parseDigits(list, ca, result, offset+1);
			}
		}
	}
	
	@Test
	public void test(){
		System.out.println(letterCombinations("23"));
	}

}
