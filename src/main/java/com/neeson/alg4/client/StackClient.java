package com.neeson.alg4.client;

import com.neeson.alg4.ArrayStack;
import com.neeson.alg4.ListStack;
import com.neeson.alg4.Stack;

/**
 * @author : neeson
 * Date: 2018/8/15
 * Time: 22:08
 * Description: 
 */
public class StackClient {

	public static void main(String[] args) {
		testArray();
		testList();
	}

	private static void testList() {
		ListStack<String> strings = new ListStack<>();
		strings.push("2");
		System.out.println(strings.size());
		strings.pop();
		System.out.println(strings.size());
	}

	private static void testArray() {
		Stack<String> stringStack = new ArrayStack<>(10);
		stringStack.push("1");
		System.out.println(stringStack.size());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.size());
	}

}
