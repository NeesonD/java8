package com.neeson.java8.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author : neeson
 * Date: 2018/8/12
 * Time: 16:54
 * Description: 
 */
public class HighFunction {

	public static void main(String[] args) {

	}

	/**
	 * 一个接收函数的函数
	 * @param val
	 * @param selector
	 * @return
	 */
	private static int totalSelectedValues(List<Integer> val, Predicate<Integer> selector) {
		return val.stream().filter(selector).reduce(0, Integer::sum);
	}

	/**
	 * 返回函数的函数
	 * @return
	 */
	private static Predicate<Integer> createIsOdd() {
		Predicate<Integer> check = num -> num % 2 != 0;
		Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> candidate -> candidate > pivot;
		return check;
	}

	static class Sample {
		public static void call(Runnable runnable) {
			System.out.println("calling runnable");

			//level 2 of stack
			runnable.run();
		}

		public static void main(String[] args) {
			int value = 4;  //level 1 of stack
			call(
					() -> System.out.println(value) //level 3 of stack
			);
		}
	}

}
