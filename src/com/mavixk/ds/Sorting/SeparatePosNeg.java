package com.mavixk.ds.Sorting;
import java.util.*;

public class SeparatePosNeg {
  public static void main(String[] args){
    int[] nums = {2,6,9,-1,-4,10,-7,3,5,-8};
    partitionNums(nums,nums.length);
    for(int i:nums){
      System.out.print(i + " ");
    }
  }

  public static void partitionNums(int[] a,int n){
    int left = 0;
    int right = n - 1;
    int k = 1 << 31;
    int posfirst = a[0] & k;

    while(left < right){
      while(((a[left] & k) == 0) && (left < right))
        left++;

      while(((a[right] & k) != 0) && (left < right))
        right--;
      if(left < right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }

    }
  }
}
