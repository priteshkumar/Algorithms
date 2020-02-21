package com.mavixk.ds.Search;
import java.util.*;

public class MatrixSearch {
  public static void main (String[] args) {
    //code
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for(int k=0;k < n;k++){
      int row = scan.nextInt();
      int col = scan.nextInt();
      //ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
      int[][] alist = new int[row][col];
      for(int i=0; i < row;i++){
        //rlist = new ArrayList<Integer>(col);
        for(int j=0;j < col;j++){
          alist[i][j] = scan.nextInt();
        }
        //alist.add(rlist);
      }
      int v = scan.nextInt();
      int index =  matrixSearch(alist,row,col,v);
      if(index != -1){
        System.out.println("1");
      }
      else
        System.out.println("0");
    }

  }

  /**
   * Searches element in n* m matrix , using binary search
   * First binary search is done to locate the possible row
   * Next again binary search is done in that row
   * Elements in each row are sorted.
   * First element of each row is >= last element of previous row
   * @param a
   * @param row
   * @param col
   * @param k
   * @return
   */
  public static int matrixSearch(int[][] a,int row, int col,int k){
    int rlow = 0;
    int rhigh = row -1;
    int rmid = 0;
    if((k < a[0][0]) || (k > a[row-1][col-1]))return -1;

    //Locate the possible row
    while(rlow <= rhigh){

      if(rhigh == rlow){
        if(a[rlow][col-1] == k)return 1;
        rmid = rlow + (rhigh - rlow)/2;
        break;

      }
      rmid = rlow + (rhigh - rlow)/2;
      if(a[rmid][col-1] == k)return 1;
      else if(k < a[rmid][col-1] && k >= a[rmid][0])
        break;
      else if(k > a[rmid][col-1])
        rlow = rmid + 1;
      else
        rhigh = rmid -1;

    }

    //Possible row located in rmid
    //Search in the row rmid

    int clow = 0;
    int chigh = col -1;
    int cmid = 0;
    while(clow <= chigh){
      cmid = clow + (chigh - clow)/2;
      if(a[rmid][cmid] == k)return 1;
      else if(a[rmid][cmid] > k)chigh = cmid -1;
      else
        clow = cmid + 1;

    }
    return -1;
  }

}