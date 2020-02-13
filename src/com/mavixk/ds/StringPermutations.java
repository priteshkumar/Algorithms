package com.mavixk.ds;

import java.util.*;

public class StringPermutations {

  public static void main(String[] args) {
    String s = "abc";
    permuteString("",s);
  }

  /**
   * Prints all permutations of string (n!)
   * @param prefix
   * @param remaining
   */
  public static void permuteString(String prefix, String remaining) {
    System.out.println(prefix + "-->" + remaining);
    int n = remaining.length();
    if (n == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = 0; i < n; i++) {
      permuteString(prefix + remaining.charAt(i),
          remaining.substring(0, i) + remaining.substring(i + 1));
    }
  }
}
