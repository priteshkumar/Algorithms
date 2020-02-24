package com.mavixk.ds.Sorting;
import java.util.*;

public class QuickSortDemo {
  public static void main(String[] args){
    int[] nums = {1,3,7,4,9,2,5}; //{1,2,3,4,5,7,9}

    quickSort(nums,0,nums.length-1);
    printArray(nums);
    int[] nums2 = {34,39,40,41,23,22,22,34};
    quickSort(nums2,0,nums2.length-1);
    printArray(nums2);

  }

  public static void printArray(int[] a){
    for(Integer val:a){
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static void quickSort(int[] a,int start,int end){
    if(start < end){
      int p = doPartition(a,start,end);
      quickSort(a,start,p-1);
      quickSort(a,p+1,end);
    }
  }

  private static void swap(int[] a,int i,int j){
    if(i == j)return;
    a[i] = a[i] ^ a[j];
    a[j] = a[i] ^ a[j];
    a[i] = a[i] ^ a[j];
  }


  public static int doPartition(int[] a,int start,int end){
    int pivot = end;
    int p = start;
    for(int i=start;i <= end-1;i++){
      if(a[i] <= a[pivot]){
        swap(a,i,p);
        p = p + 1;
      }
    }
    //swap p with end element
    swap(a,p,end);
    return p;
  }

}
