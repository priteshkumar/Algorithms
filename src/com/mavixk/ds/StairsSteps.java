package com.mavixk.ds;
import java.util.*;

public class StairsSteps {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    //int n = scan.nextInt();
    //System.out.println(numPartitions("",0,n,0));
    //System.out.println("total ways: " + numSteps(0,n,0));
    int nums[] = {1,2,3,4,7};
    int nums1[] = {2,7,4,0,9,5,1,3};
   // findTriplet(nums,"",0,7,3,nums.length);
    System.out.println(findTripletV2(nums,0,10,nums.length-1,3));
    System.out.println(findTripletV2(nums,0,17,nums.length-1,3));
  }

  public static int numPartitions(String res,int total,int n,int count){
    int result=0;
    if(total == n){
      System.out.println(res);
      return ++count;
    }
    if(total > n){
      return count;
    }
    for(int i=1;i <= n;i++){
      result += numPartitions(i + " " + res,total + i,n,count);
    }
    return result;
  }

  public static int numSteps(int total,int n,int count){
    int result = 0;
    if(total == n){
      return ++count;
    }
    if(total > n)return count;
    for(int i=1;i <=3;i++){
      result += numSteps(total +i,n,count);
    }
    return result;
  }

  /**
   * Find triplet having sum k in array
   * @param nums
   * @param out
   * @param cursum
   * @param k
   * @param n
   */
  public static void findTriplet(int[] nums,String out,int cursum,int sum,int k,int n){
    if(k > n)return;
    if(cursum == sum && k == 0){
      System.out.println(out);
      return;
    }
    if(k != 0 && cursum >= sum)return;
    for(int i = n-1;i >= 0;i--){
     findTriplet(nums,nums[i] + " " + out,cursum + nums[i],sum,k-1,i);
    }
  }

  public static boolean findTripletV2(int[] nums,int cursum,int sum,int n,int k){
    if(cursum == sum && k == 0){
      return true;
    }
    if(n < 0)return false;
    if(cursum >= sum && k != 0)return false;
    cursum = cursum + nums[n];
    boolean step1 = findTripletV2(nums,cursum,sum,n-1,k-1);
    cursum = cursum - nums[n];
    boolean step2 = findTripletV2(nums,cursum,sum,n-1,k);
    if(step1 == true || step2 == true)
      return true;
    else
      return false;
  }
}
