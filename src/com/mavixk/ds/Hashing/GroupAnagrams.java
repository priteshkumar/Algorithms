package com.mavixk.ds.Hashing;

import java.util.*;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(a));
  }

  public static String sortChars(String a) {
    char[] b = a.toCharArray();
    Arrays.sort(b);
    return new String(b);
  }

  public static List<List<String>> groupAnagrams(String[] a) {
    HashMap<String, List<String>> res = new HashMap<String, List<String>>();
    for (String s : a) {
      String key = sortChars(s);
      List<String> m = res.get(key);
      if (m == null) {
        m = new ArrayList<String>();
        m.add(s);
        res.put(key, m);
      } else {
        m.add(s);
        res.put(key, m);
      }
    }
    List<List<String>> out = new ArrayList<List<String>>();
    for (String key : res.keySet()) {
      List<String> c = res.get(key);
      out.add(c);
    }
    return out;
  }
}
