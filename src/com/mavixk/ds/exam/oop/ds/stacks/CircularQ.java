package com.mavixk.ds.exam.oop.ds.stacks;
import java.util.*;

public class CircularQ {
  private int[] q;
  private int s;
  private int e;
  private int len;
  public CircularQ(int size){
    this.len = size;
    q = new int[this.len];
    s = -1;
    e = -1;
  }

  public void add(int val){
    //System.out.println(val);
    if((s == 0 && e == this.len-1) || (e == ((s-1)%(this.len-1)))){
      throw new IndexOutOfBoundsException("queue is full");
    }
    else if(s == -1){
      s = e = 0;
      q[s] = val;
    }
    else if(e == this.len-1 && s != 0){
      e = 0;
      q[e] = val;
    }
    else{
      e++;
      System.out.println(e + " " + val);
      q[e] = val;
    }
  }

  public int remove(){
    if(s == -1)
      throw new IndexOutOfBoundsException("queue is empty");
    int val = q[s];
    //System.out.println("removed " + val);
    q[s] = -1;
    if(s == e){
      s = -1;
      e = -1;
    }
    else if(s == this.len -1){
      s = 0;
    }
    else{
      s++;
    }
    return val;
  }

  public void displayCQ(){
//    System.out.println(q[6]);
    for(int i=0;i < this.len;i++)
      System.out.print(q[i] + " ");
    System.out.println();
  }

  public static void main(String[] args){
    CircularQ cq = new CircularQ(7);
    for(int i=1;i <= 7;i++){
      cq.add(i);
    }
    cq.displayCQ();

    for(int i=1;i <= 2;i++){
      System.out.println(cq.remove());
    }
    cq.displayCQ();
  }
}
