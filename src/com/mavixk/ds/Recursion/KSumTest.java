package com.mavixk.ds.Recursion;

import java.util.*;

public class KSumTest {

  public static void main(String[] args) {
    int[] nums = {2, 3, 5};
    int[] nums2 = {2,3,6,7};
    List<Integer> out = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<>();
    System.out.println(kSum(res,out, nums2, 7, 0, 0));
  }

  public static List<List<Integer>> kSum(List<List<Integer>> res,List<Integer> out, int[] a, int k,
      int cursum,
      int n) {
    if (cursum == k) {
      System.out.println(out);
      res.add((ArrayList<Integer>) out);
      return res;
    } else if (cursum > k) {
      return res;
    }
    for (int i = n; i < a.length; i++) {
      List<Integer> temp = new ArrayList<Integer>(out);
      temp.add(a[i]);
      res = kSum(res,temp, a, k, cursum + a[i], i);
    }
    return res;
  }

}
