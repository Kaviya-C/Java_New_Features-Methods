package com.java8.finishing;

import java.util.Arrays;
import java.util.List;
import static java.util.function.Predicate.not;

public class Java_11Features {
	public static void main(String... ar) {
		List<String> list = Arrays.asList(" ", "\t", "\n", "One", "Two");
		list.stream().filter((word) -> word.isBlank()).forEach((s) -> System.out.println(" --" + s));

		list.stream().filter((wo) -> !wo.isBlank()).forEach((s) -> System.out.println("--> " + s));

		list.stream().filter(not(String::isBlank)).forEach(System.out::println);

		/*
		 * before java -11 there is no static not() method in predicate
		 * 
		 * after java 11 predicate contains not() method as static
		 * 
		 * first way before java 11--->String::isBlank --->(word)-> !word.isBlank() --
		 * not blank --->Predicate.not(String::isBlank) --- import static
		 * java.util.function.Predicate.not; --not(String::isBlank)
		 */
	}

}
