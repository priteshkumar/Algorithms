package com.mavixk.ds.Sorting;
import java.util.*;

public class Partition0s1s2s {
  public static void main(String[] args){
    int[] a = {0,1,1,0,2,1,0,2};
    dutchNationalFlag(a,a.length);
    printArray(a);
  }

  public static void printArray(int[] a){
    for(int i:a){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void dutchNationalFlag(int[] a,int n){
    int i = 0;
    int pos0 = 0;
    int pos2 = n-1;
    while(i < n){
      if(a[i] == 0){
        a[i] = a[pos0];
        a[pos0] = 0;
        pos0++;
      }
      else if(a[i] == 2 && i < pos2){
        a[i] = a[pos2];
        a[pos2] = 2;
        pos2--;
        i--;
      }
      i++;
    }
  }
}
