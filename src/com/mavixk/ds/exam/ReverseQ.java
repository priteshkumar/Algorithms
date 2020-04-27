package com.mavixk.ds.exam;
import java.util.*;

public class ReverseQ {
  public static void main(String[] args){
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i=1;i <= 7;i++)
      q.add(i);

    reverseQ(q);
    System.out.println(q);
    sortQ(q);
    System.out.println(q);
  }

  public static void reverseQ(Queue<Integer> q){
    if(q.isEmpty() == false){
      int val = q.remove();
      reverseQ(q);
      q.add(val);
      //insertBack(q,val);
    }
  }

  public static void sortQ(Queue<Integer> q){
    
  }
}
