package sj.project.leetcode;

import org.junit.Test;
/**
 * 有bug
 * @author chens
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s.length()!=0 && (p.length()==0 || p.startsWith("*"))) return false;
	    if(s.length()==0){
	        if(p.length()==2 && p.charAt(1)=='*'){
	            return true;
	        }else if(p.length()>2 && p.charAt(1)=='*'){
	            return isMatch(s,p.substring(2));
	        }else{
	            return false;
	        }
	    }
	    char pc = p.charAt(0);
	    char sc = s.charAt(0);
	    char pcn = p.charAt(1);
	    if(pc=='.' || sc==pc){
	        if(pcn=='*'){
	            if(isMatch(s.substring(1),p)){
	                return true;
	            }else{
	                return isMatch(s.substring(1),p.substring(2));
	            }
	        }else{
	            return isMatch(s.substring(1),p.substring(1));
	        }
	    }else{
	        return false;
	    }
	}
	
	//.匹配1个，*匹配0个或多个的解法
	public boolean isMatch1(String s, String p) {
		if(p.length() == 0 )return false;
		int pointNum = 0;
		int starNum = 0;
		int fixedCharNum = 0;
		int i=0;
		for(;i<p.length();i++){
			if(p.charAt(i)=='.'){
				pointNum++;
			}else if(p.charAt(i)=='*'){
				starNum++;
			}else if(p.charAt(i)!='*')break;
		}
		for(;i<p.length();i++){
			if(p.charAt(i)!='.' && p.charAt(i)!='*'){
				fixedCharNum++;
			}else{
				break;
			}
		}
		if((pointNum + starNum) == p.length() && s.length() >= pointNum) return true;
		int index = 0;
		int offset = 0;
		while((index =s.substring(offset).indexOf(p.substring(pointNum+starNum,pointNum+starNum+fixedCharNum)))>=0){
			offset+=index;
			if(i==p.length()) {
				if(offset+fixedCharNum == s.length()){
					return true;
				}else {
					return false;
				}
			}
			if(offset==pointNum || starNum>0) {
				if(isMatch(s.substring(index+fixedCharNum),p.substring(pointNum+starNum+fixedCharNum))) return true;
			}else {
				return false;
			}
			offset++;
		}
		return false;
	}
	
	@Test
	public void test(){
		System.out.println(isMatch("abcd", "d*"));
	}

}
