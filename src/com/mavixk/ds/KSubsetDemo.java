package com.mavixk.ds;

import java.util.*;

public class KSubsetDemo {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    //Arrays.sort(nums);
    String out = "";
    int k = 2;
    //printKSubsets(nums,out,k,nums.length);
    printKSubsetsFwd(nums, out, k, 0);
  }

  /**
   * Print all unique subsets of size k traversing right to left
   *
   * @param nums
   * @param out
   * @param k
   * @param index
   */
  public static void printKSubsets(int[] nums, String out, int k, int index) {
    if (k > index) {
      return;
    }
    if (k == 0) {
      System.out.println(out);
    }

    for (int i = index - 1; i >= 0; i--) {
      printKSubsets(nums, nums[i] + " " + out, k - 1, i);
      while (i > 0 && nums[i] == nums[i - 1]) {
        i--;
      }
    }
  }

  /**
   * Print all unique subsets of size k traversing left to right
   *
   * @param nums
   * @param out
   * @param k
   * @param index
   */
  public static void printKSubsetsFwd(int[] nums, String out, int k, int index) {
    if (k > nums.length) {
      return;
    }
    if (k == 0) {
      System.out.println(out);
    }

    for (int i = index; i < nums.length; i++) {
      printKSubsetsFwd(nums, out + " " + nums[i], k - 1, i + 1);
    }
  }
}
