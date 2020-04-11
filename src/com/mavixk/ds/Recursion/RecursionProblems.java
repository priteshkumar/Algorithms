package com.mavixk.ds.Recursion;

import java.util.*;

public class RecursionProblems {

  public static void main(String[] args) {
    //printAllSubsets();
        /*
        checkPalindromic(121);
        checkPalindromic(3223);
        checkPalindromic(2121);
        checkPalindromic(323);
        checkPalindromic(3213);
        checkPalindromic(12);
        checkPalindromic(3);
        checkPalindromeV2(121);
         */
    //checkPalindromeV2(3223);
    //checkPalindromeV2(3213);
    checkPalindromeV2(32523);
    //checkPalindromeV2(1231);
    printAllSubsets();
  }

  public static boolean isPal(String s, int index) {
      if (index >= s.length() / 2) {
          return true;
      }
      if (s.charAt(index) != s.charAt(s.length() - 1 - index)) {
          return false;
      } else {
          return isPal(s, ++index);
      }
  }

  public static void checkPalindromic(int n) {
    System.out.println(n + " is palindromic " + isPal(String.valueOf(n), 0));
  }

  public static int isNumberPalin(int num, int dup) {
      if (num == 0) {
          return dup;
      } else {
          dup = isNumberPalin(num / 10, dup);
      }

    if (dup == -1) {
      return -1;
    }
    //       System.out.println(num + " " + dup);
    if (num % 10 == dup % 10) {
      return dup / 10;
    } else {
      return -1;
    }
  }

  public static void checkPalindromeV2(int n) {
    System.out.println(isNumberPalin(n, n));
  }

  public static void printAllSubsets() {
    //int[] nums = {1,3,2,4};
    int[] nums = {1, 2, 3};
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<Integer>();
    printSubsets(nums, list, nums.length - 1);
  }

  //consider case when there is duplicate elements
  public static void printSubsets(int[] nums, List<Integer> out, int index) {
    if (index < 0) {
      System.out.println(out);
      return;
    }
    //add last elmenent
    out.add(nums[index]);
    //then recur
    printSubsets(nums, out, index - 1);
    //remove last element
    out.remove(out.size() - 1);
    //recur again

    System.out.println("recurse " + out + "  " + index);
    printSubsets(nums, out, index - 1);
  }

}
