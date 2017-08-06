package sj.project.leetcode;

import org.junit.Test;

public class PalindromeNumber {

	//这里其实不用怕溢出，因为回文数字不会溢出。。。
	public boolean isPalindrome(int x) {
		if(x >=0 && x <=9)return true;
		if(x < 0 || x%10==0)return false;
		int y = 0;
		while(x>=y){
			if(x==y || x/10==y)return true;
			y=y*10+x%10;
			x/=10;
		}
		return false;
	}
	//改进后版本
	public boolean isPalindrome1(int x) {
//		if(x < 0 || (x%10==0 && x!=0))return false;
		if(x < 0)return false;
		int y = 0;
		int temp = x;
		while(temp !=0){
			y=y*10+temp%10;
			temp/=10;
		}
		return x==y;
	}

	@Test
	public void test(){
		System.out.println(isPalindrome1(10));
	}
}
