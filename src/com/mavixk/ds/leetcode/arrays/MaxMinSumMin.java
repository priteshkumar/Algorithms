package mavixk.ds.leetcode.arrays;

public class MaxMinSumMin {
  public static void main(String[] args){
    int[] a = new int[]{1, 4, 2, 6, 7};
    System.out.println(getMinVal(a));
  }

  public static int getMinVal(int[] a){
    if(a == null || a.length <= 1)
      return -1;
    int msum = Integer.MAX_VALUE;
    for(int i=1; i < a.length;i++){
      msum = Math.min(msum, a[i] + a[i-1]);
    }
    return msum;
  }
}
