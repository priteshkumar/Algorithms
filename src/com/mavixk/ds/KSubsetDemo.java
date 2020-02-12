package com.mavixk.ds;
import java.util.*;

public class KSubsetDemo {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    int[] nums2 = {1,2,2,3,4};
    //Arrays.sort(nums);
    String out = "";
    int k = 2;
    //printKSubsets(nums,out,k,nums.length);
    //printKSubsetsFwd(nums, out, k, 0);
    int sum = 7;
    List<Integer> list = new ArrayList<Integer>();
    printSubsetsKSum(nums2, list, sum, nums2.length - 1);
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

  //{1,2,3,4} , sum = 4 => {1,3} , {4}
  public static void printSubsetsKSum(int[] nums, List<Integer> out, int sum, int index) {
    if (sum == 0) {
      System.out.println(out);
      return;
    }
    if (index < 0 || sum < 0) {
          return;
    }

    printSubsetsKSum(nums, out, sum, index - 1);
    List<Integer> alist = new ArrayList<Integer>(out);
    alist.add(nums[index]);
    printSubsetsKSum(nums, alist, sum - nums[index], index - 1);
  }
}
