package com.algo.sliding.window;

public class MinSizeSubArraySum {
	/*
	 * Problem Statement Given an array of positive numbers and a positive number
	 * ‘S’, find the length of the smallest contiguous subarray whose sum is greater
	 * than or equal to ‘S’. Return 0, if no such subarray exists.
	 * 
	 * Example 1:
	 * 
	 * Input: [2, 1, 5, 2, 3, 2], S=7 Output: 2 Explanation: The smallest subarray
	 * with a sum great than or equal to '7' is [5, 2]. Example 2:
	 * 
	 * Input: [2, 1, 5, 2, 8], S=7 Output: 1 Explanation: The smallest subarray with
	 * a sum greater than or equal to '7' is [8]. Example 3:
	 * 
	 * Input: [3, 4, 1, 1, 6], S=8 Output: 3 Explanation: Smallest subarrays with a
	 * sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
	 * 
	 */

	public int findMinSizeSubArray(int k, int[] nums) {

		if (k < 0 || nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Please check input values , they do not look good.");
		}
		int i = 0;
		int j = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		while (j < nums.length && i < nums.length) {
			sum = sum + nums[j];
			if (sum >= k) {
				len = Math.min(j - i + 1, len);
				sum = sum - nums[i++] - nums[j];
			} else {
				j++;
			}
		}

		return len;
	}

	public static int findMinSubArray(int S, int[] arr) {
		int windowSum = 0, minLength = Integer.MAX_VALUE;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum = windowSum + arr[windowEnd]; // add the next element
			// shrink the window as small as possible until the 'windowSum' is smaller than
			// 'S'
			while (windowSum >= S) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum = windowSum - arr[windowStart]; // subtract the element going out
				windowStart++; // slide the window ahead
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
