package com.mavixk.ds.exam.oop.ds.linkedlist;
import java.util.*;

public class ReverseList {
  static class Node{
    int data;
    Node next;

    public Node(int data){
      this.data = data;
      this.next = null;
    }
  }
  static Node head = null;

  public static void main(String[] args){
    head = new Node(1);
    Node temp = head;
    for(int i=2; i <= 7;i++){
      temp.next = new Node(i);
      temp = temp.next;
    }
    temp.next = null;
    printList(head);
    temp = reverseList(head);
    printList(temp);
    Node cur = recursiveReverse(temp,null);
    printList(cur);
  }

  public static void printList(Node head){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  /*
    Iterative code to reverse linkedlist
   */
  public static Node reverseList(Node head){
    Node temp = null;
    Node cur = null;
    if(head == null || head.next == null)
      return head;

    //1 -> 2 ->3 -> 4
    while(head != null){
      temp = head.next;
      head.next = cur;
      cur = head;
      head = temp;
    }
    return cur;
  }

  /**
   * recursive code to reverse linkedlist
   * @param head
   * @param prev
   * @return
   */
  //1 2 3 4
  public static Node recursiveReverse(Node head,Node prev){
    Node temp = null;
    if(head != null) {
      temp = recursiveReverse(head.next, head);
      head.next = prev;
      if(prev != null)
        prev.next = null;
    }
    else
      return prev;
    return temp;
  }
}
