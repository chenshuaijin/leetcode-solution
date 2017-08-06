package sj.project.leetcode;

import org.junit.Test;

public class StringToInteger {

	public int myAtoi(String str) {
		str = str.trim();
		if(str.length()==0)return 0;
		int result = 0;
		int temp = 0;
		int sign = 1;
		int i = 0;
		if(str.charAt(i) == '-'){
			sign = -1;
			i++;
		}else if(str.charAt(i) == '+'){
			i++;
		}
		if(i>=str.length())return 0;
		if(str.charAt(i)<'0' || str.charAt(i)>'9'){
			return 0;
		}else {
			result = (str.charAt(i++)-'0')* sign;
		}
		for(;i<str.length();i++){
			if(str.charAt(i)<'0' || str.charAt(i)>'9') break;
			temp = result;
			result = result * 10 + (str.charAt(i)-'0')*sign;
			if(result/10 != temp) return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
		}
		return (int) result;
	}
	
	@Test
	public void test(){
		System.out.println(myAtoi("-123"));
	}

}
