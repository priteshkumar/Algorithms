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
    coins = new int[]{186,419,83,408};
    Arrays.sort(coins);
    int pay = 6249;
    System.out.println(coinChange(coins,pay));
    coins = new int[]{1,2,3};
    System.out.println(permuteWays(coins,4));
    System.out.println(permuteWays(coins,3));
    System.out.println(permuteWays(coins,5));
    coins = new int[]{2,3,5,6};
    System.out.println(permuteWays(coins,10));
    coins = new int[]{18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
    Arrays.sort(coins);
    pay = 458;
    System.out.println(permuteWays(coins,pay));
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

  public static int coinChange(int[] coins, int amount) {
    int[][] res = new int[amount+1][coins.length+1];

    for(int j=0;j <= coins.length;j++)
      res[0][j] = 0;

    for(int j=1; j <= coins.length;j++){
      int d = coins[j-1];
      for(int i=1; i <= amount;i++){
        if(j == 1){
          res[i][j] = (i % d == 0)?i/d:Integer.MAX_VALUE;
        }
        else{
          res[i][j] = res[i][j-1];
          if(d <= i && res[i-d][j] != Integer.MAX_VALUE)
            res[i][j] = Math.min(res[i][j],1 + res[i-d][j]);
        }
      }

    }
    int val = res[amount][coins.length];
    return val < Integer.MAX_VALUE?val:-1;
  }
}
