package com.mavixk.ds.Sorting;
import java.util.*;

public class CountingSortDemo {
  public static void main(String[] args){
    char[] a = {'a','b','m','e','e','d','s'};
    ArrayList<Integer> alist = new ArrayList<Integer>(3);
    alist.add(2);
    alist.add(3);
    alist.set(0,4);
    
    countSort(a);
    //System.out.println(a[2] - a[0]);
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

  /**
   * Counting sort for char array
   * @param seq
   */
  public static void countSort(char seq[])
  {
    // add your code here
    int[] counts = new int[26];
    for(int i=0;i < seq.length;i++)
      counts[seq[i] - 97] += 1;

    int j = 0;
    for(int i=0; i <= 25;i++){
      int k = counts[i];
      while(k > 0){
        seq[j] = (char)(97 + i);
        k--;
        j++;
      }
    }

    for(int i=0;i < seq.length;i++)
      System.out.print(seq[i]+ " ");
    System.out.println();
  }
}
