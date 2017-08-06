package sj.project.leetcode;

import org.junit.Test;

public class RomanToInteger {
	public int romanToInt(String s) {
        int[] sa=new int[s.length()];
        switch(s.charAt(0)){
    	case 'I':sa[0]=1;break;
    	case 'V':sa[0]=5;break;
    	case 'X':sa[0]=10;break;
    	case 'L':sa[0]=50;break;
    	case 'C':sa[0]=100;break;
    	case 'D':sa[0]=500;break;
    	case 'M':sa[0]=1000;break;
    	}
        int sum = 0;
        int i=0;
        for(;i<s.length()-1;i++){
        	switch(s.charAt(i+1)){
        	case 'I':sa[i+1]=1;break;
        	case 'V':sa[i+1]=5;break;
        	case 'X':sa[i+1]=10;break;
        	case 'L':sa[i+1]=50;break;
        	case 'C':sa[i+1]=100;break;
        	case 'D':sa[i+1]=500;break;
        	case 'M':sa[i+1]=1000;break;
        	}
            if(sa[i]<sa[i+1]){
                sum-=sa[i];
            }else{
                sum+=sa[i];
            }
        }
        return sum+=sa[i];
    }
	
	@Test
	public void test(){
		System.out.println(romanToInt("CCXXV"));
	}

}
