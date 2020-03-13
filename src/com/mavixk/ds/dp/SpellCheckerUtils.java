package com.mavixk.ds.dp;

import java.util.*;
import java.util.Map.Entry;

public class SpellCheckerUtils {

  private static HashMap<String, Integer> wordMap;
  private static int editThreshold;

  static {
    wordMap = new HashMap<String, Integer>();
    editThreshold = 2;
  }

  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    buildWordMap();
    String word = "mo";
    if (isWordValid(word) == false) {
      String validWord = getValidWord(word);
    }
  }

  public static String getValidWord(String word) {
    ArrayList<String> corrections = new ArrayList<String>();
    for (String key : wordMap.keySet()) {
      if (EditDistance.editDistance(word, key) <= editThreshold && (
          Math.abs(word.length() - key.length()) <= 1)) {
        corrections.add(key);
      }
    }
    Collections.sort(corrections, new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return wordMap.get(o1) >= wordMap.get(o2)?-1:1;
          }
        });
    for(String key:corrections)
      System.out.println(key + " : " + wordMap.get(key));
    return corrections.get(0);
  }

  public static void buildWordMap() {
    String text = "Would you tell me, please, which way I ought to go from here?\n" +
        "That depends a good deal on where you want to get to.";

    String[] words = text.split("\\s+|,|[?.]");
    //HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
    for (String word : words) {
      if (word.equals("") == false) {
        int count = wordMap.getOrDefault(word, 0);
        wordMap.put(word, count + 1);
      }
    }
  }

  public static boolean isWordValid(String word) {
    return wordMap.containsKey(word);
  }
}
