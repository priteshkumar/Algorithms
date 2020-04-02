package com.mavixk.ds.Sorting;

public class ListSortDemo {

  static class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
      this.val = x;
    }
  }

  public static void main(String[] args){
    int[] a = {4,2,1,3};
    ListNode head1 = null;
    ListNode cur = null;
    for(int i=0;i < a.length;i++){
      ListNode temp = new ListNode(a[i]);
      if(head1 == null) {
        head1 = temp;
        cur = head1;
      }
      else{
        cur.next = temp;
        temp.next = null;
        cur = temp;
      }
    }
    ListNode temp = head1;
    while(temp != null){
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
    head1 = sortList(head1);
    temp = head1;
    while(temp != null){
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static ListNode mergeLists(ListNode a, ListNode b) {
    ListNode temp = null;
    if (a == null) {
      return b;
    } else if (b == null) {
      return a;
    }
    if (a.val <= b.val) {
      temp = a;
      temp.next = mergeLists(a.next, b);
    } else {
      temp = b;
      temp.next = mergeLists(a, b.next);
    }
    return temp;
  }

  public static ListNode getMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast= fast.next.next;
    }
    return slow;
  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode middle = getMiddle(head);
    ListNode right = middle.next;
    middle.next = null;
    ListNode a = sortList(head);
    ListNode b = sortList(right);
    ListNode temp = mergeLists(a, b);
    return temp;
  }
}