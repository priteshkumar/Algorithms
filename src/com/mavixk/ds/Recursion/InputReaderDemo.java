package com.mavixk.ds;
import java.util.*;

public class InputReaderDemo {
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args){
    checkInput();
    scan.close();
  }

  public static void checkInput(){
    int c = scan.nextInt();
    scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    while(c-- > 0) {
      int n = scan.nextInt();
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      int[] a = new int[n];
      int[] b = new int[n];
      String[] arrItems = scan.nextLine().split(" ");
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        a[i] = arrItem;
      }
      arrItems = scan.nextLine().split(" ");
      scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        b[i] = arrItem;
      }

      for(int i:a){
        System.out.print(i + " ");
      }
      System.out.println();
      for(int i:b){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
