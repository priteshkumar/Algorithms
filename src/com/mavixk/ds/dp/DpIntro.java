package com.mavixk.ds.dp;

import java.util.*;
import java.lang.Math.*;

public class DpIntro {

  public static void main(String[] args) {
    int[] a = {1, 7, 10};
    int[] coins = {1, 2, 5, 8, 10, 14};
    System.out.println(countMinCoins(a, 29, 0, ""));
    System.out.println(minCoins(a, 15));
    System.out.println(minCoins(coins, 1132));
    System.out.println(getMinCoins(coins, 1291));
    System.out.println(minCoins(coins, 1132));
    System.out.println(getStairSteps(4));
    System.out.println(getStairSteps(5));
    int test[] = {16, 0, 0, 0, 12, 1, 13, 1, 30, 0, 14, 0, 0, 3, 0, 0, 2, 0, 0, 0, 7, 0, 0, 0, 0
        , 16, 0, 14, 0, 22, 0, 0, 0, 5, 0, 0, 0, 0, 7, 0, 26, 0, 0, 13, 22, 0, 0, 0, 0, 22, 0, 0, 0,
        16, 0, 0, 29, 0, 0, 0, 3, 0, 0, 0, 28, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 22, 0,
        0, 0, 0, 0, 3, 0, 0, 0, 19, 0, 0, 15, 0, 0, 30, 0, 0, 0, 0, 0, 0, 12, 0, 19, 6, 30, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 17, 12, 0, 24, 16, 21, 0, 8, 0, 14, 6, 0, 0, 5, 23, 0, 22, 0, 15, 15, 0,
        26, 0, 14, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 13, 0, 24, 0, 0, 16, 24, 0, 9, 0, 0,
        0, 0, 0, 21, 0, 0, 25, 0, 0, 0, 0, 0, 27, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 30, 10, 0,
        18, 30, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 29, 0, 0, 0, 8, 7, 29, 16, 30, 0, 0, 3, 0, 0, 0,
        17, 0, 0, 22, 0, 0, 0, 0, 0, 18, 0, 0, 11, 11, 0, 0, 0, 0, 11, 19, 2, 0, 0, 0, 2, 0, 16, 11,
        21, 0, 10, 0, 29, 0, 0, 0, 0, 0, 1, 15, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 29, 0, 9, 0, 6,
        0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 11,
        0, 0, 21, 0, 0, 0, 0, 4, 0, 0, 0, 0, 14, 21, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 21, 0, 0,
        0, 0, 0, 0, 0, 0, 21, 0, 0, 14, 0, 0, 0, 0, 29, 24, 0, 4, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0,
        0, 30, 0, 0, 0, 0, 0, 0, 0, 25, 0, 9, 0, 0, 0, 0, 24, 21, 12, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0,
        0, 29, 2, 0, 0, 0, 22, 9, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 8, 29, 19, 0, 0, 0, 14, 24, 0,
        22, 0, 24, 0, 0, 5, 0, 0, 0, 28, 0, 0, 29, 0, 0, 27, 13, 0, 18, 0, 0, 0, 0, 11, 11, 0, 0,
        28, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 12, 0, 0, 12, 19, 23, 0, 20, 0, 8, 6, 23, 17,
        14, 0, 0, 24, 3, 0, 0, 0, 6, 11, 24, 0, 0, 0, 0, 0, 0, 18, 0, 0, 1, 27, 0, 1, 0, 0, 0, 0, 0,
        19, 0, 0, 0, 0, 11, 16, 0, 0, 24, 25, 0, 0, 17, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0, 9, 19, 0, 0,
        0, 0, 0, 0, 6, 0, 0, 5, 0, 15, 17, 14, 1, 27, 0, 0, 24, 16, 28, 0, 18, 0, 20, 20, 0, 29, 0,
        2, 29, 0, 0, 17, 0, 30, 0, 0, 0, 0, 0, 29, 15, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 16, 0, 0, 0,
        0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 21, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 28, 11, 19,
        0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 15, 0, 0, 6, 3, 4, 0, 0, 0, 0, 22, 0, 2, 0, 0, 0, 14, 0,
        0, 5, 0, 18, 27, 0, 0, 0, 0, 0, 28, 0, 0, 0, 9, 0, 20, 4, 28, 0, 0, 4, 0, 0, 3, 0, 3, 9, 3,
        0, 6, 0, 0, 0, 0, 0, 0, 13, 0, 23, 0, 0, 16, 5, 0, 27, 4, 0, 28, 0, 0, 0, 0, 0, 0, 0, 5, 0,
        24, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 4, 10, 28, 0, 0, 0, 22, 14, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 19, 0, 21, 0, 30, 0, 0, 19, 0, 0, 0, 0, 7, 0, 22, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0,
        13, 29, 18, 0, 0, 0, 0, 0, 0, 0, 0, 29, 30, 0, 0, 0, 28, 0, 0, 18, 26, 0, 0, 22, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 27, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 29, 16, 13, 0,
        3, 0, 0, 11, 12, 7, 3, 0, 2, 0, 0, 16, 0, 0, 26, 0, 15, 0, 20, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0,
        25, 3, 27, 0, 0, 0, 13, 0, 0, 0, 0, 22, 25, 0, 22, 25, 0, 17, 29, 1, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 9, 28, 8, 1, 0, 0, 0, 0, 0, 29, 15, 16, 0, 0, 0, 0, 0, 0, 23, 28, 0, 0, 0, 2, 0, 12,
        27, 0, 22, 0, 0};

  }

  /**
   * Uses recursion
   *
   * @param a
   * @param pay
   * @param sum
   * @param out
   * @return
   */
  public static int countMinCoins(int[] a, int pay, int sum, String out) {
    if (sum == pay) {
      // System.out.println(out.length() + out);
      return out.length();
    }
    if (sum > pay) {
      return Integer.MAX_VALUE;
    }
    int step1 = countMinCoins(a, pay, sum + 1, out + "1");
    int step2 = countMinCoins(a, pay, sum + 7, out + "1");
    int step3 = countMinCoins(a, pay, sum + 10, out + "1");
    int min = step1 < step2 ? step1 : step2;
    min = min < step3 ? min : step3;
    return min;

  }

  /**
   * Uses dp memoisation
   *
   * @param a
   * @param pay
   * @return
   */
  public static int minCoins(int[] a, int pay) {
    int[][] sum = new int[pay + 1][a.length + 1];
    int cursum = 0; // 1 , 7 , 10
    for (int i = 0; i <= a.length; i++) {
      sum[0][i] = 0;
    }
    for (int i = 1; i <= pay; i++) {
      sum[i][1] = i;
    }
    for (int i = 1; i <= pay; i++) {
      for (int j = 2; j <= a.length; j++) {
        if (i < a[j - 1]) {
          sum[i][j] = sum[i][j - 1];
        } else {
          sum[i][j] = Math.min(sum[i][j - 1], sum[i - a[j - 1]][j] + 1);
        }
      }
    }
    return sum[pay][a.length];
  }

  /**
   * space optimised solution
   *
   * @param a
   * @param pay
   * @return
   */
  public static int getMinCoins(int[] a, int pay) {
    int[] result = new int[pay + 1];
    for (int i = 0; i <= pay; i++) {
      result[i] = i;
    }
    int n = a.length;
    for (int j = 1; j < n; j++) {
      for (int i = 1; i <= pay; i++) {
        if (a[j] <= i) {
          result[i] = Math.min(result[i], 1 + result[i - a[j]]);
        }
      }
    }
    return result[pay];
  }

  public static int getStairSteps(int steps) {
    if (steps <= 1) {
      return steps;
    }
    int n = steps;
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
      if (f[i - 2] == 0) {
        f[i] += 1;
      }
    }
    return f[n];
  }

  public static int checkJump(int[] a) {
    System.out.println();
    return 0;
  }
}
