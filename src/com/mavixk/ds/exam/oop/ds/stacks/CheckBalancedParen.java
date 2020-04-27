package com.mavixk.ds.exam.oop.ds.stacks;
import java.util.*;

public class CheckBalancedParen {
  public static void main(String[] args){
    String exp = "(a+b)";
    exp = "(a()";
    System.out.println(checkValidParen(exp));
    String s = "((a+1)+(b+1))";
    s = "(a + (a+b))";
    System.out.println(duplicateParen(s));

  }

  public static boolean checkValidParen(String exp){
    Stack<Character> temp = new Stack<Character>();
    for(int i=0; i < exp.length();i++){
      char val = exp.charAt(i);
      if(val != ')')
        temp.push(val);
      else if(val == ')'){
        if(temp.empty() == true)return false;
        while(temp.empty() == false && temp.peek() != '('){
          temp.pop();
        }
        if(temp.empty() == true)
          return false;
        temp.pop();
      }
    }
    return temp.empty();
  }

  //(((a+1))+(b+1))
  //(a + (a+b))
  public static boolean duplicateParen(String s){
    Stack<Character> temp = new Stack<Character>();
    for(int i=0; i < s.length();i++){
     char val = s.charAt(i);
     if(val != ')')
      temp.push(val);
     else if(val == ')'){
       char c = temp.pop();
       int k = 0;
       while(temp.empty() == false && c != '('){
         c = temp.pop();
         k++;
       }
        if(k <= 1)return false;
     }
    }
    return true;
  }

}
