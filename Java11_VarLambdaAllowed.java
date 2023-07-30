package com.java8.finishing;

import java.util.Arrays;
import java.util.List;

public class Java11_VarLambdaAllowed {
	public static void main(String... args) {
		List<Integer> number = Arrays.asList(2, 4, 6, 7);
		number.forEach((var num) -> System.out.println(num * num));
		/*
		 * var-- not used in java 10 for lambda expressions
		 * 
		 * from java -11 onward we can use var parameter in lambda expression follow the
		 * below steps even though only one parameter for lambda should enclosed with
		 * Parenthesis" () "===== //// a ==>>(var a) if there are two argument inside the
		 * lambda expression-- declaring one as var parameter another as non var
		 * parameter is not allowed (var a,int b) wrong//// (var a,var b) right
		 * 
		 * declaring one as var parameter and skipping of other is not allowed 
		 * (var a,b) wrong /// (var a,var b) right
		 * 
		 */
	}

}
