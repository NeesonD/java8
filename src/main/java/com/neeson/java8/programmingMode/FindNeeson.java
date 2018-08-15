package com.neeson.java8.programmingMode;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * @author : neeson
 * Date: 2018/8/12
 * Time: 13:11
 * Description: 
 */
public class FindNeeson {

	public static void main(String[] args) {
		List<String> names = Lists.newArrayList("dory", "neeson");
		findNeeson(names);
		findNeesonByDeclarativeStyle(names);
		findNeesonByFunctionalStyle(names);
	}

	/**
	 * 命令式编程
	 * @param names
	 */
	private static void findNeeson(List<String> names) {
		//垃圾变量
		boolean found = false;
		for (String name : names) {
			if (Objects.equals(name, "neeson")) {
				found = true;
				break;
			}
		}

		if (found) {
			out.println("found neeson");
		} else {
			out.println("not found neeson");
		}
	}

	/**
	 * 声明式编程
	 * @param names
	 */
	private static void findNeesonByDeclarativeStyle(List<String> names){
		if (names.contains("neeson")){
			out.println("found neeson");
		}else {
			out.println("not found neeson");
		}
	}

	/**
	 * 函数式编程
	 * @param names
	 */
	private static void findNeesonByFunctionalStyle(List<String> names){
		names.stream().filter(input -> Objects.equals(input, "neeson"))
				.collect(Collectors.toList()).forEach(out::print);
	}

}
