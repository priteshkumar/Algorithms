package com.mavixk.ds.Hashing;

import java.util.*;

public class Sum3Demo {

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(a));
  }

  /**
   * Finds unique triplets with sum 0
   * @param a
   * @return
   */
  public static List<List<Integer>> threeSum(int[] a) {
    HashSet<List<Integer>> m = new HashSet<List<Integer>>();
    HashSet<Integer> p = new HashSet<Integer>();
    for (int i = 0; i < a.length - 2; i++) {
      int sum = 0 - a[i];
      p.clear();
      for (int j = i + 1; j < a.length; j++) {
        if (p.contains(sum - a[j])) {
          List<Integer> res = new ArrayList<Integer>();
          res.add(a[i]);
          res.add(sum - a[j]);
          res.add(a[j]);
          Collections.sort(res);
          m.add(res);
        } else {
          p.add(a[j]);

        }

      }
    }
    //System.out.println(m);
    List<List<Integer>> v = new ArrayList<List<Integer>>(m);
    return v;
  }
}
