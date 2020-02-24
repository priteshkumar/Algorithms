package com.mavixk.ds;
import java.util.*;

public class FIndStairWays {
  public static void main(String[] args){
    int steps = 5;
    System.out.println(getWays(steps,"",0,0));
  }
  public static int getWays(int n,String out , int sum,int count){
    if(n == sum){
     System.out.println("found sum " + n + " : " + out);
      return ++count;
    }

    if(n < sum){
      return count;
    }

    int step1 = 0;
    int step2 = 0;
    step1 += getWays(n,out + " " + 1,sum + 1,count);
    step2 += getWays(n,out + " " + 2,sum+2,count);
    return step1 + step2;
  }
}
