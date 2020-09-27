package com.algo.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	/**
	 * Problem Statement # Given a string, find the length of the longest substring
	 * which has no repeating characters.
	 *
	 * Example 1:
	 *
	 * Input: String="aabccbb" Output: 3 Explanation: The longest substring without
	 * any repeating characters is "abc". Example 2:
	 *
	 * Input: String="abbbb" Output: 2 Explanation: The longest substring without
	 * any repeating characters is "ab". Example 3:
	 *
	 * Input: String="abccde" Output: 3 Explanation: Longest substrings without any
	 * repeating characters are "abc" & "cde".
	 */

	public static int findLength(String str) {

		int i = 0;
		int maxLen = 0;
		Map<Character, Integer> characterCountMap = new HashMap<>();
		for (int j = 0; j < str.length(); j++) {

			char currChar = str.charAt(j);

			characterCountMap.merge(currChar, 1, (oldVal, argVal) -> oldVal + argVal);

			while (characterCountMap.get(currChar) > 1) {

				char oldChar = str.charAt(i++);
				Integer charCount = characterCountMap.get(oldChar);
				if (charCount > 1) {

					characterCountMap.merge(oldChar, -1, (oldVal, argVal) -> oldVal + argVal);
				}
				else {

					characterCountMap.remove(oldChar);
				}
			}

			maxLen = Math.max(maxLen, (j - i) + 1);
		}

		return maxLen;
	}

	public static int findLength2(String str) {

		int i = 0;
		int maxLen = 0;
		Map<Character, Integer> characterIndexMap = new HashMap<>();
		for (int j = 0; j < str.length(); j++) {

			Character currChar = str.charAt(j);
			if (characterIndexMap.containsKey(currChar)) {

				Integer index = characterIndexMap.get(currChar);

				if (i <= index) {

					i = index + 1;
				}

				// i = Math.max( index + 1 , i );
			}

			characterIndexMap.put(currChar, j);
			maxLen = Math.max(maxLen, (j - i) + 1);

		}
		return maxLen;
	}

	public static void main(String[] args) {

		System.out.println(findLength2("aa"));
		System.out.println(findLength2("aabccbb"));
		System.out.println(findLength2("abbbb"));
		System.out.println(findLength2("abccde"));

	}
}
