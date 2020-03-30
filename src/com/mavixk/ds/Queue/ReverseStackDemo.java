package com.mavixk.ds.Queue;
import java.util.*;

public class ReverseStackDemo {
  class Node{
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  Node top;
  public void push(int data){
    Node temp = new Node(data);
    if(top == null){
      top = temp;
    }
    else{
      temp.next = top;
      top = temp;
    }
  }

  public Node pop(){
    if(top != null){
      Node temp = top;
      top = top.next;
      return temp;
    }
    return null;
  }

  public void display(Node top){
    Node temp = top;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public Node reverse(){
    if(this.top == null || this.top.next == null)
      return this.top;
    //1 2 3 4 5
    Node temp = this.top;
    Node cur = null;
    Node prev = null;
    while(temp != null){
      cur = temp.next;
      temp.next = prev;
      prev = temp;
      temp = cur;
    }
    return prev;

  }

  public static void main(String[] args){
    ReverseStackDemo s = new ReverseStackDemo();
    for(int i=5;i >= 1;i--){
      s.push(i);
    }
    s.display(s.top);
    Node top = s.reverse();
    s.display(top);
  }

}
