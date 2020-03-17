package com.mavixk.ds.dp;
import java.util.*;

public class LISDemo {
  public static void main(String[] args){
    int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
    System.out.println(getLIS(A));
  }

  /**
   * Get longest increasing subsequence of given array
   * @param a
   * @return
   */
  public static int getLIS(int[] a){
    int lis[] = new int[a.length];
    lis[0] = 1;
    int max = 1;
    for(int i=1; i < a.length;i++){
      for(int j=0; j < i;j++){
        if(a[j] < a[i] && lis[j] > lis[i])
          lis[i] = lis[j];
      }
      lis[i]++;
      if(lis[i] > max)
        max = lis[i];
    }
    return max;
  }

  public static void printLIS(int[] a){
    
  }
}
