package com.mavixk.ds.Sorting;
import java.util.*;

public class TestSwap {
  static int k = 10;
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    //changeValues(nums,1,2);
  //  printArray(nums);
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String[] s = new String[n];

    for(int i=0; i < n;i++){
      s[i] = scan.nextLine();

    }

    for(int i=0;i < n;i++){
      System.out.println(s[i]);
    }
  }

  public static void printArray(int[] a){
    for(Integer val:a){
      System.out.println(val);
    }
  }
  public static void changeValues(int[] nums,int i,int j){
    nums[i] = nums[i] ^ nums[j];
    nums[j] = nums[i] ^ nums[j];
    nums[i] = nums[i] ^ nums[j];
  }
}