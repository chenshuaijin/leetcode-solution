package sj.project.leetcode;

import org.junit.Test;

public class IntegerToRoman {
	public String intToRoman(int num) {
        int[] na={1,5,10,50,100,500,1000};
        char[] sa={'I','V','X','L','C','D','M'};
        int[] da={0,0,0,2,2,4,4};
        StringBuilder sb = new StringBuilder();
        for(int i=6;i>=0;i--){
            if(num/na[i]>=1){
            	for(int j=num/na[i];j>0;j--){
            		sb.append(sa[i]);
            		num-=na[i];
            	}
            }
            if(num >= na[i]-na[da[i]] && i !=0){
            	sb.append(sa[da[i]]).append(sa[i]);
            	num = num-na[i]+na[da[i]];
//            	i = da[i]+1;
            }
        }
        return sb.toString();
    }
	
	@Test
	public void test(){
		System.out.println(intToRoman(3999));
	}

}
