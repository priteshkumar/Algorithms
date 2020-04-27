package com.mavixk.ds.exam;
import java.util.*;

public class StackQPushOp {
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  public StackQPushOp(){
    this.q1 = new LinkedList<Integer>();
    this.q2 = new LinkedList<Integer>();
  }

  public void push(int val){
    q2.add(val);
    while(q1.isEmpty() == false){
      q2.add(q1.remove());
    }
    Queue<Integer> temp = q2;
    q2 = q1;
    q1 = temp;
  }

  public int pop(){
    if(q1.isEmpty() == false)
      return q1.remove();
    else
      throw new EmptyStackException();
  }

  public int top(){
    if(q1.isEmpty() == false)
      return q1.peek();
    else
      throw new EmptyStackException();
  }

  public static void main(String[] args){
    StackQPushOp s = new StackQPushOp();
    s.push(3);
    s.push(4);
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());
    s.pop();

  }
}
