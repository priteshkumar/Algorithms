package com.mavixk.ds;

import java.util.*;

public class KSubsetDemo {

  static ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();

  public static void main(String[] args) {
    String val = "hello";
    String pac = new String(val);
    if (pac != val) {
      System.out.println("not same string refs");
    }
    int[] nums = {1, 2, 3, 4, 5, 6};
    int[] nums2 = {1, 2, 2, 3, 4};
    int[] nums3 = {5, 12, 3, 17, 1, 18, 15, 3, 17};
    //Arrays.sort(nums);
    String out = "";
    int k = 2;
    //printKSubsets(nums,out,k,nums.length);
    //printKSubsetsFwd(nums, out, k, 0);
    int sum = 7;
    List<Integer> list = new LinkedList<Integer>();
    //printSubsetsKSum(nums2, list, sum, nums2.length - 1);
    printSubsetsKSumFwd(nums3, list, 6, 0);

    ListIterator<LinkedList<Integer>> iter = res.listIterator(res.size());
    while (iter.hasPrevious()) {
      System.out.println(iter.previous());
    }
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
    List<Integer> alist = new LinkedList<Integer>(out);
    alist.add(nums[index]);
    // System.out.println(alist);
    printSubsetsKSum(nums, alist, sum - nums[index], index - 1);
  }

    /**
     * Prints subsets having given sum
     * Order of elements in a subset is same as in the input array
     * Order of subsets can change
      * @param nums
     * @param out
     * @param sum
     * @param index
     */
  public static void printSubsetsKSumFwd(int[] nums, List<Integer> out, int sum, int index) {
    if (sum == 0) {
      res.add((LinkedList<Integer>) out);
      //System.out.println(out);

      return;
    }
    if (index >= nums.length || sum < 0) {
      return;
    }

    printSubsetsKSumFwd(nums, out, sum, index + 1);
    List<Integer> alist = new LinkedList<Integer>(out);
    alist.add(nums[index]);
    // System.out.println(alist);
    printSubsetsKSumFwd(nums, alist, sum - nums[index], index + 1);
  }

    /**
     * Prints subsets having sum k as string
     * @param nums
     * @param out
     * @param index
     * @param k
     */
  public static void printSubsetKSum(int[] nums, String out, int index, int k) {

    if (k == 0) {
      System.out.println(out);
      return;
    }
      if (index >= nums.length || k < 0) {
          return;
      }

    printSubsetKSum(nums, out, index + 1, k);
    String alist = new String(out);
      if (alist.equals("") == true) {
          alist = alist + nums[index];
      } else {
          alist = alist + " " + nums[index];
      }
    printSubsetKSum(nums, alist, index + 1, k - nums[index]);

  }
}
