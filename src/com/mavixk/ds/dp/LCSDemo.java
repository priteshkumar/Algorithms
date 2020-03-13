package com.mavixk.ds.dp;
import java.util.*;

public class LCSDemo {

  public static void main(String[] args){
    String a =
        "ataatctgtactttcgcgcgcgatacagttgctcaagtagccattcgggtgcctgacggcatgacatgtatgccactttcaccaaagtaatcatcttaac";
    String b =
        "ggtaataaaaggctcgcccaccccgaccctgaagtgaagaagtaacgttgttcatgatcgacccgcatgaattcatagcaacgccgactgatctactccc";
    System.out.println(solveLCS(a,b));
    System.out.println(solveLCSoptimised(a,b));
    a = "batman";
    b = "superman";
    System.out.println(solveLCS(a,b));
    System.out.println(solveLCSoptimised(a,b));
  }

  /**
   * Solve lcs using dp
   * @param a
   * @param b
   * @return
   */
  public static int solveLCS(String a,String b){
    int[][] lcs = new int[a.length()+1][b.length()+1];
    for(int i=0; i <= a.length();i++){
      for(int j=0;j <= b.length();j++){
        if(i == 0 || j == 0)
          lcs[i][j] = 0;
        else if(a.charAt(i-1) == b.charAt(j-1))
          lcs[i][j] = 1 + lcs[i-1][j-1];
        else
          lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
      }
    }
    return lcs[a.length()][b.length()];
  }

  public static int solveLCSoptimised(String a,String b){
    int[][] lcs = new int[2][b.length()+1];
    for(int j=0; j <= b.length();j++)
      lcs[0][j] = 0;
    for(int i=0; i <= 1;i++){
      lcs[i][0] = 0;
    }
    int row = 1;//batman ,superman
    for(int i=1;i <= a.length();i++){
      for(int j=1;j <= b.length();j++){
        if(a.charAt(i-1) == b.charAt(j-1))
          lcs[row][j] = 1 + lcs[row-1 >= 0?row-1:row][j-1];
        else
          lcs[row][j] = Math.max(lcs[row-1 >= 0?row-1:row][j],lcs[row][j-1]);
      }
      row = row ^ 1;
    }
    return lcs[row][b.length()];
  }
}
