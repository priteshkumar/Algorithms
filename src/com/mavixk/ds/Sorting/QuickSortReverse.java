package com.mavixk.ds.Sorting;
import java.util.*;

public class QuickSortReverse {
  public static void main(String[] args){
    int[] a = {2,4,6,8,10,12,14,16,18,20};
    quickSort(a,0,a.length-1);
    printArray(a);
    int[] b = {10,30,2,4,44,1,9};
    quickSort(b,0,b.length-1);
    printArray(b);
  }

  public static void printArray(int[] a){
    System.out.println("printing sorted array in descending order");
    for(int i=0;i < a.length;i++){
      System.out.println(a[i]);
    }
  }

  public static void quickSort(int[] a,int start,int end){
    if(start < end){
      int p = partition(a,start,end);
      quickSort(a,start,p-1);
      quickSort(a,p+1,end);
    }
  }

  //{2,4,6,8,10,12,14,16,18,20}
  public static int partition(int[] a,int start,int end){
   // System.out.println(start + " " + end);
    int pivot = a[end];
    int p = start;
    for(int i=start; i < end;i++){
      if(a[i] > pivot){
        int temp = a[i];
        a[i] = a[p];
        a[p] = temp;
        p = p + 1;
      }
    }
    //System.out.println(p + " " + a[p]);
    int temp = a[p];
    a[p] = pivot;
    a[end] = temp;
    return p;
  }
}
