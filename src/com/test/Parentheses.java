package com.test;

import java.util.ArrayList;

public class Parentheses {

	public ArrayList <String> generateParens (int count){
		char [] str = new char [count * 2];
		ArrayList <String> list = new ArrayList <String>();
		addParen(list, count, count, str, 0);
		return list;
		
	}
	
	public void addParen(ArrayList<String> list, int leftRem, int rightRem, char [] str, int count){
		
		if (leftRem < 0 || rightRem < leftRem ){
			return;
		}
		if (leftRem == 0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else{
			if (leftRem>0){
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			if (rightRem > leftRem){
				str[count]=')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Parentheses p = new Parentheses();
		System.out.println(p.generateParens(2));
	}

}
