package com.mavixk.ds.dp;
import java.util.*;

public class Knapsack01Demo {
  public static void main(String[] args){
    int[] w = {4,3,1,2};
    int[] v = {10,12,8,15};
    int W = 7;
    System.out.println(getMaxProfit(w,v,W));
    int[] w1 = {4,6,5,7,3,1,6};
    int[] v1 = {12,10,8,11,14,7,9};
    W = 18;
    System.out.println(getMaxProfit(w1,v1,W));
    int[] w2 = {5, 7, 3, 8, 4, 3, 7, 5};
    int[] v2 = {12, 10, 9, 16, 14, 7, 14, 10};
    W = 23;
    int profit = getMaxProfit(w2,v2,W);
    trackProfitItems(w2,v2,W);

  }

  /**
   * 01 knapsack solution for maximum profit
   * @param w
   * @param v
   * @param W
   * @return
   */
  public static int getMaxProfit(int[] w,int[] v,int W){
    int[][] result = new int[w.length+1][W+1];
    for(int j=0;j <= W;j++){
      if( j >= w[0])
        result[1][j] = v[0];
      else
        result[1][j] = 0;
    }
    for(int i=2;i <= w.length;i++){
      for(int j=1;j <= W;j++){
        if(w[i-1] <= j)
          result[i][j] = Math.max(result[i-1][j],v[i-1] + result[i-1][j-w[i-1]]);
        else
          result[i][j] = result[i-1][j];
      }
    }
    return result[w.length][W];
  }

  /**
   * Prints items selected in maximum profit case
   * Uses backtracking approach
   * @param w
   * @param v
   * @param W
   */
  public static void trackProfitItems(int[] w,int[] v,int W){
    int[][] result = new int[w.length+1][W+1];
    for(int j=0;j <= W;j++){
      if( j >= w[0])
        result[1][j] = v[0];
      else
        result[1][j] = 0;
    }
    for(int i=2;i <= w.length;i++){
      for(int j=1;j <= W;j++){
        if(w[i-1] <= j)
          result[i][j] = Math.max(result[i-1][j],v[i-1] + result[i-1][j-w[i-1]]);
        else
          result[i][j] = result[i-1][j];
      }
    }

    int i = w.length;
    int j = W;
    while(i > 0 && j > 0){
        if(result[i][j] == result[i-1][j])
          i = i -1;
        else {
          System.out.print(i + " ");
          j = j - w[i - 1];
          i = i - 1;
        }
      }
    }
}
