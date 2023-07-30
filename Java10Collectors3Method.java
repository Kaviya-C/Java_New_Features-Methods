package com.java8.finishing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java10Collectors3Method {
	public static void main(String... args) {
		List<String> list = Arrays.asList("Salem", "Chennai", "Ooty", "Singapore");
		List<String> unmodify = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toUnmodifiableList());
		System.out.println(unmodify);

		Set<String> name = new HashSet<>();
		name.add("Delhi");
		name.add("Pune");
		name.add("Udupi");
		name.add("kodaikanal");
		name.add("Trichy");

		Set<String> unmodify1 = name.stream().filter((word) -> word.length() > 5)
				.collect(Collectors.toUnmodifiableSet());
		System.out.println(unmodify1);

		Map<String, Integer> map = Stream.of("one", "Two", "three", "four", "five", "six")
				.collect(Collectors.toUnmodifiableMap((element) -> element, String::length));
		System.out.println(map);

		Map<Integer, String> map1 = Stream.of("one", "Two", "three", "four", "five", "six")
				.collect(Collectors.toUnmodifiableMap(String::length, d -> d, (s1, s2) -> s1 + " " + s2));
		System.out.println(map1);

	}

}
