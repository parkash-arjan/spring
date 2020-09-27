package com.algo.sliding.window;

public class MaxSubArraySizeOfK {
	/*
	 * Problem Statement Given an array of positive numbers and a positive number
	 * ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
	 * 
	 * Example 1:
	 * 
	 * Input: [2, 1, 5, 1, 3, 2], k=3 Output: 9 Explanation: Subarray with maximum
	 * sum is [5, 1, 3].
	 * 
	 * 
	 * Input: [2, 3, 4, 1, 5], k=2 Output: 7 Explanation: Subarray with maximum sum
	 * is [3, 4].
	 * 
	 */

	public static int findMaxSumSubArray(int k, int[] nums) {

		if (nums == null || nums.length == 0 || k < 0) {
			throw new IllegalArgumentException("Please check input values , they do not look good.");
		}

		int start = 0;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			// 0 1 2 3 4 5 6 7 8 9
			// 2, 1, 5, 1, 3, 2

			if (i >= (k - 1)) {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = sum - nums[start++];
			}

		}

		return maxSum;
	}

}
