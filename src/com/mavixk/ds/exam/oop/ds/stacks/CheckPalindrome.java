package com.mavixk.ds.exam.oop.ds.stacks;
import java.util.*;

public class CheckPalindrome {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    Stack<Character> temp = new Stack<Character>();
    StringBuilder s = new StringBuilder();
    for(int i=0;i < input.length();i++)
      temp.push(input.charAt(i));
    while(temp.empty() == false){
      s.append(temp.pop());
    }
    if(s.toString().equals(input))
      System.out.println("input is palindrome");

  }
}