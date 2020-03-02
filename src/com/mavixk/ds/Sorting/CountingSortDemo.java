package com.mavixk.ds.Sorting;
import java.util.*;

public class CountingSortDemo {
  public static void main(String[] args){
    int[] nums = {4, 8, 4, 2, 9, 9, 6,5,5, 2, 9};
    int[] res = countingSort(nums,10);
    for(int i:res){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  /**
   * Linear time sorting algorithm
   * calculates count array for elements from 0 to n
   * <p>
   * Further based on element count , evaluates element starting indexes
   * <p>
   * Places elements in result array based on start indexes
   * @param a
   * @param n
   * @return
   */
  public static int[] countingSort(int[] a,int n){
    int[] counts = new int[n+1];
    for(int i=0;i < a.length;i++)
      counts[a[i]] += 1;
    int beforeVals = 0;
    int k = 0;
    for(int i=0;i < counts.length;i++){
      k = counts[i];
      counts[i] = beforeVals;
      beforeVals += k;
    }
    int[] sortedList = new int[a.length];
    for(int i=0;i < a.length;i++){
      sortedList[counts[a[i]]] = a[i];
      counts[a[i]] += 1;
    }
    return sortedList;
  }
}
