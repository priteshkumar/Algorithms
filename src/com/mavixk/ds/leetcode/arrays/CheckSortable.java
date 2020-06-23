package mavixk.ds.leetcode.arrays;

import java.util.Arrays;

public class CheckSortable {
  public static void main(String[] args){
    int a[] = {2,4,11,10,8,7,6,13,14};
    //         2,4,6,7,8,10,11,13,14
    int b[] = {1, 6, 3, 4, 5, 7, 2};
    System.out.println(checkSortable(a));
    System.out.println(checkSortable(b));
  }

  //compare elements at matching index or reversed index
  public static boolean checkSortable(int[] a){
    //int[] b = new int[a.length];
    //System.arraycopy(a,0,b,0,a.length);
    int[] b = Arrays.copyOf(a,a.length);
    Arrays.sort(b);
    int n = a.length;
    for(int i=0; i < a.length;i++){
      if(a[i] != b[i] && a[i] != b[n-i-1])
        return false;
    }
    return true;
  }
}