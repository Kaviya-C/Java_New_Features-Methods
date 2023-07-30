package com.java8.finishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java9_Features {
	/*
	 * interface can contain private methods and private static methods within the
	 * class if particular line of code need repeatedly u can mention in that lines
	 * in private method and call that method inside the class inside private method
	 * we can access instances variable inside private static method we can access
	 * static member only
	 * 
	 * 
	 * java 9
	 * 
	 * JShell-- Repl tool as like python scala --> REPL tool name-->Jshell /save
	 * /open /drop /list /vars /methods /types /edit /imports
	 * 
	 * Immutable collections
	 * 
	 * Collections.umodifiableList,unmodifiableSet,unmodifiableMap
	 * 
	 * List.of() Set.of() Map.of() Map.ofEntries()
	 * 
	 */
	List<Integer>[] list;

	@SafeVarargs
	Java9_Features(List<Integer>... lists) {
		this.list = lists;
	}

	// @SafeVarargs
	final void exampleFinal(int... array) {
		System.out.println("Inside final method varArgs" + list);
	}

	@SafeVarargs
	static void exampleFinal2(int... array) {
		System.out.println("Inside static method var args");
	}

	@SafeVarargs
	final static void exampleFinal3(int... array) {
		System.out.println("Inside final static varargs");
	}

	@SafeVarargs
	private void exampleFinal4(int... array) {
		System.out.println("Inside private method" + list);
	}

	public static void main(String... args) {

		Java9_Features j = new Java9_Features();
		j.exampleFinal(new int[] { 12, 3, 4 });
		Java9_Features.exampleFinal2(new int[] { 9, 0, 8 });

		Optional<String> o = Optional.empty();
		o.ifPresentOrElse(name -> System.out.println("Yes" + name), () -> System.out.println("no"));
		// o.ifPresent(null);

		Optional<String> s = o.or(() -> Optional.of("this is right"));
		System.out.println(s.get());

		Optional<String> opt = Optional.of("hello world");
		opt.stream().forEach(System.out::println);

		List<Integer> list = new ArrayList<>();
		list.add(87);
		list.add(90);
		list.add(100);
		System.out.println(list);
		List<Integer> l = Collections.unmodifiableList(list);
		System.out.println(list);
		// l.add(900);//UnsupportedException
		// System.out.println(list);

		List<Integer> list1 = List.of(100, 540, 200, 433);
		System.out.println(list1);
		// list1.add(8000);---UnsupportedOperation
		System.out.println(list1);

		System.out.println("----------------");

		IntStream.of(11, 24, 35, 57, 89).takeWhile((value1) -> value1 < 30).forEach(System.out::println);
		System.out.println("----------------");
		IntStream.of(10, 94, 25, 37, 69).dropWhile((value1) -> value1 < 20).forEach(System.out::println);

		System.out.println("ofNullable static method in Stream interface");
		System.out.println(Stream.ofNullable(null).count());
		System.out.println(Stream.ofNullable(89).count());
		System.out.println("Static method in stream interface of iterate()");
		Stream.iterate(2, num -> num <= 10000, i -> i * 5).forEach(System.out::println);
		Stream.iterate(3, value -> value < 100, num -> num * 3).forEach(System.out::println);

		/*
		 * try with resources
		 * 
		 * before java 7 --- try catch finally{ try resources close and catch} after
		 * java 7 -- try(locally resources) catch after java 9--- try(references
		 * variable of resources) catch
		 * 
		 * 
		 * diamond operator is empty-- before java 7 --must mention the type on both
		 * side generics -- collection and anonymous inner class after java 7 only
		 * collection mention the generic type on left side not right side -- anonymous
		 * inner class mention the type on both sides
		 * 
		 * 
		 * var args-- 5 version came we can pass any number of argument inside var args
		 * 
		 * @safeVarargs -- introuduced in java 7 method constructor--- method final,
		 * static,final static,private
		 */
		// Set.of()

		// Map.of()

		// Map.ofEntries()

		/*
		 * Unmodifiable collections just read only views of the original collection
		 * 
		 * immutable collections 100% immutable
		 * 
		 * 
		 * characteristics of Immutable collections: null elements not allowed trying to
		 * modify we got UnsupportedOperationException thread safe returned by java 9
		 * static factory method space efficient less memory
		 * 
		 */

		/*
		 * java 9 -- stream interface introduce 4 methods takeWhile() dropWhile() both
		 * take one argument of type predicate both are default methods
		 * 
		 * ofNullable(T t) iterate(T t,Predicate<>); static method
		 * 
		 */

	}

}
