package com.mavixk.ds.Queue;
import java.util.*;


class QStack{
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  public QStack(){
    this.q1 = new LinkedList<Integer>();
    this.q2 = new LinkedList<Integer>();
    
  }

  public void push(int data){
    if(this.q2.isEmpty() == true)
      this.q2.add(data);
    while(this.q1.isEmpty() == false){
      this.q2.add(this.q1.remove());
    }
    Queue<Integer> temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;
  }

  public int pop(){
    if(this.q1.isEmpty() == false)
      return this.q1.remove();
    else
      throw new EmptyStackException();
  }

  public int size(){
    return this.q1.size();
  }

  public int top(){
    if(this.q1.isEmpty() == false)
      return this.q1.peek();
    else
      throw new EmptyStackException();
  }
}


class MyStack{
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  int top;
  public MyStack(){
    this.q1 = new LinkedList<Integer>();
    this.q2 = new LinkedList<Integer>();
    this.top = Integer.MIN_VALUE;
  }

  public void push(int data){
    if(this.q1.isEmpty() == true)
      this.q2.add(data);
    else
      this.q1.add(data);
    this.top = data;
  }

  public int pop(){
    if(this.q1.isEmpty() == true && this.q2.isEmpty() == true)
      throw new EmptyStackException();

    if(this.q2.isEmpty() == true){
      int count = this.q1.size()-1;
      while(count > 0){
        if(count == 1)
          top = this.q1.peek();
        this.q2.add(this.q1.remove());
        count--;
      }
      return this.q1.remove();
    }
    else{
      int count = this.q2.size() -1;
      while(count > 0){
        if(count == 1)
          top = this.q2.peek();
        this.q1.add(this.q2.remove());
        count--;
      }
      return this.q2.remove();
    }
  }

  public int top(){
    /*change this*/
    if(this.empty() == false)
      return this.top;
    else
      throw new EmptyStackException();
  }

  public boolean empty(){
    return (this.q1.isEmpty() == true && this.q2.isEmpty() == true);
  }

  public int size(){
    return this.q1.size() + this.q2.size();
  }
}


public class StackWithQ {
  public static void main(String[] args){
    MyStack s = new MyStack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.top());
    System.out.println(s.pop());
    System.out.println(s.top());
    System.out.println(s.pop());
    System.out.println(s.top());
  }

}
