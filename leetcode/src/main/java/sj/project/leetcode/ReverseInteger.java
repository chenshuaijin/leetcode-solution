package sj.project.leetcode;

import org.junit.Test;

public class ReverseInteger {

	public int reverse(int x) {
		String inStr = Integer.toString(x);
		StringBuilder sb = new StringBuilder(inStr);
		if(inStr.startsWith("-")){
			sb.deleteCharAt(0).reverse().insert(0, "-");
		}else{
			sb.reverse();
		}
		int result;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			result = 0;
		}	
		return result;
	}
	
	public int reverse2(int x){
		int temp = x;
		int y;
		int reverse = 0;
		while(temp != 0){
			y = reverse;
			reverse = reverse * 10 + temp%10;
			if(reverse/10 != y) return 0;
			temp/=10;
		}
		return reverse;
	}
	
	@Test
	public void test2(){
		System.out.println(reverse2(10));
	}

}
