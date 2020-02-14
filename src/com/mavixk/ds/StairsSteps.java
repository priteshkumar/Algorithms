package com.mavixk.ds;
import java.util.*;

public class StairsSteps {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    //System.out.println(numPartitions("",0,n,0));
    System.out.println("total ways: " + numSteps(0,n,0));
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
}
