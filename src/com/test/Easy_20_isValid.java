package com.test;

import java.util.Stack;

public class Easy_20_isValid {
	public static void main(String[] args) {
		String string01 = "()";
		String string02 = "()[]{}";
		String string03 = "({)}";
		System.out.println(isValid(string01));
		System.out.println(isValid(string02));
		System.out.println(isValid(string03));
	}
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for(int i = 0; i < length; i++){
            char ch = charArray[i];
            switch(ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case '}':
                	if (stack.isEmpty()) {
						return false;
					}
                	char current01 = stack.peek();
                    if(current01 == '{'){
                        stack.pop();
                    }else {
						return false;
					}
                    break;
                case ']':
                	if (stack.isEmpty()) {
						return false;
					}
                	char current02 = stack.peek();
                    if(current02 == '['){
                        stack.pop();
                    }else {
						return false;
					}
                    break;
                case ')':
                	if (stack.isEmpty()) {
						return false;
					}
                	char current03 = stack.peek();
                    if(current03 == '('){
                        stack.pop();
                    }else {
						return false;
					}
                    break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
