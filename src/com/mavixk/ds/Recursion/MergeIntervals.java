package com.mavixk.ds;
import java.util.*;

public class MergeIntervals {

  private static class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      if(a[0] == b[0])
        return Integer.compare(a[1],b[1]);
      else
        return Integer.compare(a[0],b[0]);
    }
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] res = mergeIntervals(intervals);
    printIntervals(res);
    intervals = new int[][]{{2, 4}, {1, 3}, {15, 18}, {8, 10}};
    res = mergeIntervals(intervals);
    printIntervals(res);
  }

  public static void printIntervals(int[][] intervals){
    System.out.println("print intervals...");
    for(int[] interval:intervals){
      for(int i:interval)
        System.out.print(i + " ");
      System.out.println();
    }
  }

  public static int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, new IntervalComparator());
    ArrayList<int[]> alist = new ArrayList<int[]>();
    int i = 0;
    int n = intervals.length;
    while (i < n) {
      if (i == 0)
        alist.add(intervals[i]);
      else {
        int[] a = alist.get(alist.size() - 1);
        if (intervals[i][0] > a[1]) {
          alist.add(intervals[i]);
        } else if (intervals[i][0] <= a[1]) {
          int s = a[0] <= intervals[i][0] ? a[0] : intervals[i][0];
          int e = a[1] >= intervals[i][1] ? a[1] : intervals[i][1];
          a[0] = s;
          a[1] = e;
        }
      }
      i++;
    }
    int[][] res = new int[alist.size()][2];
    res = alist.toArray(res);
    return res;
  }
}