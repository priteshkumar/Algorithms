package com.mavixk.ds.stack;
import java.util.*;

public class ReverseDemo {
  public static void main(String[] args){
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    Stack<Integer> temp = new Stack<Integer>();
    for(int i=0; i < a.length;i++){
      temp.push(a[i]);
    }
    System.out.println(temp);
    reverseSecondHalf(temp,a.length/2);
    System.out.println(temp);
  }

  private static void insertBottom(Stack<Integer> a, int val,int n){
    if(a.empty() == true || n == 0)
      a.push(val);
    else{
      int x = a.pop();
      insertBottom(a,val,--n);
      a.push(x);
    }
  }

  public static void reverseSecondHalf(Stack<Integer> a,int n){
    if(a.empty() == false && n > 0){
      int val = a.pop();
      reverseSecondHalf(a,--n);
      insertBottom(a,val,n);
    }
  }
}
