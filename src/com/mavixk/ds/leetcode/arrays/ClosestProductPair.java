package mavixk.ds.leetcode.arrays;

import java.util.Arrays;

public class ClosestProductPair {
  public static void main(String[] args){
    int[] a = { 1, 2, 4 ,6, 7, 8};
    int k = 44;
    closestProductPair(a,k);
  }

  public static void closestProductPair(int[] a, int k){
    Arrays.sort(a);
    int l = 0;
    int r = a.length-1;
    int product = 1;
    int p1 = -1;
    int p2 = -1;
    int diff = Integer.MAX_VALUE;
    while(l < r){
      product = a[l] * a[r];
      if((int)Math.abs(product - k) < diff){
       diff =  (int)Math.abs(product - k);
        p1 = a[l];
        p2 = a[r];
      }
      if(product > k)
        r--;
      else if(product < k)
        l++;
      else
        break;
    }
    System.out.println(p1 + " " + p2);
  }
}
