package sj.project.leetcode;

import org.junit.Test;

public class MultiplyStrings {
	
	@Test
	public void test(){
		System.out.println(multiply("12345", "9876543"));
	}
	
	public String multiply(String num1, String num2) {
		int[] result = new int[num1.length()+num2.length()];
		char[] ca = new char[result.length];
		for(int i=num1.length()-1;i>=0;i--){
			for(int j=num2.length()-1;j>=0;j--){
				int a = num1.charAt(i)-'0';
				int b = num2.charAt(j)-'0';
				result[i+j+1] += a*b;
			}
		}
		int carry = 0;
		for(int i=result.length-1;i>=0;i--){
			carry += result[i];
			ca[i] = (char) (carry%10 + '0');
			carry = carry/10;
		}
//		ca[0] = (char) (carry + '0');
		StringBuilder sb = new StringBuilder(new String(ca));
		if(sb.charAt(0)=='0')sb.deleteCharAt(0);
		return sb.toString();
	}
	
	
}
