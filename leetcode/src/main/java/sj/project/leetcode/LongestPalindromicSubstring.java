package sj.project.leetcode;

import org.junit.Test;

public class LongestPalindromicSubstring {

	//常规的遍历
	public String longestPalindrome(String s) {
		if (s.length() == 1)
			return s;
		char[] ca = s.toCharArray();
		int max = 0;
		int maxLength = 1;
		int maxIndex = 0;
		for (int i = 0; i < ca.length - max; i++) {
			if (i - 1 >= 0 && i + 1 < ca.length && ca[i - 1] == ca[i + 1]) {
				if (i - max-1 >= 0 && i + max+1 < ca.length && ca[i - max-1] == ca[i + max+1]) {
					int j = 2;
					while (i - j >= 0 && i + j < ca.length && ca[i - j ] == ca[i + j]) {
						j++;
					}
					if (maxLength < 2 * --j+1) {
						max = j;
						maxLength = 2 * j + 1;
						maxIndex = i;
					}
				}
			}
			if (i + 1 < ca.length && ca[i] == ca[i + 1]
					&& ((i + max + 1) < ca.length && ca[i - max] == ca[i + max + 1])) {
				int j = 1;
				while (i - j >= 0 && i + j + 1 < ca.length && ca[i - j] == ca[i + 1 + j]) {
					j++;
				}
				if (maxLength < 2 * j) {
					max = j - 1;
					maxLength = 2 * j;
					maxIndex = i;
				}
			}
		}
		return maxLength % 2 == 0 ? s.substring(maxIndex - max, maxIndex + max + 2)
				: s.substring(maxIndex - max, maxIndex + max + 1);
	}

	
	
	@Test
	public void test() {
		System.out.println(longestPalindrome("abcda"));
	}

}
