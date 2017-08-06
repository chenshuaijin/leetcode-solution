package sj.project.leetcode;

import org.junit.Test;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if(numRows == 1 || s.length() == 1 )return s;
		int width = (numRows -1) * s.length()/(2*numRows-2) + numRows -1;
		char[][] caa = new char[numRows][width];
		int index=0;
		for(int i=0;i<width;i++){
			for(int j=0;j<numRows;j++){
				if(i%(numRows-1) == 0 || i%(numRows-1)+j == numRows-1){
					caa[j][i] = s.charAt(index++);
					if(index == s.length()) break;
				}
			}
			if(index == s.length()) break;
		}
		char[] result = new char[s.length()];
		index = 0;
		for(int i=0;i<numRows;i++){
			for(int j=0;j<width;j++){
				if(caa[i][j] != 0) result[index++] = caa[i][j];
			}
		}
		return new String(result);
	}
	
	@Test
	public void test(){
		System.out.println(convert("ABC", 2));
	}

}
