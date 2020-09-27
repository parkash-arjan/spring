package com.algo.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
	/*
	 * Problem Statement # Given an array of characters where each character
	 * represents a fruit tree, you are given two baskets and your goal is to put
	 * maximum number of fruits in each basket. The only restriction is that each
	 * basket can have only one type of fruit.
	 *
	 * You can start with any tree, but once you have started you can’t skip a tree.
	 * You will pick one fruit from each tree until you cannot, i.e., you will stop
	 * when you have to pick from a third fruit type.
	 *
	 * Write a function to return the maximum number of fruits in both the baskets.
	 *
	 * Example 1:
	 *
	 * Input: Fruit=['A', 'B', 'C', 'A', 'C'] Output: 3 Explanation: We can put 2
	 * 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
	 * Example 2:
	 *
	 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] Output: 5 Explanation: We can put
	 * 3 'B' in one basket and two 'C' in the other basket. This can be done if we
	 * start with the second letter: ['B', 'C', 'B', 'B', 'C']
	 */

	// It looks like a variant of maximum length sub string/sub array with two
	// distinct characters.
	public static int findLength(char[] arr) {

		// ['A', 'B', 'C', 'A', 'C']
		Map<Character, Integer> fruitCountMap = new HashMap<>();
		int maxFruits = 0;
		int numOfBasket = 2;
		int i = 0;
		for (int j = 0; j < arr.length; j++) {

			Character currChar = arr[j];
			// fruitCountMap.merge(currChar, 1, (exisitingVal, passedVal) -> exisitingVal +
			// passedVal);
			fruitCountMap.put(currChar, fruitCountMap.getOrDefault(currChar, 0) + 1);
			while (fruitCountMap.size() > numOfBasket) {

				updateFruitCount(fruitCountMap, arr[i++]);
			}

			maxFruits = Math.max(maxFruits, (j - i) + 1);
		}

		return maxFruits;
	}

	private static void updateFruitCount(Map<Character, Integer> fruitCountMap, Character fruit) {

		Integer fruitCount = fruitCountMap.get(fruit);
		if (fruitCount > 1) {

			fruitCountMap.put(fruit, fruitCount - 1);
		}
		else {

			fruitCountMap.remove(fruit);
		}
	}

	public static void main(String[] args) {

		System.out.println(findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println(findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}

}
