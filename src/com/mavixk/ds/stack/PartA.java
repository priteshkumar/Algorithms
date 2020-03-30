package com.mavixk.ds.stack;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class PartA {

  private static Stack<String> history = new Stack<String>();

  /**
   * Checks if web browsing history is empty
   *
   * @return boolean
   */
  public static Boolean isBrowsingHistoryEmpty() {
    return history.empty();
  }

  /**
   * Returns most recently visited website
   *
   * @return String url of most recent visited website
   */
  public static String mostRecentlyVisitedSite() {
    if (isBrowsingHistoryEmpty() == false) {
      return history.peek();
    } else {
      throw new EmptyStackException();
    }
  }

  /**
   * add website url to browsing history
   *
   * @param url
   */
  public static void addSiteToHistory(String url) {
    history.push(url);
  }

  /**
   * Removes n urls from browsing history
   *
   * @param n
   */
  public static void goBackInTime(int n) {
    if (isBrowsingHistoryEmpty() == false && n <= history.size()) {
      while (n-- > 0) {
        history.pop();
      }
    }
  }

  /**
   * Prints browsing history
   */
  public static void printBrowsingHistory() {
    if (isBrowsingHistoryEmpty() == false) {
      System.out.println(history);
    } else {
      System.out.println("Browsing history is empty");
    }
  }

  public static void main(String[] args) {
    System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
    addSiteToHistory("www.google.co.in"); // Navigating to Google
    addSiteToHistory("www.facebook.com"); // Navigating to Facebook
    addSiteToHistory("www.upgrad.com"); // Navigating to UpGrad
    System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
    System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad)
    addSiteToHistory("www.youtube.com"); // Navigating to Youtube
    goBackInTime(2); // Going back by 2 sites
    addSiteToHistory("www.yahoo.com"); // Navigating to UpGrad platform site
    System.out.println(
        mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad Learn Platform)
    printBrowsingHistory(); // Printing browsing history

  }

}
