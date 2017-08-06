package sj.project.leetcode;

import org.junit.Test;

public class CountAndSay {
	
	@Test
	public void test(){
		System.out.println(countAndSay(4));
	}
	
	public String countAndSay(int n) {
        String s = "1";
        StringBuffer sb;
        for(int i=1;i<n;i++){
        	sb = new StringBuffer();
            int count = 0;
            int num = 0;
            for(int j=0;j<s.length();j++){
            	int temp = s.charAt(j) - '0';
            	if(temp == num){
            		count++;
            	} else {
            		if(count==0){
            			num = temp;
            			count++;
            		}else{
            			sb.append(count).append(num);
            			num = temp;
            			count = 1;
            		}
            	}
            }
            sb.append(count).append(num);
            s = sb.toString();
        }
        return s;
    }

}
