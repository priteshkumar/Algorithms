package mavixk.ds.leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class MinDiffTriplet {

  public static void main(String[] args) {
    //int a[] = {15, 12, 18, 9};
    //int b[] = {10, 17, 13, 8};
    //int c[] = {14, 16, 10, 5};

    int[] a = {1,2,3,4,5,6,7};
    int[] b = {8,9,10,5,11};
    int[] c = {12,5,13};
    System.out.println(minDiffTriplet(a,b,c));
  }

  public static List<Integer> minDiffTriplet(int[] a, int[] b, int[] c) {
    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);
    //9 , 12, 15 ,18
    // 8 , 10 , 13 , 17
    // 5 , 11 , 14 , 16
    int i = 0;
    int j = 0;
    int k = 0;
    int m = a.length;
    int n = b.length;
    int p = c.length;
    int mindiff = Integer.MAX_VALUE;
    int msum = Integer.MAX_VALUE;
    int p1 = -1;
    int p2 = -1;
    int p3 = -1;

    while(i < m && j < n && k < p){
     int maxval = Math.max(Math.max(a[i],b[j]),c[k]);
     int minval = Math.min(Math.min(a[i],b[j]),c[k]);
      if((maxval - minval) <= mindiff){
        int cursum = a[i] + b[j] + c[k];
        if(maxval - minval < mindiff){
          mindiff = maxval - minval;
          p1 = a[i];
          p2 = b[j];
          p3 = c[k];
          msum = cursum;
        }
        else if(cursum < msum){
          mindiff = maxval - minval;
          p1 = a[i];
          p2 = b[j];
          p3 = c[k];
          msum = cursum;
        }
      }
      if(minval == a[i])i++;
      else if(minval == b[j])j++;
      else if(minval == c[k])k++;
    }
    System.out.println(p1 + " " + p2 + " " + p3);
    return Arrays.asList(p1,p2,p3);
  }
}
