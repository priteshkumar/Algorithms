package com.mavixk.ds.exam;
import java.util.*;

public class SortStack {
  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    //Integer.valueOf("+");
    int n = scan.nextInt();
    Stack<Integer> s = new Stack<Integer>();

    for(int i=0; i < n;i++){
      s.add(scan.nextInt());
    }
    int k = scan.nextInt();

    if(s.empty() == true){
      System.out.println("the stack is empty");
      return;
    }
    else if(s.size() < k || k <= 0){
      System.out.println("invalid input");
    }
    else {
      Stack<Integer> temp = new Stack<Integer>();
      while (s.empty() == false) {
        int val = s.pop();
        while (temp.empty() == false && temp.peek() > val) {
          s.push(temp.pop());
        }
        temp.push(val);
      }
      System.out.println(temp);
      while (--k > 0) {
        temp.pop();
      }
      System.out.println(temp.peek());
    }
  }

}
