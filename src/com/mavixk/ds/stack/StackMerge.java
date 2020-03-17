package com.mavixk.ds.stack;

import java.util.*;

public class StackMerge {

  public static void main(String[] args) {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    s1.push(1);
    s1.push(3);
    s1.push(5);
    s2.push(1);
    s2.push(2);
    s2.push(3);
    s2.push(4);
    s2.push(7);
    //reverseStack(s2,0,s2.size()-1);
    reversedStack(s2);
    System.out.println(s2);
    merge_stacks(s1, s2);

    s1.clear();
    s1.push(1);
    s1.push(2);
    s1.push(3);
    s2.clear();
    s2.push(1);
    s2.push(4);
    s2.push(2);
    s2.push(5);
    s2.push(3);
    System.out.println(contains(s1,s2));
    s1.clear();
    s2.clear();
    s1.push(1);
    s1.push(2);
    s1.push(3);
    s2.push(1);
    s2.push(2);
    s2.push(4);
    s2.push(5);
    System.out.println(contains(s1,s2));
    sortStack();
  }

  /**
   * Merge 2 sorted stacks into 3rd stack
   * @param s1
   * @param s2
   */
  public static void merge_stacks(Stack<Integer> s1, Stack<Integer> s2) {
    Stack<Integer> s3 = new Stack<Integer>();
    while ((s1.isEmpty() == false) && (s2.isEmpty() == false)) {
      if (s1.peek() > s2.peek()) {
        s3.push(s1.pop());
      } else {
        s3.push(s2.pop());
      }
    }
    while (s1.isEmpty() == false) {
      s3.push(s1.pop());
    }
    while (s2.isEmpty() == false) {
      s3.push(s2.pop());
    }

    for (int i = 0; i < s3.size(); i++) {
      System.out.print(s3.elementAt(s3.size() - 1 - i));
    }
    System.out.println();
  }

  public static Boolean contains(Stack<Integer> sequence1, Stack<Integer> sequence2) {
    // This block will be filled by the student
    Stack<Integer> s1 = sequence1;
    Stack<Integer> s2 = sequence2;
    if(s1.empty() == true && s2.empty() == true)
      return true;
    if(s1.empty() == true || s2.empty() == true)
      return false;
    if(s1.size() > s2.size())
      return false;
    int prev=s2.size();
    int cur = s2.size();
    for(int i=0; i < s1.size();i++){
      int a = s1.elementAt(s1.size()-1-i);
      cur = s2.search(a);
      //System.out.println(a + " " + cur + " " + prev);
      if(cur == -1 || (s2.size() - cur > prev))
        return false;
      prev = s2.size() - cur;
    }
    return true;
  }

  /**
   * reverses last half of stack using recursion
   * @param s
   * @param start
   * @param end
   */
  public static void reverseStack(Stack<Integer> s,int start,int end){
    if(start >= s.size()/2)
        return;
    int temp = s.elementAt(s.size()-1-start);
    s.set(s.size()-1-start,s.elementAt(start));
    s.set(start,temp);
    reverseStack(s,start+1,end-1);
  }

  /**
   * sorts stack using extra stack
   * largest element is placed at top
   */
  public static void sortStack(){
    Stack<Integer> s = new Stack<Integer>();
    int[] a = {6,12,3,4,5,1,7,8,10,9,11,2};
    for(int i:a)
      s.push(i);
    Stack<Integer> temp = new Stack<Integer>();
    while(s.empty() == false){
      int val = s.peek();
      s.pop();
      if(temp.empty() == true)
        temp.push(val);
      else if(temp.peek() <= val)
        temp.push(val);
      else {
        while(temp.empty() == false && temp.peek() > val){
          s.push(temp.peek());
          temp.pop();
        }
        temp.push(val);
      }
    }
    System.out.println(temp);
  }

  private static void insertBottom(Stack<Integer> s,int val){
    if(s.empty() == true)
      s.push(val);
    else{
      int x = s.peek();
      s.pop();
      insertBottom(s,val);
      s.push(x);
    }
  }

  /**
   * reverses stack using recursion
   * @param s
   */
  public static void reversedStack(Stack<Integer> s){

    if(s.empty() == false) {
      int a = s.peek();
      s.pop();
      reversedStack(s);
      insertBottom(s,a);
    }
  }
}
