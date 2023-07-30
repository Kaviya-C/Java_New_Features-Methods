package com.java8.finishing;

import java.util.ArrayList;
import java.util.List;

public class Java10copyOfMethods {
	/*
	 * java 9 --> of()--immutable collections only differences between java 9 and
	 * java 10 are: java 9 List.of() take input as indivual element as argument java
	 * 10 List.copyOf() take collection as an argument it is same for list set map
	 * for the both java 9 and java 10. java 10 --->copyOf() -- immutable
	 * collections of exisiting collection
	 */
	public static void main(String... args) {
		List<String> list = new ArrayList<String>();

		list.add("Hockey");
		list.add("Cricket");
		list.add("Tennis");

		List<String> immutable = List.copyOf(list);

		System.out.println(list);
		System.out.println(immutable);

		list.add("Left Hand Ram");
		System.out.println(list);
		System.out.println(immutable);

	}

}
