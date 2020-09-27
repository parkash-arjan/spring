package com.algo.sliding.window;

public class CharacterReplacement {

	/*
	 * Problem Statement # Given a string with lowercase letters only, if you are
	 * allowed to replace no more than ‘k’ letters with any letter, find the length
	 * of the longest substring having the same letters after replacement.
	 *
	 * Example 1:
	 *
	 * Input: String="aabccbb", k=2 Output: 5 Explanation: Replace the two 'c' with
	 * 'b' to have a longest repeating substring "bbbbb". Example 2:
	 *
	 * Input: String="abbcb", k=1 Output: 4 Explanation: Replace the 'c' with 'b' to
	 * have a longest repeating substring "bbbb". Example 3:
	 *
	 * Input: String="abccde", k=1 Output: 3 Explanation: Replace the 'b' or 'd'
	 * with 'c' to have the longest repeating substring "ccc".
	 */
	public static int findLength(String str, int k) {

		Character charAtJ = str.charAt(k);
		return -1;
	}

	public static void main(String[] args) {

		findLength("aabccbb", 2);
		findLength("abbcb", 1);
		findLength("abccde", 1);

	}
}
