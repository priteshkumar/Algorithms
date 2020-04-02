package com.mavixk.ds.Hashing;
import java.util.*;

public class SumTwo {
  public static void main(String[] args){
    int[] a = {2,7,11,15};
    int k = 26;
    System.out.println(checkTwoSum(a,k));
  }

  public static int[] checkTwoSum(int[] a, int k){
   // HashMap<Integer,Integer> res = new HashMap<Integer, Integer>();
    int[] b = new int[2];

    HashMap<Integer,Integer> res = new HashMap<Integer, Integer>();
    
    for(int i=0; i < a.length;i++){
      res.putIfAbsent(a[i],i);
    }
    System.out.println(res.entrySet());
    for(int i=1; i < a.length;i++){
      int index = res.getOrDefault(k-a[i],-1);
      if(index >= 0 && index != i){
        b[0] = index;
        b[1] = i;
        System.out.println(b[0] + " " + b[1]);
        break;
      }
    }
    return b;
  }
}
