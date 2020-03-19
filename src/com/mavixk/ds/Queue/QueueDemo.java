package com.mavixk.ds.Queue;
import java.util.*;

class QueueImpl<T>{
  private LinkedList<T> queue;

  public QueueImpl(){
    this.queue = new LinkedList<T>();
  }

  public void add(T data){
    this.queue.add(data);
  }

  public T remove(){
    if(this.queue.size() > 0)
      return this.queue.remove();
    else
      throw new NoSuchElementException();
  }

  public T peek(){
    if(this.queue.size() > 0)
      return this.queue.peek();
    else
      return null;
  }

  public T poll(){
    if(this.queue.size() > 0)
      return this.queue.remove();
    else
      return null;
  }

  public int size(){
    return this.queue.size();
  }
}


public class QueueDemo {
  public static void main(String[] args){
    QueueImpl<Integer> q = new QueueImpl<Integer>();
    q.add(1);
    q.add(2);
    q.add(23);
    System.out.println(q.peek());
    q.remove();
    System.out.println(q.peek());
    q.remove();
    System.out.println(q.peek());
  }
}
