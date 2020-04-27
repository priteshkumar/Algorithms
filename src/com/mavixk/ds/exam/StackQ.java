package com.mavixk.ds.exam;
import java.util.*;

public class StackQ {
  private Queue<Integer> s1;
  private Queue<Integer> s2;
  private int top;
  public StackQ(){
    this.s1 = new LinkedList<Integer>();
    this.s2 = new LinkedList<Integer>();
    this.top = -1;
  }

  public void push(int x){
    s1.add(x);
    top = x;
  }

  public int pop(){
    if(s1.isEmpty() == true)
      throw new EmptyStackException();
    int len = s1.size()-1;
    while(len-- > 0){
      if(len == 0)
        top = s1.peek();
      s2.add(s1.remove());
    }
    int val = s1.remove();
    Queue<Integer> temp = s2;
    s2 = s1;
    s1= temp;
    return val;
  }

  public int top(){
    if(s1.isEmpty() == true)
      throw new EmptyStackException();
    return top;
  }

  public boolean empty(){
    return s1.isEmpty() == true;
  }

  public static int printPrec(String val){
    if(val == "+")
      return 1;
    else
      return -1;
  }

  public static void main(String[] args){
    String val = new String("+");
    System.out.println(printPrec(val));
    StackQ s = new StackQ();
    s.push(3);
    s.push(4);
    s.push(2);
    s.pop();
    System.out.println(s.empty());
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());
    System.out.println(s.pop());
    System.out.println(s.empty());
  }
}
