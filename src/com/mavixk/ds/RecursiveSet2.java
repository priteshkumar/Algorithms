package com.mavixk.ds;
import java.util.*;

public class RecursiveSet2 {
  public static void main(String[] args){
    int[] nums = {1,2,3,4,6,9,10};
    printElements(nums);
    //replaceArrayElements(nums,nums.length,1,0);
    //printElements(nums);
    checkQuadruplet(nums,"",18,0,nums.length-1,0);
  }

  public static void printElements(int[] nums){
    for(Integer val:nums){
      System.out.print(val + " ");
    }
    System.out.println();
  }

  public static int replaceArrayElements(int[] nums,int n,int left,int i){
    if(i == n)return 1;

    int cur = nums[i];
    int right = replaceArrayElements(nums,n,left * nums[i],i+1);
    nums[i] = left * right;
    return cur * right;
  }

  public static boolean checkQuadruplet(int[] nums,String out,int k,int cursum,int index,int count){

    if(cursum == k && count == 4){
      System.out.println("quadruplet exists with sum: " + k + " " + out);
      return true;
    }
    if(index < 0 || (cursum >= k && count < 4))
      return false;

    cursum  = cursum + nums[index];
    boolean step1 = checkQuadruplet(nums,nums[index] + " "+ out, k,cursum,index -1,count +1);
    cursum = cursum - nums[index];
    boolean step2 = checkQuadruplet(nums,out,k,cursum,index -1,count);
    if(step1 == true || step2 == true)
      return true;
    else
      return false;
  }
}
