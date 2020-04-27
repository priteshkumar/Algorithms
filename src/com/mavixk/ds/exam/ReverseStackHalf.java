package com.mavixk.ds.exam;

import java.util.*;

public class ReverseStackHalf {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    for (int i = 0; i < a.length; i++) {
      s.push(a[i]);
    }
    //System.out.println(s);
    reverseStack(s,s.size()/2);
    System.out.println(s);
    s.clear();
    int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    for (int i = 0; i < b.length; i++) {
      s.push(b[i]);
    }
    reverseStack(s,s.size()/2);
    System.out.println(s);
    sortStack(s);
    for (int i = 0; i < a.length; i++) {
      s.push(a[i]);
    }
    deleteBottom(s,s.size(),s.size());
    System.out.println(s);
  }

  // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
  public static void reverseStack(Stack<Integer> s,int n) {
    if (s.empty() == false && n-- > 0) {
      int val = s.pop();
      reverseStack(s,n);
      insertBottom(s, val,n);
    }
  }

  private static void insertBottom(Stack<Integer> s, int val,int n) {
    if(s.empty() == true || n == 0)
      s.push(val);
    else{
      int x = s.pop();
      insertBottom(s,val,n-1);
      s.push(x);
    }
  }

  public static void sortStack(Stack<Integer> s){
    Stack<Integer> temp = new Stack<Integer>();
    while(s.empty() == false){
      int val = s.pop();
      while(temp.empty() == false && temp.peek() > val)
        s.push(temp.pop());
      temp.push(val);
    }
    System.out.println(temp);
  }

  /**
   * deletes bottom half of stack using recursion
   * @param s
   * @param n
   * @param size
   */
  public static void deleteBottom(Stack<Integer> s,int n,int size){
    if(s.empty() == false){
      int val = s.pop();
      deleteBottom(s,--n,size);
      if(n >= size/2)
        s.push(val);
    }
  }

}
