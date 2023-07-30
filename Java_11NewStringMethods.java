package com.java8.finishing;

import java.lang.invoke.MethodHandles;
import java.util.stream.IntStream;

public class Java_11NewStringMethods {
	public static void main(String... args) {
		/*
		 * java 8---String.join()-- stringJoiner class utill packge
		 * join(delimiter,elements of string) join(delimiter,iterable
		 * types(collections))
		 * 
		 * java 9 --- chars() codePoints()
		 */
		"JAVA".chars().forEach(System.out::println);
		System.out.println("Using codePoints() to print the unicode value");
		"JAVA".codePoints().forEach(System.out::println);

		IntStream result = "Java".chars();
		result.forEach(System.out::println);

		// java -10 no new method in string

		// java -11 -->isBlank(),lines() repeat(),strip(),
		// stripLeading() stripTrailing()

		System.out.println(" ".isBlank());
		System.out.println("hi\n hello\n kaviya".lines().count());
		System.out.println("java ".repeat(3));
		System.out.println("    hey kaviya java developer    ".strip());

		// java -12 indent() transform() describeConstable() resolveConstantDesc()

		System.out.println("kaviya Java\nDeveloper".indent(6));

		System.out.println("Kaviya Java Developer".transform((var sentences) -> sentences.toUpperCase()));

		System.out.println("Kaviya".describeConstable());

		System.out.println("Kaviya".describeConstable().get());

		System.out.println("Kaviya".resolveConstantDesc(MethodHandles.lookup()));
		// java -13 14 no new methods

		// java-15 formatted()
		// stripIndent() --remove indent begin and end

		// translateEscapes()
		// ---return a string with escape sequences translated as if in a string literal
		System.out.println("1) %d 2) %s 3) %s 4) %s".formatted(100, "Java", "Developer", "Software Field"));

	}

}
