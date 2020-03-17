package com.mavixk.ds.stack;

import java.util.*;

class StackGeneric<T> {

  private LinkedList<T> list;

  public StackGeneric() {
    this.list = new LinkedList<T>();
  }

  public void push(T data) {
    this.list.add(data);
  }

  public T pop() {
    if (list.size() > 0) {
      T data = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return data;
    }
    throw new EmptyStackException();
  }

  public boolean empty() {
    return list.size() == 0 ? true : false;
  }

  public T peek() {
    if (list.size() > 0) {
      T data = list.get(list.size() - 1);
      return data;
    }
    throw new EmptyStackException();
  }
}


public class StackImpl {

  public static void main(String[] args) {
    StackGeneric<Integer> s = new StackGeneric<Integer>();
    s.push(20);
    s.push(30);
    s.push(40);
    System.out.println(s.peek());
    System.out.println(s.empty());
    try {
      System.out.println(s.pop());
      System.out.println(s.pop());
      System.out.println(s.peek());
      System.out.println(s.pop());
      System.out.println(s.pop());
    } catch (EmptyStackException e) {
      System.out.println("pop operation on empty stack...");
      System.out.println(s.empty());
    }
  }
}
