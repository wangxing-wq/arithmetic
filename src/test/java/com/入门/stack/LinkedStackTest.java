package com.入门.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 王兴
 * @version 1.0
 * @date 2022/5/24 9:55
 */
class LinkedStackTest {

	@Test
	public void testStack() {
		LinkedStack<Integer> stack = new LinkedStack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.search(1));
	}

	@Test
	public void isValid() {
		System.out.println(isValid("{[()]}"));
	}

	@Test
	public void backspaceCompare(){


		System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
	}

	@Test
	public void calculate(){
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	@Test
	public void nextGreaterElement(){
		int [] numb1 = {3,1,5,7,9,2,6};
		int [] numb2 = {1,2,3,5,6,7,9,11};
		System.out.println(Arrays.toString(nextGreaterElement(numb1, numb2)));
	}

	@Test
	public void calPoint(){
		// 5 -2 -4 9 5 14
		String [] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
	}

	public int calPoints(String[] ops) {
		if (ops == null || ops.length == 0){return 0;}
		Stack<Integer> stack = new Stack<>();
		for (String op : ops) {
			if (op.equals("C") && stack.size() != 0){
				stack.pop();
			}else if (op.equals("D")){
				Integer a = stack.pop();
				stack.push(a);
				stack.push(a * 2);
			}else if (op.equals("+")){
				Integer a = stack.pop();
				Integer b = stack.pop();
				stack.push(b);
				stack.push(a);
				stack.push(a + b);
			}else if (!op.equals("C")){
				stack.push(Integer.parseInt(op));
			}
		}
		int result = 0;
		for (Integer integer : stack) {
			result += integer;
		}
		return result;
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
			return null;
		}


		return nums1;
	}

	public int calculate(String s) {
		if (s == null || "".equals(s)){
			return 0;
		}
		for (char c : s.toCharArray()) {

		}
		return 0;
	}

	public boolean backspaceCompare(String s, String t) {
		if (s == null || t == null){return false;}
		if (s.equals(t)){return true;}
		Stack<Character> a = new Stack<>();
		Stack<Character> b = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c != '#'){
				a.push(c);
				continue;
			}
			if (a.size() != 0){
				a.pop();
			}

		}
		for (char c : t.toCharArray()) {
			if (c != '#'){
				b.push(c);
				continue;
			}
			if (b.size() != 0){
				b.pop();
			}
		}
		if (a.size() != b.size()){
			return false;
		}
		while (a.size() != 0){
			Character aPop = a.pop();
			Character bPop = b.pop();
			if (!aPop.equals(bPop)){
				return false;
			}
		}
		return true;
	}

	public boolean isValid(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		LinkedStack<Character> stack = new LinkedStack<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == '(') {
				stack.push(')');
			} else if (aChar == '{') {
				stack.push('}');
			} else if (aChar == '[') {
				stack.push(']');
			} else if (stack.empty() || aChar != stack.pop()){
				return false;
			}

		}
		return stack.empty();
	}

}
