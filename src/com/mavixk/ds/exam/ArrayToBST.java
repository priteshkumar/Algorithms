package mavixk.ds.exam.oop.ds;
import java.util.*;

class Node{
  private int val;
  Node left;
  Node right;
  public Node(int val){
    this.val = val;
    this.left = this.right = null;
  }
}

public class ArrayToBST {
  static int k = 0;
  public static void main(String[] args){
    int[] a = new int[1023];
    for(int i=0;i < a.length;i++)
      a[i] = i+1;
    Node root = arrayToBST(a,0,a.length-1);
  }

  public static Node arrayToBST(int[] a,int s,int e){
    if(s > e)
      return null;
    int mid = (s+e)/2;
    Node root = new Node(a[mid]);
    k++;
    System.out.print(k + ":" + a[mid] + " ");
    root.left = arrayToBST(a,s,mid-1);
    root.right = arrayToBST(a,mid+1,e);
    return root;
  }
}
