package com.mavixk.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestDemo {
  public static void main(String[] args){
    int[] nums = {3,2,1};
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    res = genSubset(nums,res,list,nums.length-1);
    //Collections.sort(res);
    System.out.println(res);
  }

  public static ArrayList<ArrayList<Integer>> genSubset(int[] a,
      ArrayList<ArrayList<Integer>> res,ArrayList<Integer> out,
      int n){

    if(n < 0){
      System.out.println(out);
      res.add(out);
      return res;
    }

    out.add(a[n]);
    res = genSubset(a,res,out,n-1);
    out.remove(out.size() -1);
    res = genSubset(a,res,out,n-1);
    return res;
  }
}
