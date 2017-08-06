package sj.project.leetcode;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ValidParentheses {

	public boolean isValid(String s) {
		try {
			LinkedList<Character> stack = new LinkedList<>();
			char[] ca = s.toCharArray();
			for(int i=0;i<ca.length;i++){
				switch(ca[i]){
				case '(':
				case '[':
				case '{':
					stack.push(ca[i]);
					break;
				case ')':
					if(!stack.pop().equals(Character.valueOf('(')))return false;
					break;
				case ']':
					if(!stack.pop().equals(Character.valueOf('[')))return false;
					break;
				case '}':
					if(!stack.pop().equals(Character.valueOf('{')))return false;
					break;
					
				}
			}
			if(stack.size()==0)return true;
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	@Test
	public void test(){
		System.out.println(isValid("asdfw(asdfaw)"));
	}
}
