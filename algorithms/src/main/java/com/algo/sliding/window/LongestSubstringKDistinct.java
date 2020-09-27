package com.algo.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
	/*
	 * Problem Statement # Given a string, find the length of the longest substring
	 * in it with no more than K distinct characters.
	 *
	 * Example 1:
	 *
	 * Input: String="araaci", K=2 Output: 4 Explanation: The longest substring with
	 * no more than '2' distinct characters is "araa". Example 2:
	 *
	 * Input: String="araaci", K=1 Output: 2 Explanation: The longest substring with
	 * no more than '1' distinct characters is "aa". Example 3:
	 *
	 * Input: String="cbbebi", K=3 Output: 5 Explanation: The longest substrings
	 * with no more than '3' distinct characters are "cbbeb" & "bbebi".
	 *
	 */

	public int getLongestSubString(String str, int k) {

		Map<Character, Integer> characterFrequencyMap = new HashMap<>();
		int len = Integer.MIN_VALUE;

		int i = 0;
		int j = 0;
		// 0 1 2 3 4 5
		// c b b e b i

		while (j < str.length()) {

			if (!addIfDistinct(str.charAt(j), characterFrequencyMap, k)) {

				len = Math.max(len, j - i);
				while (characterFrequencyMap.size() >= k) {

					updateCharacterCount(Character.valueOf(str.charAt(i++)), characterFrequencyMap);
				}
			}
			else {

				j++;
			}
		}

		return len;
	}

	private void updateCharacterCount(Character character, Map<Character, Integer> characterMap) {

		if ((character == null) || (characterMap == null)) {

			throw new IllegalArgumentException("Inputs to the method do not appear to be valid. Only non null values should be passed as an argument.");
		}

		Integer count = characterMap.get(character);
		if (count != null) {

			if (count > 1) {

				characterMap.put(character, count - 1);
			}
			else {

				characterMap.remove(character);
			}
		}

	}

	private boolean addIfDistinct(Character character, Map<Character, Integer> characterMap, int k) {

		if ((character == null) || (characterMap == null)) {

			throw new IllegalArgumentException("Inputs to the method do not appear to be valid. Only non null values should be passed as an argument.");
		}

		if (characterMap.containsKey(character)) {

			characterMap.put(character, characterMap.get(character) + 1);
			return true;
		}
		else if (characterMap.size() < k) {

			characterMap.put(character, 1);
			return true;
		}

		return false;
	}

	// second implementation
	public int getLongestSubString2(String str, int k) {

		int maxLen = 0;
		Map<Character, Integer> characterCountMap = new HashMap<>();

		int i = 0;
		for (int j = 0; j < str.length(); j++) {

			char currChar = str.charAt(j);
			characterCountMap.put(currChar, characterCountMap.getOrDefault(currChar, 0) + 1);
			while (characterCountMap.size() > k) {

				decrementCharacterCount(str.charAt(i++), characterCountMap);
			}
			maxLen = Math.max(maxLen, (j - i) + 1);

		}

		return maxLen;
	}

	private void decrementCharacterCount(Character character, Map<Character, Integer> characterMap) {

		characterMap.put(character, characterMap.get(character) - 1);

		if (characterMap.get(character) == 0) {

			characterMap.remove(character);

		}

	}
}
