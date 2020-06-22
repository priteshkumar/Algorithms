package mavixk.ds.leetcode.search;

public class FindPower {
  public static double calcPow(double x, int n) {
    double res = 0;
    if(n == 0)return 1;

    int posn = (int)Math.abs(n);
    res = calcPow(x,n/2);
    if(n % 2 == 0){
      res = res * res;
    }
    else if(n % 2 != 0){
      if(n > 0)
        res = x * res * res;
      else
        res = (1/x) * res * res;

    }
    return res;
  }

  public static void main(String[] args){
    System.out.println(calcPow(2,4));
    System.out.println(calcPow(2,5));
    System.out.println(calcPow(2,-3));
  }
}
