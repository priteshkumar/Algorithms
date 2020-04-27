package com.mavixk.ds.exam.oop.ds.Hashtables;
import java.util.*;

public class SymmetricPairs {
  public static void main(String[] args){
    System.out.println(lexcompare("puzzled","puzzling"));
    System.out.println(lexcompare("puzzling","puzzled"));
    System.out.println(lexcompare("puzzled","puzzled"));
    System.out.println(lexcompare("puzzled","puzzle"));
    System.out.println(lexcompare("puzzle","puzzled"));
    int[][] a = new int[5][2];
    a[0][0] = 1;
    a[0][1] = 2;
    a[1][0] = 2;
    a[1][1] = 3;
    a[2][0] = 3;
    a[2][1] = 4;
    a[3][0] = 2;
    a[3][1] = 1;
    a[4][0] = 4;
    a[4][1] = 3;

    //a = d , b = c
    int count  = 0;
    HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
    for(int i=0 ; i < 5;i++){
      if(m.get(a[i][1]) != null && m.get(a[i][1]) == a[i][0]){
        System.out.println(a[i][1] + " " + m.get(a[i][1]));
        count++;
      }
      else{
        m.put(a[i][0],a[i][1]);
      }
    }
    if(count == 0)
      System.out.println("No Symmetric pair");
  }

  public static int lexcompare(String s1,String s2){
      int m = s1.length();
      int n = s2.length();
      //String a = m <= n?s1:s2;
      //String b = m > n?s1:s2;
      int i = 0;
      int j = 0;//puzzled
      //System.out.println(m + " " + n);
      while(m != 0 && n != 0){
        if(s1.charAt(i) > s2.charAt(j))
          return 1;
        else if(s1.charAt(i) < s2.charAt(j))
          return -1;
        i++;
        j++;
        m--;
        n--;
      }
      //System.out.println(m + " " + n);

      if(m > 0)
        return 1;
      else if(n > 0)
        return -1;
      else
        return 0;
  }
}
