package com.epi.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

  /**
   * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
   * Find all unique triplets in the array which gives the sum of zero.
   * The solution set must not contain duplicate triplets.
   * For example, given array S = [-1, 0, 1, 2, -1, -4],
   * A solution set is:
   * [[-1, 0, 1], [-1, -1, 2]]
   *
   * @param nums
   * @return
   */

  public List<List<Integer>> threeSum(int[] nums) {

    if(nums == null) {
      return new ArrayList<>();
    }

    int sum = 0;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int count = 0;
    for(int i = 0; i< nums.length; i++) {
      count++;
      sum += nums[i];

      if(sum == 0 && count == 3) {
        count = 0;

      }

    }




    return null;
  }

  public static void main(String[] args) {
    System.out.println("hello");
  }
}
