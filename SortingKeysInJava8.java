package com.java8.finishing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SortingKeysInJava8 {
			// treemap
			// treemap(Collections.reverseOrder())
			// treemap(new Comparator()
			//	{
			//		public int compare(Object o1,Object o2)
			//		{
			//			return o1-o2;
			//		}
			//	}
		    //  how to sort hashmap by keys

	public static void main(String... args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 300);
		map.put("ram", 400);
		map.put("ram", 100);
		map.put("yaliniyal", 600);
		map.put("kanimozhi", 200);
		map.put("Daniel", 500);
		map.put("pratheep", 1000);

//Sort the map without java 8
		TreeMap<String, Integer> tree1 = new TreeMap<>(map);
		System.out.println(tree1);

		TreeMap<String, Integer> tree2 = new TreeMap<>(Collections.reverseOrder());
		tree2.putAll(map);
		System.out.println(tree2);

		Map<String, Integer> tree3 = new TreeMap<>(new Comparator<String>() {
			public int compare(String i1, String i2) {
				return map.get(i1) - map.get(i2);
			}

		});
		tree3.putAll(map);
		System.out.println(tree3);

//Sort the map by using java 8

		/*
		 * entryset() stream() sorted() Entry.comparingByKeys()
		 * collect(Collectors.toMap((String s,String s1)->
		 * map.getKey(s)+" "+map.getValue(s)
		 */

		Map<String, Integer> sorted = map.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		Map<String, Integer> sort = map.entrySet().stream().sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(new Function<Map.Entry<String, Integer>, String>() {
					@Override
					public String apply(Map.Entry<String, Integer> entries) {
						return entries.getKey();
					}
				}, new Function<Map.Entry<String, Integer>, Integer>() {
					@Override
					public Integer apply(Map.Entry<String, Integer> entries) {
						return entries.getValue();
					}
				}, new BinaryOperator<Integer>() {
					public Integer apply(Integer value1, Integer value2) {
						return value2;
					}
				}, new Supplier<LinkedHashMap<String, Integer>>() {
					public LinkedHashMap<String, Integer> get() {
						return new LinkedHashMap();
					}
				}));

		System.out.println(sort);

		Map<String, Integer> sort2 = map.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByKey()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

		System.out.println(sort2);

		Map<String, Integer> sort3 = map.entrySet().stream().sorted(Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));

		System.out.println(sort3);
		Comparator<Map.Entry<String, Integer>> caseIn = Comparator.comparing(entry -> entry.getKey().toLowerCase());
		Map<String, Integer> sort4 = map.entrySet().stream().sorted(caseIn)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));

		System.out.println(sort4);

		Comparator<Map.Entry<String, Integer>> e1 = Comparator.comparing(e -> e.getKey().toLowerCase());
		Map<String, Integer> sort5 =

				map.entrySet().stream().sorted(e1.reversed()).collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(value1, value2) -> value2, LinkedHashMap::new));

		System.out.println(sort5);

		Map<String, Integer> sort6 = map.entrySet().stream()
				.sorted(Entry.comparingByKey((o1, o2) -> o2.length() - o1.length())).collect(Collectors
						.toMap(Entry::getKey, Entry::getValue, (value1, value2) -> value2, LinkedHashMap::new));

		System.out.println(sort6);

	}

}
