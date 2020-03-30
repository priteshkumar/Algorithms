package com.mavixk.ds.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SiteStats {

  private String url;
  private int numVisits;

  /**
   * Constructor for the SiteStats class
   *
   * @param url       String that represents an URL that the user has visited
   * @param numVisits An int that represents the number of times that the user has visited the url
   */
  public SiteStats(String url, int numVisits) {
    this.url = url;
    this.numVisits = numVisits;
  }

  /**
   * This method returns the number of times that the user has visited the url.
   *
   * @return An int that represents the number of times that the user has visited the url
   */
  public int getNumVisits() {
    return this.numVisits;
  }

  /**
   * This method returns the url that we are currently tracking
   *
   * @return A String that represents the url that we are currently tracking
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * This method updates the number of times that we have visited the url
   *
   * @param updatedNumVisits An int that represents the number that we want to set numVisits to
   */
  public void setNumVisits(int updatedNumVisits) {
    this.numVisits = updatedNumVisits;
  }

  public String toString() {
    return this.url + " | " + this.numVisits;
  }

}


public class PartB {

  private static Queue<SiteStats> sites = new LinkedList<SiteStats>();

  /**
   * Lists top n visited websites
   * <p>
   * In each of n iterations finds website with highest visits
   * <p>
   * Places top n websites with highest visits first in queue
   *
   * @param sites
   * @param n
   */
  public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
    if (sites.isEmpty() == true) {
      System.out.println(new ArrayList<String>());
      return;
    }
    for (int i = 0; i < n; i++) {
      //find website with (i+1)th highest visits
      //e.g. first highest visit, 2nd highest visit,...nth highest visits
      SiteStats maxVisitedSite = sites.peek();
      for (int j = 0; j < sites.size() - i; j++) {
        SiteStats siteStats = sites.remove();
        if (maxVisitedSite.getNumVisits() <= siteStats.getNumVisits()) {
          maxVisitedSite = siteStats;
        }
        sites.add(siteStats);
      }
      //Moves top i sites to back
      //As finding max visit sites will bring top site to front
      //This is needed for proper placement of top sites
      int topMoves = i;
      while (topMoves-- > 0) {
        sites.add(sites.remove());
      }

      int sitesLen = sites.size();
      //add highest visited website to back
      for (int j = 0; j < sitesLen; j++) {
        SiteStats siteStats = sites.remove();
        if (siteStats != maxVisitedSite) {
          sites.add(siteStats);
        }
      }
      sites.add(maxVisitedSite);
    }
    int siteMoves = sites.size() - n;
    //Brings top sites to sites queue front
    while (siteMoves-- > 0) {
      sites.add(sites.remove());
    }
    while (n-- > 0) {
      System.out.println(sites.peek().toString());
      sites.add(sites.remove());
    }
  }

  /**
   * Updates sitestats for given url
   * <p>
   * Adds sitestats for url if not present already in sites queue
   * <p>
   * Arranges sites queue in oldest visited to most recently visited order
   *
   * @param url
   */
  public static void updateCount(String url) {
    if (sites.isEmpty() == true) {
      sites.add(new SiteStats(url, 1));
    } else {
      SiteStats siteStats = null;
      int numPeeks = sites.size();
      boolean urlVisited = false;
      while (numPeeks-- > 0) {
        String firstUrl = sites.peek().getUrl();
        if (firstUrl.equals(url) == true) {
          siteStats = sites.remove();
          urlVisited = true;
        } else {
          sites.add(sites.remove());
        }
      }
      if (urlVisited == true) {
        int numVisits = siteStats.getNumVisits();
        siteStats.setNumVisits(numVisits + 1);
        sites.add(siteStats);
      } else {
        sites.add(new SiteStats(url, 1));
      }
    }
  }

  public static void main(String[] args) {
    String[] visitedSites = {"www.google.co.in", "www.google.co.in", "www.facebook.com",
        "www.upgrad.com", "www.google.co.in", "www.youtube.com",
        "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in",
        "www.microsoft.com", "www.9gag.com", "www.netflix.com",
        "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com",
        "www.uber.com", "www.amazon.com",
        "www.microsoft.com", "www.upgrad.com"};

    for (String url : visitedSites) {
      updateCount(url);
    }
    listTopVisitedSites(sites, 5);
  }

}
