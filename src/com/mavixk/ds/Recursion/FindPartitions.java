package com.mavixk.ds;
import java.util.*;

public class FindPartitions {
  public static void main(String[] args){
    int[] nums = {1,2,3,4,5,6};
    //findPartitions(nums,"",6,0,nums.length);
    int[] a = new int[6];
    recur(1,6,a,0);

  }

  public static void findPartitions(int nums[],String out,int sum,int i,int n){
    if(sum < 0 || i >= n)return;
    if(sum == 0){
      System.out.println(out);
      return;
    }

    for(int j=i; j < n;j++){
      findPartitions(nums, nums[j] + " " + out,sum - nums[j],j,n);

    }
  }

    public static void printCombination(int[] out, int n)
    {
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", out[i]);
      }
      System.out.println();
    }

    // Recursive function to print all combination of numbers from i to n
    // having sum n. index denotes the next free slot in output array out
    public static void recur(int i, int n, int[] out, int index)
    {
      // if sum becomes n, print the combination
      if (n == 0) {
        printCombination(out, index);
      }

      int j;

      // start from previous element in the combination till n
      for (j = i; j <= n; j++)
      {
        // place current element at current index
        out[index] = j;

        // recur with reduced sum
        recur(j, n - j, out, index + 1);
      }
    }
}
