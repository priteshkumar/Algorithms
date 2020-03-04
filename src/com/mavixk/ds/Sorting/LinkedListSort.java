package com.mavixk.ds.Sorting;
import java.util.*;

class LinkedList{
  public Node head = null;
  static class Node{
    private int val;
    private Node next;

    public Node(int val){
      this.val = val;
      this.next = null;
    }
  }

  public void pushNode(int val){
    Node temp = new Node(val);
    temp.next = head;
    head = temp;
  }

  public Node sortedMerge(Node a,Node b){
    Node result = null;
    if(a == null)
      return b;
    else if(b == null)
      return a;
    if(a.val <= b.val){
      result = a;
      result.next = sortedMerge(a.next,b);
    }
    else{
      result = b;
      result.next = sortedMerge(a,b.next);
    }
    return result;
  }

  public Node mergeSort(Node h){
    if(h == null || h.next == null)
      return h;
    Node middle = getMiddleNode(h);
    Node nextOfMiddle = middle.next;
    middle.next = null;
    Node a = mergeSort(h);
    Node b = mergeSort(nextOfMiddle);
    Node headref = sortedMerge(a,b);
    return headref;
  }

  public Node getMiddleNode(Node h){
    if(h == null)
      return h;

    Node slow = h;
    Node fast = h;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public void printList(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}


public class LinkedListSort {
  public static void main(String[] args){
    LinkedList list = new LinkedList();
    for(int i=1;i <= 10;i++){
      list.pushNode(i);
    }
    list.printList();
    list.head = list.mergeSort(list.head);
    System.out.println("sorted list is: ");
    list.printList();
  }
}
