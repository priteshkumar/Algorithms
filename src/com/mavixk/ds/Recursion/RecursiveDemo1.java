package com.mavixk.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveDemo1 {

  public static int count = 0;
  public static ArrayList<Integer> res;

  public static void main(String[] args) {
    res = new ArrayList<Integer>();
    System.out.println(isPalindrome(("abba")));
    //System.out.println(isPalindrome("malam"));
    System.out.println(isPalindrome("latam"));
    System.out.println(getLen("devops"));
    printReversedString("helloworld");
    System.out.println();
    printReversedString("this is a book");
    System.out.println();
    System.out.println(getSumofDigits(324));
    System.out.println(getSumofDigits(93324));
    System.out.println(isSubsequence("hac", "cathartic"));
    System.out.println(isSubsequence("bat", "table"));
    System.out.println(isSubsequence("bat", "tabcbtad"));
    int[] a = {1, 2, 3, 4};
    //printSubsets(a);
    //genFibonacci(150);
    //testRecursion(13);
    //System.out.println(genFibonacciv2(100));
    //printPattern(3);
    //factorial1(5);
    //factorial2(5);
    //fun(4);
    fun2(4);
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    System.out.println();
    fun3(list, 0, 0, count);
    System.out.println(res.size());
  }

  public static int fun3(ArrayList<ArrayList<Integer>> list, int r, int c, int count) {
    System.out.println("hello " + r + " " + c + " " + ++count);
    res.add(count);
      if (r >= 6 || c >= 3) {
          return 100000000;
      }
      if (r == 6 - 1 && c == 3 - 1) {
          return 0;
      }
    return list.get(r).get(c) + Math.min(fun3(list, r + 1, c, count), fun3(list, r, c + 1, count));
  }

  public static void fun(int x) {
    if (x > 0) {
      fun(--x);
      System.out.print(x + " ");
      fun(x--);
    }
  }

  public static void fun2(int x) {
    if (x > 0) {
      fun(x - 1);
      System.out.print(x - 1 + " ");
      fun(x - 1);
    }
  }

  public static void factorial2(int n) {
    int[] factorials = new int[n + 1];
    Arrays.fill(factorials, 1);
    for (int i = 0; i <= n - 1; i++) {
      factorials[i + 1] = (i + 1) * factorials[i];
    }
    System.out.println(factorials[n]);
  }

  public static boolean isPalindrome(String s) {
      if (s.length() == 0 || s.length() == 1) {
          return true;
      }
      if (s.charAt(s.length() - 1) != s.charAt(0)) {
          return false;
      } else {
          return isPalindrome(s.substring(1, s.length() - 1));
      }
  }

  /**
   * recursive function to get length of string param
   *
   * @param s String parameter whose length needs to be calculated
   * @return length of String params
   */
  public static int getLen(String s) {
      if (s.length() == 0) {
          return 0;
      } else {
          return 1 + getLen(s.substring(1));
      }
  }

  public static void printReversedString(String s) {
      if (s.length() == 0) {
          return;
      }
    printReversedString(s.substring(1));
    System.out.print(s.charAt(0) + "");
  }

  public static int getSumofDigits(int n) {
      if (n == 0) {
          return 0;
      }
    return ((n % 10) + getSumofDigits(n / 10));
  }

  public static boolean isSubsequence(String a, String b) {
    // System.out.println(a + " " + b);
      if (a.length() == 0) {
          return true;
      }
      if (a.length() > 0 && b.length() == 0) {
          return false;
      }
    int index = b.indexOf(a.charAt(0));
    //System.out.println(index + " ");
    return (index >= 0 && isSubsequence(a.substring(1), b.substring(index + 1)));

  }

  public static void printSubsets(int[] a) {
    int n = a.length;
    for (int i = 0; i < (1 << n); i++) {
      System.out.print("{ ");
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) > 0) {
          System.out.print(a[j] + " ");
        }
      }
      System.out.println("}");
    }
  }

  //{1,2,3}
  public static void printSubsetRecursive(int[] a) {

  }

  public static void genFibonacci(int n) {
    long[] seq = new long[n + 1];
    seq[0] = 0;
    seq[1] = 1;
    for (int i = 2; i <= n; i++) {
      seq[i] = (seq[i - 1] + seq[i - 2]);
    }
    System.out.println(seq[n]);
  }

  public static int genFibonacciv2(int n) {
      if (n == 0 || n == 1) {
          return n;
      } else {
          return (genFibonacciv2(n - 1) + genFibonacciv2(n - 2));
      }
  }


  public static int genFibonacciV3(int n) {
    int a = 0, b = 1;
    int c = n;
    for (int i = 2; i <= n; i++) {
      c = (a + b) % 10;
      a = b;
      b = c;
    }
    return c;
  }

  public static void testRecursion(int n) {

    int a = 0;
      if (n == 1) {
          return;
      }
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n; j++) {
              a++;
          }
      }
    testRecursion(n - 3);

  }

  public static void factorial1(int n) {
    int factorial = 1;
    int index = 1;
    for (int i = 0; i <= Math.pow(n, n); i++) {
      //System.out.println("hello");
      if (i == factorial * index) {
        factorial = i;
        index += 1;
        //System.out.println(index);
        if (index == n + 1) {
          System.out.println(factorial);
          break;
        }
      }
    }
  }

  public static String printPattern(int n) {
    String pattern = "";
    if (n == 1) {
      pattern = "*";
      System.out.println(pattern);
    } else {
      pattern = "*" + printPattern(n - 1);
      System.out.println(pattern);
    }
    return pattern;
  }
}
