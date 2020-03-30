package com.mavixk.ds.stack;

import java.util.*;

public class StackDemo {

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    int[] d = {-1,4,-3,7,8,-8,-2,5,3,10};
    for(int i=0;i < d.length;i++){
      s.push(d[i]);
    }
    Stack<Integer> temp = sortStack(s);
    System.out.println(temp.elementAt(temp.size()-4));

    s.push(-1);
    s.push(11);
    s.push(22);
    s.push(33);
    s.push(44);
    s.push(55);
    s.push(66);
    System.out.println(s.elementAt(s.size()-1));
    char a = '(';
    char b = ')';
    String c = String.valueOf(a) + b;
    System.out.println("matched string " + c);
    Stack<Character> sc = new Stack<Character>();
    System.out.println(s.elementAt(s.size() - 5));
    System.out.println(s);
    System.out.println(s.search(22));
    System.out.println(s.search(6));
    System.out.println(s.pop());
    System.out.println(s);
    System.out.println(matchParentheses("()[]{}"));
  }

  /**
   * Match parentheses uses stack
   * @param A
   * @return
   */
  public static int matchParentheses(String A) {
    Stack<Character> s = new Stack<Character>();
    String a = A;
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        s.push(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (s.empty() == true) {
          return 0;
        }
        char top = s.pop();
        String match = "" + top + c;
        if (match.equals("()") != true && match.equals("{}") != true
            && match.equals("[]") != true) {
          return 0;
        }
      }
    }
    return (s.empty() == true) ? 1 : 0;
  }

  public static Stack < Integer > sortStack(Stack < Integer > input) {
    //write your code here
    Stack<Integer> temp = new Stack<Integer>();
    while(input.empty() == false){
      int val = input.pop();
      if(temp.empty() == true)
        temp.push(val);
      else if(temp.empty() == false && val >= temp.peek())
        temp.push(val);
      else{
        while(temp.empty() == false){
          if(val < temp.peek()){
            input.push(temp.pop());
          }
          else
            break;
        }
        temp.push(val);
      }
    }
    return temp;
  }
}
