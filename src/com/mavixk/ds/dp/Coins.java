package com.mavixk.ds.dp;
import java.util.*;

public class Coins {
  public static void main(String[] args){
    int[] coins = {1,7,10};
    /*System.out.println(minCoins(coins,15));
    System.out.println(minCoins(coins,17));
    System.out.println(permuteWays(coins,15));
    System.out.println(permuteWays(coins,10));
    System.out.println(permuteWays(coins,9));*/
    coins = new int[]{1,2,3};
    System.out.println(permuteWays(coins,4));
    System.out.println(permuteWays(coins,3));
    System.out.println(permuteWays(coins,5));
    coins = new int[]{2,3,5,6};
    System.out.println(permuteWays(coins,10));
    coins = new int[]{18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
    Arrays.sort(coins);
    int pay = 458;
    System.out.println(permuteWays(coins,pay));
    System.out.println(Integer.MAX_VALUE);
  }

  /**
   * Finds mininmum coins used for amount
   * @param d
   * @param pay
   * @return
   */
  public static int minCoins(int[] d,int pay){
    int[] res = new int[pay+1];
    for(int i=0;i <= pay;i++)
      res[i] = i;
    for(int j=1;j <= d.length;j++){
      for(int i=1;i <= pay;i++){
        if(d[j-1] <= i){
          res[i] = Math.min(res[i],1 + res[i-d[j-1]]);
        }
      }
    }
    return res[pay];
  }

  /**
   * Finds number of ways to pay amount using different coins
   * @param d
   * @param pay
   * @return
   */
  public static int permuteWays(int[] d,int pay){
    int[] res = new int[pay+1];
    res[0] = 1;
    for(int j=1;j <= d.length;j++){
      for(int i=1;i <= pay;i++){
        if(d[j-1] <= i){
          int val = res[i-d[j-1]];
          res[i] = res[i]+ val;
        }
      }
    }
    return res[pay];
  }
}
