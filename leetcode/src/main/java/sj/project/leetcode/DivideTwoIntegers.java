package sj.project.leetcode;

import org.junit.Test;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE && divisor==-1 || divisor==0)return Integer.MAX_VALUE;
		int sign = (dividend>0&&divisor>0) ||(dividend<0&&divisor<0) ? 1 : -1;
		long dividendl=Math.abs(Long.valueOf(dividend)),divisorl=Math.abs(Long.valueOf(divisor));
		return divideLong(dividendl, divisorl)*sign;
	}
	
	public int divideLong(long dividend, long divisor) {
		if(dividend < divisor)return 0;
		long sum = divisor;
		int multiple = 1;
		while(sum+sum < dividend){
			sum+=sum;
			multiple+=multiple;
		}
		return multiple+divideLong(dividend-sum, divisor);
	}
	@Test
	public void test(){
		System.out.println(divide(Integer.MIN_VALUE, 1));
	}

}
