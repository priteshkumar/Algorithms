package mavixk.ds.leetcode.search;

public class ReverseInt {

  public static void main(String[] args) {
    int[] a = { 3, 4};
    int[] b = { 7 , 9};
    System.arraycopy(b,0,a,0,b.length);
    System.out.println(a[0] + " " + a[1]);
    reverse(473);
    reverse(-473);
    reverse(1000000045);
    reverse(-1000000045);
    System.out.println(Integer.MAX_VALUE);
    reverse(Integer.MAX_VALUE);
    reverse(Integer.MIN_VALUE);
    reverse(999999998);
  }

  public static void reverse(int val) {
    // System.out.println(Integer.MAX_VALUE);
    boolean flag = val < 0 ? true : false;
    if (flag) {
      val = (int) Math.abs(val);
    }

    int res = 0;
    int lastres = 0;
    boolean overflow = false;
    while (val > 0) {
      res = res * 10 + val % 10;
      if ((res - (val % 10)) / 10 != lastres) {
        overflow = true;
        break;
      }
      //System.out.println(res);
      lastres = res;
      val = val / 10;
    }
    if (overflow == true) {
      System.out.println("0");
    } else {
      System.out.println(flag == true ? -res : res);
    }
  }
}
