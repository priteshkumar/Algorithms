package com.mavixk.ds.Sorting;

import java.util.*;

public class CheckEqualArrays {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = Integer.parseInt(scan.nextLine());
    scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    StringBuilder sb = new StringBuilder();
    while (t-- > 0) {
      int len = Integer.parseInt(scan.nextLine());
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      HashMap<Long, Integer> a = new HashMap<Long, Integer>();
      boolean flag = true;
      String[] nums = scan.nextLine().split(" ");
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < len; i++) {
        long val = Long.parseLong(nums[i]);
        int count = a.getOrDefault(val, 0);
        a.put(val, count + 1);
      }

      nums = scan.nextLine().split(" ");
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      for (int i = 0;i < len; i++) {
        long val = Long.parseLong(nums[i]);//scan.nextLong();
        int count = a.getOrDefault(val, 0);
        if (count == 0) {
          flag = false;
          break;
        }
        a.put(val, count - 1);
      }

      if(flag == false){
        sb.append("0\n");
        continue;
      }

      Collection<Integer> vals = a.values();
      for (Integer val : vals) {
        if (val != 0) {
          flag = false;
          break;
        }
      }
      if(flag == true)
        sb.append("1\n");
      else
        sb.append("0\n");

    }
    System.out.println(sb.toString());
  }
}