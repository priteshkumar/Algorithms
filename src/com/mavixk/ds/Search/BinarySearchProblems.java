package com.mavixk.ds.Search;
import java.util.*;

public class BinarySearchProblems {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    System.out.println(findfloorSqrt(n));
  }

  public static long findfloorSqrt(long x){
    long l = 1;
    long r = x;
    long mid = 0;
    while(l <= r){
      mid = l + (r -l)/2;
      if(mid * mid > x){
        if (((mid - 1) * (mid -1)) <= x)return mid -1;
        r = mid;
      }
      else if(mid * mid == x)return mid;
      else if(mid * mid < x){
        if( x - (mid * mid) <= 1)return mid;
        l = mid;
      }
    }
    return 0;
  }
}
